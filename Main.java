import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Main extends JPanel implements MouseListener{
  static int mouseX;
  static int mouseY;
  final int HEIGHT = 500;
  final int WIDTH = 500;
  public static Scanner keyboard = new Scanner (System.in);
  static World w;
  static boolean GAMEOVER = false;
  static int state = 0; //Necessary?
  static int NUMPLAYERS;

  public Main () {
    w = new World();
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    addMouseListener(this);
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
    final int NUMPLAYERS = (int)numPlayersDialog;
    Player[] playerArray = new Player[NUMPLAYERS];
    for (int i = 0; i < NUMPLAYERS; i++) {
      playerArray[i] = new Player(i);
    }

    //Initially assignment of countries to players
    int order = 0;
    for (int i = 0; i < w.TOTALNUMCOUNTRIES; i++) {
      w.countriesArray[chooseCountry()].setOwner(playerArray[order].getMyNum());
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
    w.drawCountries(g);
  }

  //SHU: MOUSE ACTION LISTENER
  public static int chooseCountry(){
    mouseX = -1;
    mouseY = -1;

    int tempX = -1;
    int tempY = -1;

    while (true) {
      if ((mouseX == tempX) && (mouseY == tempY)) {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      else {
        tempX = mouseX;
        tempY = mouseY;
        for (int i = 0; i < w.TOTALNUMCOUNTRIES; i++) {
          int x = w.countriesArray[i].getPosX();
          int y = w.countriesArray[i].getPosY();
          // CHANGE COUNTRY HEIGHT VALUE
          if (w.countriesArray[i].isIn(mouseX,mouseY)) {
            System.out.println(i);
            return i;
          }
        }
        System.out.println("That is not a country. Please click on a country.");
      }
    }
  }

  public static void play (Player p) {

  }

  /*public static void collectArmies(Player p) {
    int i = p.getNumCountries() /3 + p.getNumContinents();

    //If cash cards... BUTTON
    i += cashCards(p);
    return i;
  }*/

  //Cash cards: add armies, subtract cards
  public static int cashCards(Player p) {
    p.subtractCard();
    return p.getNumCards()/3;
  }

  //MOUSE LISTENER
  public static void placeArmies(Player p) {
    int count = p.countNumArmiesToCollect();
    //If true...
    count += cashCards(p);
    int temp;

    for (int i = 0; i < count; i++) {
      while (w.countriesArray[chooseCountry()].getOwner() != p.getMyNum()) {
        System.out.println ("Choose one of your countries.");
      }
      w.countriesArray[chooseCountry()].addArmy(1);
    }
  }

  public static void attack(Player p) {
    while (w.countriesArray[chooseCountry()].getOwner() != p.getMyNum()) {
      System.out.println ("Choose one of your own countries.");
    }

    //You have chosen country a.
    //Choose country b.
    //While isConnected == false, re-choose.
    /*
    for (int i = 0; i < countryArray[a].getNumArmies())

    */

  }

  public static void moveArmies() {

  }

  public static int endTurn (int o) {
    if (o == (NUMPLAYERS-1)) {
      return 0;
    }
    else {
      o++;
    }
    return o;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }
  @Override
  public void mouseEntered(MouseEvent e) {
  }
  @Override
  public void mouseExited(MouseEvent e) {
  }
  @Override
  public void mousePressed(MouseEvent e) {
    mouseX = e.getX();
    mouseY = e.getY();
  }
  @Override
  public void mouseReleased(MouseEvent e) {
  }
}
