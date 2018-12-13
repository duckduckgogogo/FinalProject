// =============================================================================
/**
* Objects of the Country class keep track of the Player occupying them and their
* Graphics specifications
*
* @author Ashira Mawji & Shu Amano
**/
// =============================================================================


// =============================================================================
// IMPORTS
import java.awt.Color;
import java.awt.Graphics;

// =============================================================================
public class Country {

// =============================================================================
// INSTANCE FIELDS
  private int numArmies;
  private final int CONTINENT;
  final String NAME;
  private final int POSX;
  private final int POSY;
  private final int COUNTRYHEIGHT;
  private final int COUNTRYWIDTH;
  private final Color MYCOLOR;
  private Color armyColor;
  private int owner = 10;
  private int ARRAYPOS;

// ===========================================================================
// CONSTRUCTOR: initializes variables

  public Country(String b, int d, int e, int width, int height, int continent) {
    this.numArmies = 0;
    this.CONTINENT = continent;
    this.COUNTRYHEIGHT = height;
    this.COUNTRYWIDTH = width;
    this.NAME = b;
    this.POSX = d;
    this.POSY = e;
    this.ARRAYPOS = 0;
    this.armyColor = Color.WHITE;
    //Determine Country's color based on its continent
    if (CONTINENT == 1) {
    	this.MYCOLOR = new Color(216,191,216);
    } else if (CONTINENT == 2){
    	this.MYCOLOR = new Color(218,112,214);
    } else if (CONTINENT == 3){
    	this.MYCOLOR = new Color(255,0,255);
    } else if (CONTINENT == 4){
    	this.MYCOLOR = new Color(148,0,211);
    } else if (CONTINENT == 5){
    	this.MYCOLOR = new Color(147,112,219);
    } else if (CONTINENT == 6) {
    	this.MYCOLOR = new Color(139,0,139);
    } else {
    	this.MYCOLOR = new Color(75,0,130);
    }
  }

// =============================================================================
// getArrayPos(): getter method for ARRAYPOS
  public int getArrayPos () {
    return ARRAYPOS;
  }

// =============================================================================
// getOwner(): getter method for owner
  public int getOwner () {
    return owner;
  }

// =============================================================================
//setOwner(): setter method for owner and armyColor
  public void setOwner (int i) {
    owner = i;
    if (i == 0) {
      setArmyColor(Color.RED);
    }
    else if (i == 1) {
    	setArmyColor(Color.CYAN);
    }
    else if (i == 2) {
      setArmyColor(new Color(255,152,0));
    }
    else if (i == 3){
        setArmyColor(new Color(0,204,0));
      }
    else if (i == 4) {
        setArmyColor(Color.YELLOW);
    }
     else {
      setArmyColor(new Color(160,160,160));
    }
  }

// =============================================================================
// getNumArmies(): getter method for numArmies
  public int getNumArmies () {
    return numArmies;
  }

// =============================================================================
// addArmy(): setter method for numArmies
// Increases number of armies on Country by specified amount
  public void addArmy (int a) {
    numArmies += a;
  }

// =============================================================================
// subtractArmy(): setter method for numArmies
// Decreases number of armies on Country by specified amount
  public void subtractArmy (int a) {
    numArmies -= a;
  }

// =============================================================================
// getContinent(): getter method for CONTINENT
  public int getContinent () {
    return CONTINENT;
  }

// =============================================================================
// getPosX(): getter method for POSX
  public int getPosX () {
    return POSX;
  }

// =============================================================================
// getPosY(): getter method for POSY
  public int getPosY () {
    return POSY;
  }

// =============================================================================
// getName(): getter method for NAME
  public String getName () {
    return NAME;
  }

// =============================================================================
// getColor(): getter method for MYCOLOR
  public Color getColor () {
    return MYCOLOR;
  }

// =============================================================================
// getHeight(): getter method for COUNTRYHEIGHT
  public int getHeight () {
	  return COUNTRYHEIGHT;
  }

// =============================================================================
// getWidth(): getter method for COUNTRYWIDTH
  public int getWidth () {
	  return COUNTRYWIDTH;
  }

// =============================================================================
// setArmyColor(): setter method for armyColor
  public void setArmyColor (Color c) {
    armyColor = c;
  }
  

//=============================================================================
//setArrayPos(): setter method for ARRAYPOS
 public void setArrayPos(int pos) {
    ARRAYPOS = pos;
 }

// =============================================================================
// drawCountry(): draws Country's shape, name, and number of armies
  public void drawCountry(Graphics g) {
    g.setColor(MYCOLOR);
    g.fillRect(POSX, POSY, COUNTRYWIDTH, COUNTRYHEIGHT);
    g.setColor(armyColor);
    g.drawString(Integer.toString(numArmies), POSX, POSY+30);
    g.drawString(NAME, POSX, POSY+10);
  }

// =============================================================================
// isIn(): checks whether a given point falls inside this Country
  public boolean isIn (int x, int y) {
    if ((x >= POSX) && (x <= (POSX+COUNTRYWIDTH)) && (y >= POSY) && (y <= (POSY + COUNTRYHEIGHT))) {
      return true;
    }
    return false;
  }

}
// class Country
// =============================================================================
