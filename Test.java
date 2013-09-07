public class Test {
  public static void main(String[] args) {
    // write in initial, raw data
    Comparable[][] vs = {{"hello", new Integer(1)}, {"goodbye", new Integer(2)}};
    FileStore fstore = new FileStore(vs);
    fstore.write();

    // add a value to the data-store
    Comparable[] insertion = {"sup", new Integer(3)};
    fstore.add(insertion);
    
    // filter and render the model
    System.out.print("# Filtering\n");
    Comparable[][] subset = fstore.find(0, "hello");
    new FileStore(subset).render();

    System.out.print("# Raw Data\n");
    fstore.render();    
  }
}
