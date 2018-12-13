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
// getNumArmies(): getter method for numArmies
  public int getNumArmies() {
    return numArmies;
  }

// =============================================================================
// addArmies(): setter method for numArmies, increases by specified amount
  public void addArmies (int i) {
    numArmies += i;
  }

// =============================================================================
// subtractCards(): setter method for numArmies, resets number of cards to 0
  public void subtractCards () {
    numCards = 0;
  }

// =============================================================================
// getNumCards(): getter method for numCards
  public int getNumCards () {
    return numCards;
  }

// =============================================================================
// addCountry(): setter method for numCountries, increments by 1
  public void addCountry() {
    numCountries++;
  }

// =============================================================================
// subtractCountry(): setter method for numCountries, decrements by 1
  public void subtractCountry() {
    numCountries--;
  }

// =============================================================================
// getNumCountries(): getter method for numCountries
  public int getNumCountries() {
    return numCountries;
  }

// =============================================================================
// getMyColor(): getter method for MYPLAYERCOLOR
  public Color getMyColor () {
    return MYPLAYERCOLOR;
  }

// =============================================================================
// countNumArmiesToCollect(): counts number of armies for Player to collect
  public int countNumArmiesToCollect () {
    return (numCountries/3);
  }

}
// class Player
// =============================================================================
