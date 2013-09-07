public interface FuzzyComparable extends Comparable {
  public Boolean matches(Comparable prospect);
  // TODO: switch from basis on Comparable to basis on
  //       FuzzyComparable. This will allow for easy search.
}
