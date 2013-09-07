public class Test {
  public static void main(String[] args) {
    // write in initial, raw data
    FileStore fstore = new FileStore();
    Comparable[][] vs = {{"hello", new Integer(1)}, {"goodbye", new Integer(2)}};
    fstore.write(vs);

    // add a value to the data-store
    Comparable[] insertion = {"sup", new Integer(3)};
    fstore.add(insertion);
    
    // manipulate the model
    System.out.print("# Filtering\n");
    fstore.find(new Integer(0), "hello");
    System.out.print("# Raw Data\n");
    fstore.render();
  }
}
