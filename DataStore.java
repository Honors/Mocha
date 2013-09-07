public abstract class DataStore {
  public abstract void write(Comparable[][] vs);
  public abstract Comparable[][] read();

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
    Comparable[][] data = read();
    for( Comparable[] datum : data ) {
      for( Comparable part : datum ) {
        System.out.print(part + ", ");
      }
      System.out.print("\n");
    }
  }
  public void find(Integer col, Comparable match) {
    // TOOD: add a schema and strict type checking

    Comparable[][] vs = read();

    for( Comparable[] v : vs ) {
      if( v[col].equals(match) ) {
        System.out.print(v[col]+"\n");
      }
    }
  }
}
