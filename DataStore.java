import java.util.*;
public abstract class DataStore {
  public abstract void write(Comparable[][] vs);
  public abstract Comparable[][] read();
  public Comparable[][] model;

  public Comparable[][] model() {
    if( model == null ) {
      return read();
    } else {
      return model;
    }
  }
  public void add(Comparable[] row) {
    Comparable[][] old = read();
    Comparable[][] newd = new Comparable[old.length+1][old[0].length];
    int i = 0;
    for( Comparable[] orow : old ) {
      newd[i++] = orow;
    }
    newd[i] = row;
    write(newd);
  }
  public void render() {
    Comparable[][] data = model();
    for( Comparable[] datum : data ) {
      for( Comparable part : datum ) {
        System.out.print(part + ", ");
      }
      System.out.print("\n");
    }
  }
  public Comparable[][] find(int col, Comparable match) {
    // TOOD: add a schema and strict type checking
    Comparable[][] vs = model();
    Comparable[][] resp = {};
    for( Comparable[] v : vs ) {
      if( v[col].equals(match) ) {
        // For matching rows, mutate the array by means of a
	// reshape and appending.
        Comparable[][] newR = new Comparable[resp.length+1][v.length];
	int i = 0;
	for( Comparable[] row : resp ) {
          newR[i++] = row;
	}
	newR[i] = v;
	resp = newR;
      }
    }
    return resp;
  }
  public Comparable[][] find(int[] cols, Comparable[] matches) {
    if( matches.length == 0 ) {
      return model;
    }
    int[] colShift = new int[cols.length-1];
    Comparable[] matchShift = new Comparable[cols.length-1];
    int i = 0;
    while( i < cols.length-1 ) {
      colShift[i] = cols[i+1];
      matchShift[i] = matches[i+1];
      i++;
    }
    return (new RawDataStore(find(cols[0], matches[0]))).find(colShift, matchShift);
  }
}
