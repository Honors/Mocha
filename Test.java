public class Test {
  public static void main(String[] args) {
    // read in data from file
    System.out.print("# Read Data\n");
    FileStore read = new FileStore("/Users/mattneary/Desktop/School/Honors Java/Parking/out.txt");
    read.render();

    // write out raw data
    System.out.print("# Written Data\n");
    Comparable[][] vs = {{"hello", new Integer(1)}, {"goodbye", new Integer(2)}};
    FileStore fstore = new FileStore("/Users/mattneary/Desktop/School/Honors Java/Parking/out.txt", vs);
    fstore.write();
    fstore.render(); 

    // add a value to the data-store
    System.out.print("# Manipulated Data\n");
    Comparable[] insertion = {"sup", new Integer(3)};
    fstore.add(insertion);
    fstore.render(); 
    
    // filter and render the model      
    System.out.print("# Filtered Data\n");
    Comparable[][] subset = fstore.find(0, "hello");
    new RawDataStore(subset).render();     
  }
}
