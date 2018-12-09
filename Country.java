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
  final int COUNTRYHEIGHT = 10;
  final int COUNTRYWIDTH = 10;
  private final Color MYCOLOR;
  private Color armyColor;
  private int owner = 10;
  final private int ARRAYPOS;

  public Country (String b, int d, int e /*int[] a*/) {
    this.numArmies = 0;
    this.NAME = b;
    //this.MYCOLOR = c;
    this.POSX = d;
    this.POSY = e;
    this.MYCOLOR = Color.BLUE;
    this.ARRAYPOS = 0;

    //Set color based on continent

    /*this.CONTINENT = a[0].parseInt();
    this.NAME = a[1];
    this.MYCOLOR = a[2].parseColor();
    this.POSX = a[3].parseInt();
    this.POSY = a[4].parseInt();*/
    //this.owner = e;
  }

  public int getArrayPos () {
    return ARRAYPOS;
  }

  public int getOwner () {
    return owner;
  }

  public void setOwner (int i) {
    owner = i;
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

  public boolean isIn (int x, int y) {
    if ((x >= POSX) && (x <= (POSX+COUNTRYWIDTH)) && (y >= POSY) && (y <= (POSY + COUNTRYHEIGHT))) {
      return true;
    }
    return false;
  }





}
