public class Card {
  final private int COUNTRY;
  //final private int NUMSTARS;
  private boolean available;
  private int owner = 10;

  public Card (int a /*, int b*/) {
    this.COUNTRY = a;
    this.available = true;
    //this.NUMSTARS = b;
  }

  public int getCountry () {
    return COUNTRY;
  }

  /*public int getNumStars() {
    return NUMSTARS;
  }*/

  public boolean getAvailability() {
    return available;
  }

  public int getOwner () {
    return owner;
  }

  public void setOwner (int i) {
    owner = i;
  }

  /*
  public void drawCard() {

  }
  */

}
