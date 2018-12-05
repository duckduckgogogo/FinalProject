public class Main {

  /*public Main () {

  }*/

  public static void main (String[] args) {
	  World w = new World();

	  //Initialize playerArrayList
	  ArrayList<Player> playerArrayList = new ArrayList<Player>();

	  //Instantiate playerArrayList
    for (int i = 0; i < numPlayers; i++) {
      //DIALOG BOX
      System.out.println ("Color?");
      Color c = scan.nextLine().parseColor();
      playerArrayList.add(new Player(c));
    }

    while (GAMEOVER == false) {
      play(playerArrayList.get(i));
      if (i == numPlayers) {
        i = 0;
      }
      else {
        i++;
      }
    }
  }

  public void play (Player p) {

  }

  public void collectArmies() {

  }

  public void cashCards() {

  }

  public void placeArmies() {

  }

  public void attack() {

  }

  public void moveArmies() {

  }

  public void endTurn () {

  }

}
