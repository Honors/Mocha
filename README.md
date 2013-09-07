# Mocha
Mocha provides simple persistent models for Java. Arbitrary types
are allowed, so long as they implement `Comparable`, and in the
future, so long as they implement `FuzzyComparable`.

## Usage
### DataStores
A class choosing to extend `DataStore` receives the following
functions for the manipulation of the model. Note that any
`DataStore` is required to provide a `read` and `write` method
which will return a `Comparable[][]` model and accept such a
model respectively.

```java
public void append(Comparable[] row);
```

The function `append` allows for a single row to be added to the
model and written to file.

```java
public void render();
```

The `render` function renders a given model as comma-delimited
rows written in series.

```java
public Comparable[][] find(int col, Comparable match);
```

The function `find` when accepting a single `int` and `Comparable`
will return all rows with the given value in the provided column.

```java
public Comparable[][] find(int[] cols, Comparable[] matches);
```

Similarly, `find` when accepting arrays of both `int` and 
`Comparable` will return only the rows matching each column-value
pair.

### FileStores
The class `FileStore` extends `DataStore` to persist to file upon
`read` and `write`. Its constructor syntax is either the following.

```java
public FileStore(String file, Comparable[][] data);
public FileStore(String file);
```

In the former, a file and data with which to initialize it are
provided. In the latter, a file alone is presented. The methods of
interaction with `FileStores` are those provided by the `DataStore`
abstract. Note that the `read` and `write` functions are too
implementation specific and should be avoided in favor of the
higher-level interfaces.
