import java.io.*;
import java.net.*;
import java.util.*;
public class FileStore extends DataStore {
  public String file;
  public void write() {
    write(model());
  }
  public void write(Comparable[][] vs) {
    model = vs;
    FileOutputStream fileOut = null;
    try {
      fileOut = new FileOutputStream(file);
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
      fileIn = new FileInputStream(file);
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
  public FileStore(String file, Comparable[][] data) {
    this.file = file;
    model = data;
    write();
  }
  public FileStore(String file) {
    this.file = file;
    model = read();
  }
}
