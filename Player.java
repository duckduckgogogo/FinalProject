import java.util.ArrayList;
import java.awt.Color;

public class Player {

  private final Color MYPLAYERCOLOR;
  ArrayList<Card> myCardArrayList = new ArrayList<Card>();
  ArrayList<Country> myCountryArrayList = new ArrayList<Country>();
  private int numCountries;
  private int numContinents;

  public Player (int i) {
    this.numCountries = 0;
    this.numContinents = 0;
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

  public void addCard (Card c) {
    myCardArrayList.add(c);
  }

  public void subtractCard (Card c) {
    myCardArrayList.remove(c);
  }

  public Color getMyColor () {
    return MYPLAYERCOLOR;
  }

  public int countNumArmiesToCollect (/*something*/) {
    return (numCountries/3 + numContinents);
  }

}
