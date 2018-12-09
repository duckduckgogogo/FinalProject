import java.util.ArrayList;
import java.awt.Color;

public class Player {

  private final Color MYPLAYERCOLOR;
  //ArrayList<Card> myCardArrayList = new ArrayList<Card>();
  //ArrayList<Country> myCountryArrayList = new ArrayList<Country>();
  private int numCountries;
  private int numContinents;
  private static int deckCounter = 0;
  final int MYNUM;
  private int numCards;

  public Player (int i) {
    this.numCountries = 0;
    this.numContinents = 0;
    this.numCards = 0;
    MYNUM = i;

    if (i == 0) {
      MYPLAYERCOLOR = Color.RED;
    }
    else if (i == 1) {
      MYPLAYERCOLOR = Color.ORANGE;
    }
    else if (i == 2) {
      MYPLAYERCOLOR = Color.YELLOW;
    }
    else if (i == 3) {
      MYPLAYERCOLOR = Color.GREEN;
    }
    else {
      MYPLAYERCOLOR = Color.BLUE;
    }
  }


  public void addCard () {
    if (deckCounter >= World.TOTALNUMCOUNTRIES) {
      System.out.println ("No cards left in the deck.");
      return;
    }
    World.cardsArray[deckCounter].setOwner(MYNUM);
  }

  //Can only redeem all cards at once
  public void subtractCard () {
    numCards = 0;
  }

  public int getNumCards () {
    return numCards;
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
