import java.util.ArrayList;
import java.awt.Color;

public class Player {

  private final Color MYPLAYERCOLOR;
  //ArrayList<Card> myCardArrayList = new ArrayList<Card>();
  //ArrayList<Country> myCountryArrayList = new ArrayList<Country>();
  private int numCountries;
  private int numContinents;
  private static int deckCounter = 0;
  private final int MYNUM;
  private int numCards;
  private int numArmies;

  public Player (int i) {
    this.numCountries = 0;
    this.numContinents = 0;
    this.numCards = 0;
    this.numArmies = 0;
    MYNUM = i;

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

  public int getMyNum() {
    return MYNUM;
  }

  public void addCard () {
    if (deckCounter >= World.TOTALNUMCOUNTRIES) {
      System.out.println ("No cards left in the deck.");
      return;
    }
    World.cardsArray[deckCounter].setOwner(MYNUM);
  }

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
