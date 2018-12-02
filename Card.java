public class Card {
  final private int COUNTRY;
  final private int NUMSTARS;

  public Card (int a, int b) {
    this.COUNTRY = a;
    this.NUMSTARS = b;
  }

  public int getCountry () {
    return COUNTRY;
  }

  public int getNumStars() {
    return NUMSTARS;
  }


}
