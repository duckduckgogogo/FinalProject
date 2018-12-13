// =============================================================================
/**
* Objects of the Player class track their number of countries, color, number of
* armies, number of cards, and Player number
*
* @author Ashira Mawji & Shu Amano
**/
// =============================================================================


// =============================================================================
// IMPORTS
import java.util.ArrayList;
import java.awt.Color;

// =============================================================================
public class Player {

// =============================================================================
// INSTANCE FIELDS
  private final Color MYPLAYERCOLOR;
  private int numCountries;
  private final int MYNUM;
  private int numCards;
  private int numArmies;

// =============================================================================
// CONSTRUCTOR
  public Player (int i) {
    this.numCountries = 0;
    this.numContinents = 0;
    this.numCards = 0;
    this.numArmies = 0;
    MYNUM = i;
    // Set color based on Player number
    if (i == 0) {
      MYPLAYERCOLOR = Color.RED;
    }
    else if (i == 1) {
      MYPLAYERCOLOR = Color.ORANGE;
    }
    else if (i == 2) {
      MYPLAYERCOLOR = Color.BLUE;
    }
    else if (i == 3) {
      MYPLAYERCOLOR = Color.CYAN;
    }
    else {
      MYPLAYERCOLOR = Color.LIGHT_GRAY;
    }
  }

// =============================================================================
// getMyNum(): getter method for MYNUM
  public int getMyNum() {
    return MYNUM;
  }

// =============================================================================
// addCard(): setter method for numCards 
  public void addCard () {
    numCards++;
  }

// =============================================================================
// getNumArmies()
  public int getNumArmies() {
    return numArmies;
  }

  public void addArmies (int i) {
    numArmies += i;
  }

  //Can only redeem all cards at once
  public void subtractCards () {
    numCards = 0;
  }

  public int getNumCards () {
    return numCards;
  }

  public void addCountry() {
    numCountries++;
  }

  public void subtractCountry() {
    numCountries--;
  }

  public int getNumCountries() {
    return numCountries;
  }

  public int getNumContinents() {
    return numContinents;
  }

  public Color getMyColor () {
    return MYPLAYERCOLOR;
  }

  public int countNumArmiesToCollect (/*something*/) {
    return (numCountries/3 + numContinents);
  }

}
