import java.util.ArrayList;
import java.awt.Color;

public class Player {

  private final Color MYPLAYERCOLOR;
  ArrayList<Card> myCardArrayList = new ArrayList<Card>();
  ArrayList<Country> myCountryArrayList = new ArrayList<Country>();
  private int numCountries;
  private int numContinents;

  public Player (Color c) {
    this.MYPLAYERCOLOR = c;
    this.numCountries = 0;
    this.numContinents = 0;
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
