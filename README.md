# Mocha
Mocha provides simple persistent models for Java. Arbitrary types
are allowed, so long as they implement `Comparable`, and in the
future, so long as they implement `FuzzyComparable`.

## Features
A class choosing to extend `DataStore` receives the following
functions for the manipulation of the model.

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
