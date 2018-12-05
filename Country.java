import java.awt.Color;
import java.awt.Graphics;

public class Country {
  //private int playerInControl;
  private int numArmies;
  private final int CONTINENT = 0;
  //final boolean CAPITAL;
  final String NAME;
  private final int POSX;
  private final int POSY;
  final int COUNTRYHEIGHT = 100;
  final int COUNTRYWIDTH = 100;
  private final Color MYCOLOR;
  private Color armyColor;
  //private int owner;

  public Country (String b, Color c, int d, int e /*int[] a*/) {
    this.numArmies = 0;
    this.NAME = b;
    this.MYCOLOR = c;
    this.POSX = d;
    this.POSY = e;
    /*this.CONTINENT = a[0].parseInt();
    this.NAME = a[1];
    this.MYCOLOR = a[2].parseColor();
    this.POSX = a[3].parseInt();
    this.POSY = a[4].parseInt();*/
    //this.owner = e;
  }

  public int getNumArmies () {
    return numArmies;
  }

  public void addArmy (int a) {
    numArmies += a;
  }

  public void subtractArmy (int a) {
    numArmies -= a;
  }

  public int getContinent () {
    return CONTINENT;
  }

  public int getPosX () {
    return POSX;
  }

  public int getPosY () {
    return POSY;
  }

  public String getName () {
    return NAME;
  }

  public Color getColor () {
    return MYCOLOR;
  }

  public void setArmyColor (Color c) {
    armyColor = c;
  }

  public void drawCountry(Graphics g) {
    g.setColor(MYCOLOR);
    g.fillRect(POSX, POSY, COUNTRYHEIGHT, COUNTRYWIDTH);
    g.setColor(armyColor);
  }





}
