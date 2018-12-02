public class Country {
  //private int playerInControl;
  private int numArmies;
  private final int CONTINENT;
  //final boolean CAPITAL;
  final String NAME;

  public Country (int a, int b, String c) {
    this.numArmies = a;
    this.CONTINENT = b;
    this.NAME = c;
  }

  public int getNumArmies () {
    return numArmies;
  }

  public int getContinent () {
    return CONTINENT;
  }

  public String getName () {
    return NAME;
  }

  public void drawCountry() {

  }





}
