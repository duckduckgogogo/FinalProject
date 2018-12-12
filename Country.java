<<<<<<< HEAD
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
  final int ARMYDIM = 5;

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
    if (i == 0) {
      setArmyColor(Color.RED);
    }
    else if (i == 1) {
      setArmyColor(Color.ORANGE);
    }
    else if (i == 2) {
      setArmyColor(Color.YELLOW);
    }
    else if (i == 3) {
      setArmyColor(Color.GREEN);
    }
    else {
      setArmyColor(Color.BLUE);
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

  public void setArmyColor (Color c) {
    armyColor = c;
  }

  public void drawCountry(Graphics g) {
    g.setColor(MYCOLOR);
    g.fillRect(POSX, POSY, COUNTRYHEIGHT, COUNTRYWIDTH);
    g.setColor(armyColor);
    g.drawString(Integer.toString(numArmies), POSX, POSY);
  }

  public boolean isIn (int x, int y) {
    if ((x >= POSX) && (x <= (POSX+COUNTRYWIDTH)) && (y >= POSY) && (y <= (POSY + COUNTRYHEIGHT))) {
      return true;
    }
    return false;
  }





}
=======
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

  public Country (String b, int d, int e, int width, int height, int continent) /*int[] a*/ {
    this.numArmies = 0;
    this.CONTINENT = continent;
    this.COUNTRYHEIGHT = height;
    this.COUNTRYWIDTH = width;
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
  
  public int getWidth() {
	  return COUNTRYWIDTH;
  }
  
  public int getHeight() {
	  return COUNTRYHEIGHT;
  }

  public void setArmyColor (Color c) {
    armyColor = c;
  }
  
  public void drawCountry(Graphics g) {
    g.setColor(MYCOLOR);
    g.fillRect(POSX, POSY, COUNTRYWIDTH, COUNTRYHEIGHT);
    g.setColor(armyColor);
  }

  public boolean isIn (int x, int y) {
    if ((x >= POSX) && (x <= (POSX+COUNTRYWIDTH)) && (y >= POSY) && (y <= (POSY + COUNTRYHEIGHT))) {
      return true;
    }
    return false;
  }





}
>>>>>>> 5620678d3f6d128b466764a94a4202638a97217b
