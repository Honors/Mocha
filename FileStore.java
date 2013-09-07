import java.io.*;
import java.net.*;
import java.util.*;
public class FileStore extends DataStore {
  public void write() {
    write(model());
  }
  public void write(Comparable[][] vs) {
    model = vs;
    FileOutputStream fileOut = null;
    try {
      fileOut = new FileOutputStream("/Users/mattneary/Desktop/School/Honors Java/Parking/out.txt");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(vs);
      out.close();
    } catch(IOException e) {
      System.out.print("Error! " + e + "\n");
    }    
  }
  public Comparable[][] read() {
    FileInputStream fileIn = null;
    Comparable[][] data = null;
    try {
      fileIn = new FileInputStream("/Users/mattneary/Desktop/School/Honors Java/Parking/out.txt");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      data = (Comparable[][])in.readObject();
    } catch(IOException e) {
      System.out.print("Error! " + e + "\n");
    } catch (ClassNotFoundException e) {
      System.out.print("Error! " + e + "\n");
    } finally {
      // TODO: close stream...
    }

    model = data;
    return data;
  }
  public FileStore(Comparable[][] data) {
    model = data;
  }
}
