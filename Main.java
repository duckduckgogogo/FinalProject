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
  World world;
  static boolean GAMEOVER = false;
  static int state = 0; //Necessary?

  public Main () {
    world = new World();
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
      if (order == (NUMPLAYERS-1)) {
        order = 0;
      }
      else {
        order++;
      }
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
    mouseX = -1;
    mouseY = -1;
    while (true) {
    	for (int i = 0; i < World.TOTALNUMCOUNTRIES; i++) {
    		int x = World.countriesArray[i].getPosX();
    		int y = World.countriesArray[i].getPosY();
    		// CHANGE COUNTRY HEIGHT VALUE
    		int width = World.countriesArray[i].COUNTRYWIDTH;
    		int height = World.countriesArray[i].COUNTRYHEIGHT;
    		if ((x < mouseX) && (mouseX <x + width) && (y < mouseY) && (mouseY < y + height)) {
        	return i;
    		}
    	}
    	System.out.println("That is not a country");
    }
	  
	/*
    if not a country, then print "Not a country"
    else return country
    */
  }

  public static void play (Player p) {

  }

  public static void collectArmies() {

  }

  public static void cashCards() {

  }

  public static void placeArmies() {

  }

  public static void attack() {

  }

  public static void moveArmies() {

  }

  public static void endTurn () {

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
