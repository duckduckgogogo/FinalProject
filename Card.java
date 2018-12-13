// =============================================================================
/**
* Objects of the Card class track their owner.
*
* @author Ashira Mawji & Shu Amano
**/
// =============================================================================



// =============================================================================
// IMPORTS

public class Card {
  final private int COUNTRY;
  private boolean available;
  private int owner;

  public Card (int a) {
    this.owner = 10;
    this.COUNTRY = a;
  }

  public boolean getAvailability() {
    return available;
  }

  public int getOwner () {
    return owner;
  }

  public void setOwner (int i) {
    owner = i;
  }

}
