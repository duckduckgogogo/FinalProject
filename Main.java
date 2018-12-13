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
import java.lang.Math;

public class Main extends JPanel implements MouseListener{
  static int mouseX;
  static int mouseY;
  final int HEIGHT = 600;
  final int WIDTH = 1000;
  public static Scanner keyboard = new Scanner (System.in);
  static World w;
  static boolean GAMEOVER = false;
  static int state = 0; //Necessary?
  static int NUMPLAYERS;
  static Graphics g;
  static Main mainInstance;

  public Main () {
    w = new World();
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    addMouseListener(this);
  }

  public static void main (String[] args) {
    //Frame
    JFrame frame = new JFrame ("Risky Business.");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainInstance = new Main();
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

    //Initial assignment of countries to players
    System.out.println ("Players take turns claiming a country.");
    int order = 0;
    int tempC;
    while (w.isAllClaimed(w.countriesArray) == false) {
        for (int j = 0; j < NUMPLAYERS; j++) {
        	System.out.println("Please select a country you wish to claim, Player " + (j + 1) + ".");
        	tempC = chooseCountry();
        	while (w.countriesArray[tempC].getOwner() != 10) {
        		tempC = chooseCountry();
        		System.out.println ("That country has already been claimed by another player.");
        	}
        	w.countriesArray[tempC].setOwner(j);
        	w.countriesArray[tempC].addArmy(5);
        	System.out.println(w.countriesArray[tempC].getOwner());
        	System.out.println("Player " + (j + 1) + " has claimed " +  w.countriesArray[tempC].getName() + ".");
        	playerArray[j].addCountry();
        	if (w.isAllClaimed(w.countriesArray)) {
        	  break;
        	}
        }
    }
    System.out.println ("All the countries have been chosen.");

    //Initially place armies
    /*for (int i = 0; i < NUMPLAYERS; i++) {
      placeArmies(playerArray[i]);
    }*/

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
    g.fillRect(0,0, WIDTH, HEIGHT);
    w.drawCountries(g);
    w.drawAllConnections(g);
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
        	  return i;
          }
        }
        System.out.println("That is not a country. Please click on a country.");
      }
    }
  }

  public static void play (Player p) {
    System.out.println ("Player " + p.getMyNum() + "'s turn.");
    placeArmies(p);
    System.out.println ("Would you like to attack? (Y/N)");
    String temp = keyboard.nextLine();
    while (temp == "Y") {
      attack(p);
      System.out.println ("Would you like to attack? (Y/N)");
      temp = keyboard.nextLine();
    }
    System.out.println ("Would you like to move your armies around? (Y/N)");
    temp = keyboard.nextLine();
    while (keyboard.nextLine() == "Y") {
      moveArmies(w.countriesArray[chooseCountry()], w.countriesArray[chooseCountry()]);
      System.out.println ("Would you like to move your armies around? (Y/N)");
      temp = keyboard.nextLine();
    }
    System.out.println ("Your turn is over.");
  }

  //Cash cards: add armies, subtract cards
  public static int cashCards(Player p) {
    int i = p.getNumCards();
    p.subtractCards();
    return i;
  }

  //MOUSE LISTENER
  public static void placeArmies(Player p) {
    int count = p.countNumArmiesToCollect();
    System.out.println ("Player " + p.getMyNum() + ", you can place " + count + " armies.");
    System.out.println ("Would you like to cash in your " + p.getNumCards() + " cards for " + p.getNumCards() + " armies? (Y/N)");
    String input = keyboard.nextLine();
    if (input == "Y") {
      count += cashCards(p);
    }

    Country tempC;
    System.out.println ("Click on a country to place an army there.");
    for (int i = 0; i < count; i++) {
      System.out.println ("HI");
      tempC = w.countriesArray[chooseCountry()];
      while (tempC.getOwner() != p.getMyNum()) {
        System.out.println ("Choose one of your own countries.");
        tempC = w.countriesArray[chooseCountry()];
      }
      tempC.addArmy(1);
    }
  }

  public static void attack(Player p) {
    System.out.println ("Choose a country from which to attack. ");
    Country tempA = w.countriesArray[chooseCountry()];
    while ((tempA.getOwner() != p.getMyNum()) || (tempA.getNumArmies() == 1)) {
      System.out.println ("Invalid: Attack from one of your countries with 2+ armies.");
      tempA = w.countriesArray[chooseCountry()];
    }
    System.out.println ("Choose a country to attack. ");
    Country tempD = w.countriesArray[chooseCountry()];
    while (tempD.getOwner() == p.getMyNum() /* || Connection*/) {
      System.out.println ("Invalid: Choose someone else's country to attack.");
      tempD = w.countriesArray[chooseCountry()];
    }

    System.out.println ("Player " + tempA.getOwner() + " attacking Player " + tempD.getOwner() + " from " + tempA.getName() + " to " + tempD.getName() + ".");

    int A1 = (int)(Math.random()*5+1.0);
    System.out.print ("Player " + tempA.getOwner() + " rolled " + A1);
    int A2 = 0;
    int A3 = 0;
    int AUse1 = 0;
    int AUse2 = 0;
    int AUse3 = 0;
    //Roll dice based on number of armies
    if (tempA.getNumArmies() > 2) {
      A2 = (int)(Math.random()*5+1.0);
      System.out.print (", " + A2);
      if (tempA.getNumArmies() > 3) {
        A3 = (int)(Math.random()*5+1.0);
        System.out.print (", " + A3);
      }
    }
    //A1 biggest
    if ((A1 >= A2) && (A1 >= A3)) {
      AUse1 = A1;
      if (A2 >= A3) {
        AUse2 = A2;
        AUse3 = A3;
      }
      else {
        AUse2 = A3;
        AUse3 = A2;
      }
    }
    //A2 biggest
    else if ((A2 >= A1) && (A2 >= A3)) {
      AUse1 = A2;
      if (A1 >= A3) {
        AUse2 = A1;
        AUse3 = A3;
      }
      else {
        AUse2 = A3;
        AUse3 = A1;
      }
    }
    //A3 biggest
    else if ((A3 >= A1) && (A3 >= A2)) {
      AUse1 = A1;
      if (A1 >= A2) {
        AUse2 = A1;
        AUse3 = A2;
      }
      else {
        AUse2 = A2;
        AUse3 = A1;
      }
    }
    System.out.println();
    int D1 = (int)(Math.random()*5+1.0);
    System.out.print ("Player " + tempD.getOwner() + " rolled " + D1);
    int D2 = 0;
    if (tempD.getNumArmies() > 1) {
      D2 = (int)(Math.random()*5+1.0);
      System.out.print (", " + D2);
    }
    int DUse1 = 0;
    int DUse2 = 0;

    //Order and match dice
    //D1 biggest
    if (D1 >= D2) {
        DUse1 = D1;
        DUse2 = D2;
    }
    //D2 biggest
    else {
      DUse1 = D2;
      DUse2 = D1;
    }

    int ALoss = 0;
    int DLoss = 0;
    if (DUse1 >= AUse1) {
      ALoss++;
    }
    else {
      DLoss++;
    }
    if (DUse2 >= AUse2) {
      ALoss++;
    }
    else if (DUse2 != 0) {
      DLoss++;
    }

    tempA.subtractArmy(ALoss);
    tempD.subtractArmy(DLoss);

    if (tempD.getNumArmies() < 1) {
      moveArmies(tempA, tempD);
    }
  }

  public static void moveArmies(Country a, Country b) {
    System.out.println ("You have " + a.getNumArmies() + " armies. How many armies would you like to move from " + a.getName() + " to " + b.getName() + "?");
    int t = keyboard.nextInt();
    while ((t < 2) || (t > a.getNumArmies()-1)) {
      System.out.println ("Invalid number of armies: Please choose a number between 1 and " + (a.getNumArmies()-1));
    }
    a.subtractArmy(t);
    b.addArmy(t);
  }

  public static int endTurn (int o) {
    if (o == (NUMPLAYERS-1)) {
      return 0;
    }
    return o++;
  }

  public static void checkWin() {
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    mainInstance.repaint();
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
    mainInstance.repaint();
  }
}
