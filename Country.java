import java.awt.Color;
import java.awt.Graphics;

public class Country {
  //private int playerInControl;
  private int numArmies;
  private final int CONTINENT;
  //final boolean CAPITAL;
  final String NAME;
  private final int POSX;
  private final int POSY;
  private final int COUNTRYHEIGHT;
  private final int COUNTRYWIDTH;
  private final Color MYCOLOR;
  private Color armyColor;
  private int owner = 10;
  final private int ARRAYPOS;

  public Country(String b, int d, int e, int width, int height, int continent) /*int[] a*/ {
    this.numArmies = 0;
    this.CONTINENT = continent;
    this.COUNTRYHEIGHT = height;
    this.COUNTRYWIDTH = width;
    this.NAME = b;
    //this.MYCOLOR = c;
    this.POSX = d;
    this.POSY = e;
    this.ARRAYPOS = 0;
    if (continent == 1) {
    	this.MYCOLOR = new Color(216,191,216);
    } else if (continent == 2){
    	this.MYCOLOR = new Color(218,112,214);
    } else if (continent == 3){
    	this.MYCOLOR = new Color(255,0,255);
    } else if (continent == 4){
    	this.MYCOLOR = new Color(148,0,211);
    } else if (continent == 5){
    	this.MYCOLOR = new Color(147,112,219);
    } else if (continent == 6) {
    	this.MYCOLOR = new Color(139,0,139);
    } else {
    	this.MYCOLOR = new Color(75,0,130);
    }


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
    if (i == 0) {
      setArmyColor(Color.RED);
    }
    else if (i == 1) {
      setArmyColor(new Color(255,152,0));
    }
    else if (i == 2) {
      setArmyColor(Color.YELLOW);
    }
    else if (i == 3) {
      setArmyColor(Color.CYAN);
    }
    else if (i == 4){
      setArmyColor(new Color(0,204,0));
    } else {
      setArmyColor(new Color(160,160,160));
    }
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

  public int getHeight () {
	  return COUNTRYHEIGHT;
  }

  public int getWidth () {
	  return COUNTRYWIDTH;
  }

  public void setArmyColor (Color c) {
    armyColor = c;
  }

  public void drawCountry(Graphics g) {
    g.setColor(MYCOLOR);
    g.fillRect(POSX, POSY, COUNTRYWIDTH, COUNTRYHEIGHT);
    if	(owner == 10) {
    	g.setColor(Color.WHITE);
    	g.drawString(Integer.toString(numArmies), POSX, POSY+30);
    } else {
    	g.setColor(armyColor);
    	g.drawString(Integer.toString(numArmies), POSX, POSY+30);
    }
    g.drawString(NAME, POSX, POSY+10);
  }

  public boolean isIn (int x, int y) {
    if ((x >= POSX) && (x <= (POSX+COUNTRYWIDTH)) && (y >= POSY) && (y <= (POSY + COUNTRYHEIGHT))) {
      return true;
    }
    return false;
  }

}
