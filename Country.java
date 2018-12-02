public class Country {
  //private int playerInControl;
  private int numArmies;
  private final int CONTINENT;
  //final boolean CAPITAL;
  final String NAME;
  private final int POSX;
  private final int POSY;
  private final Color MYCOLOR;

  public Country (int a, int b, String c, Color d, int x, int y) {
    this.numArmies = a;
    this.CONTINENT = b;
    this.NAME = c;
    this.MYCOLOR = d;
  }

  public int getNumArmies () {
    return numArmies;
  }

  public int getContinent () {
    return CONTINENT;
  }

  public int getPosX () {

  }

  public int getPosY () {

  }

  public String getName () {
    return NAME;
  }

  public void drawCountry() {

  }





}
