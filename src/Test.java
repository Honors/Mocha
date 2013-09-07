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
    fstore.render(); 

    // add a value to the data-store
    System.out.print("# Manipulated Data\n");
    Comparable[] insertion = {"sup", new Integer(2)};
    fstore.append(insertion);
    fstore.render(); 
    
    // filter and render the model  
    // NB: filtering can be doen with a single col-value pair or 
    //     with a recursively evaluated sequence of these pairs.
    System.out.print("# Filtered Data\n");
    int[] cols = {1, 0};
    Comparable[] values = {new Integer(2), "sup"};
    Comparable[][] subset = fstore.find(cols, values);
    new RawDataStore(subset).render();     
  }
}
