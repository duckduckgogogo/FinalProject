import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class Main extends JPanel {

  final int HEIGHT = 500;
  final int WIDTH = 500;
  public static Scanner keyboard = new Scanner (System.in);
  World world;
  static boolean GAMEOVER = false;
  static int state = 0; //Necessary?
  static int NUMPLAYERS;

  public Main () {
    world = new World();
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  public static void main (String[] args) {

    //Frame
    JFrame frame = new JFrame ("Risky Business.");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Main mainInstance = new Main();
    frame.setContentPane(mainInstance);
    frame.pack();
    frame.setVisible(true);

    //Initialize playerArray
    Object[] numPlayerOptions = {2, 3, 4, 5, 6};
    Object numPlayersDialog = JOptionPane.showInputDialog(null, "Number of players?", "Number of Players", JOptionPane.PLAIN_MESSAGE, null, numPlayerOptions, numPlayerOptions[0]);
    NUMPLAYERS = (int)numPlayersDialog;
    Player[] playerArray = new Player[NUMPLAYERS];
    for (int i = 0; i < NUMPLAYERS; i++) {
      playerArray[i] = new Player(i);
    }

    //Initially assignment of countries to players
    int order = 0;
    for (int i = 0; i < World.TOTALNUMCOUNTRIES; i++) {
      World.countriesArray[chooseCountry()].setOwner(playerArray[order].MYNUM);
      if (order == (NUMPLAYERS-1)) {
        order = 0;
      }
      else {
        order++;
      }
    }

    //Game play
    order = 0;
    while (GAMEOVER == false) {
      play(playerArray[order]);

      order = endTurn(order);

    }




    //Graphics g;
    //w.drawCountries(g);
  }

  //WHAT DOES PAINTCOMPONENT DO?
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0,0, HEIGHT, WIDTH);
    world.drawCountries(g);
  }

  //SHU: MOUSE ACTION LISTENER
  public static int chooseCountry () {
    /*
    if not a country, then print "Not a country"
    else return country
    */
    return World.countriesArray[0].getArrayPos();
  }

  public static void play (Player p) {

  }

  public static void collectArmies() {

  }

  //Cash cards: add armies, subtract cards
  public static void cashCards(Player p) {
    p.addArmies(p.getNumCards());
    p.subtractCard();
  }

  public static void placeArmies() {

  }

  public static void attack() {

  }

  public static void moveArmies() {

  }

  public static int endTurn (int order) {
    if (order == (NUMPLAYERS-1)) {
      order = 0;
    }
    else {
      order++;
    }
    return order;
  }
}
