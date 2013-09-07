public class RawDataStore extends DataStore {
  public Comparable[][] read() {
    return model;
  }
  public void write(Comparable[][] data) {
    model = data;
  };
  public RawDataStore(Comparable[][] data) {
    model = data;
  }
}
