import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;

public class Main {

  /*public Main () {

  }*/

  public static Scanner keyboard = new Scanner (System.in);


  public static void main (String[] args) {
	  World w = new World();

	  //Initialize playerArray
	  ArrayList<Player> playerArrayList = new ArrayList<Player>();

	  //Instantiate playerArrayList
    //DIALOG BOX
    System.out.println ("Number of players: ");
    final int NUMPLAYERS = keyboard.nextInt();
    String s;
    Color c;

    for (int i = 0; i < NUMPLAYERS; i++) {
      //DIALOG BOX
      System.out.println ("Color?");
      s = keyboard.nextLine();
      //c = Color.parseColor(s);
      playerArrayList.add(new Player(Color.GREEN));
    }

    /*while (GAMEOVER == false) {
      play(playerArrayList.get(i));
      if (i == numPlayers) {
        i = 0;
      }
      else {
        i++;
      }
    }*/
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
