import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Main extends JPanel {

  final int HEIGHT = 500;
  final int WIDTH = 500;
  public static Scanner keyboard = new Scanner (System.in);
  World world;

  public Main () {
    world = new World();
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  public static void main (String[] args) {
	  JFrame frame = new JFrame ("Risky Business.");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Main mainInstance = new Main();
    frame.setContentPane(mainInstance);
    frame.pack();
    frame.setVisible(true);

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
    //Graphics g;
    //w.drawCountries(g);
  }

  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0,0, HEIGHT, WIDTH);
    world.drawCountries(g);
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
