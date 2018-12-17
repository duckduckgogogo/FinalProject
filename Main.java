
// =============================================================================
/**
* Main contains the primary game playing functions and mouse listener
*
* @author Ashira Mawji & Shu Amano
**/
// =============================================================================

// =============================================================================
// IMPORTS
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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

// =============================================================================
public class Main extends JPanel implements MouseListener, KeyListener {

	// =============================================================================
	// INSTANCE FIELDS
	static int mouseX;
	static int mouseY;
	final int HEIGHT = 600;
	final int WIDTH = 1000;
	public static Scanner keyboard = new Scanner(System.in);
	static World w;
	static boolean GAMEOVER = false;
	static int state = 0;
	static int NUMPLAYERS;
	static Graphics g;
	static Main mainInstance;
	static boolean canGetCard = false;

	// =============================================================================
	// CONSTRUCTOR
	public Main() {
		w = new World();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addMouseListener(this);
	}

	// =============================================================================
	// main(): plays game
	public static void main(String[] args) {
		// JFrame
		JFrame frame = new JFrame("Risky Business.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainInstance = new Main();
		frame.setContentPane(mainInstance);
		frame.pack();
		frame.setVisible(true);

		// Initialize playerArray[]: size specified by user
		Object[] numPlayerOptions = { 2, 3, 4, 5, 6 };
		Object numPlayersDialog = JOptionPane.showInputDialog(null, "Number of players?", "Number of Players",
				JOptionPane.PLAIN_MESSAGE, null, numPlayerOptions, numPlayerOptions[0]);
		final int NUMPLAYERS = (int) numPlayersDialog;
		Player[] playerArray = new Player[NUMPLAYERS];
		for (int i = 0; i < NUMPLAYERS; i++) {
			playerArray[i] = new Player(i);
		}

		// Players alternate claiming a Country until all the Countries are claimed
		System.out.println("Click on a country to claim it. Rotate between players until all countries are claimed.");
		int tempC;
		while (w.isAllClaimed(w.countriesArray) == false) {
			for (int j = 0; j < NUMPLAYERS; j++) {
				System.out.println("Please select a country you wish to claim, Player " + (j + 1) + ".");
				tempC = chooseCountry();
				while (w.countriesArray[tempC].getOwner() != 10) {
					tempC = chooseCountry();
					System.out.println("That country has already been claimed by another player.");
				}
				w.countriesArray[tempC].setOwner(j);
				w.countriesArray[tempC].addArmy(5);
				// DEBUG: System.out.println(w.countriesArray[tempC].getOwner());
				System.out.println("Player " + (j + 1) + " has claimed " + w.countriesArray[tempC].getName() + ".");
				playerArray[j].addCountry();
				if (w.isAllClaimed(w.countriesArray)) {
					break;
				}
			}
		}
		System.out.println("All countries have been claimed.");

		// Players alternate turns until one player owns every country
		int order = 0;
		while (GAMEOVER == false) {
			play(playerArray[order]);
			order = endTurn(order);
			checkWin();
		}
	}

	// =============================================================================
	// paintComponent()
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		w.drawCountries(g);
		w.drawAllConnections(g);
	}

	// =============================================================================
	// chooseCountry(): Player selects a country as detected by MouseListener
	public static int chooseCountry() {
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
			} else {
				tempX = mouseX;
				tempY = mouseY;
				for (int i = 0; i < w.TOTALNUMCOUNTRIES; i++) {
					int x = w.countriesArray[i].getPosX();
					int y = w.countriesArray[i].getPosY();
					if (w.countriesArray[i].isIn(mouseX, mouseY)) {
						return i;
					}
				}
				System.out.println("Invalid: Please select a country.");
			}
		}
	}

	// =============================================================================
	// play(): Player collects armies, places armies, attacks, and moves armies
	public static void play(Player p) {
		canGetCard = false;
		System.out.println("Player " + p.getMyNum() + "'s turn.");
		placeArmies(p);
		System.out.println("Would you like to attack? (Y/N)");
		String temp = keyboard.next();
		while (temp.equals("Y")) {
			attack(p);
			System.out.println();
			System.out.println("Would you like to attack? (Y/N)");
			temp = keyboard.next();
			System.out.println(temp);
		}
		System.out.println("Would you like to move your armies around? (Y/N)");
		temp = keyboard.next();
		while (temp.equals("Y")) {
			System.out.println("Choose a country from which to move your armies.");
			Country temp1 = w.countriesArray[chooseCountry()];
			System.out.println("Choose a country to which to move your armies.");
			Country temp2 = w.countriesArray[chooseCountry()];
      while ((temp1.getOwner() != p.getMyNum()) || (temp2.getOwner() != p.getMyNum()) || !(w.isConnected(temp1.getArrayPos(), temp2.getArrayPos()))) {
        System.out.println ("Invalid: Please move your armies between 2 of your adjacent countries.");
        System.out.println("Choose a country from which to move your armies.");
  			temp1 = w.countriesArray[chooseCountry()];
  			System.out.println("Choose a country to which to move your armies.");
  			temp2 = w.countriesArray[chooseCountry()];
      }
			moveArmies(temp1,temp2);
			System.out.println("Would you like to move your armies around? (Y/N)");
			temp = keyboard.next();
		}
		System.out.println("Your turn is over.");
		if (canGetCard == true) {
			System.out.println("Since you conquered at least one country, you have collected a card.");
			p.addCard();
		}
	}

	// =============================================================================
	// cashCards(): exchanges all of Player's cards for additional armies
	public static int cashCards(Player p) {
		int i = p.getNumCards();
		p.subtractCards();
		return i;
	}

	// =============================================================================
	// placeArmies(): tallies how many armies Player can collect, gives Player the
	// option to cash in their cards for additional armies, Player places armies
	public static void placeArmies(Player p) {
		// Tallies how many armies Player can collect
		int count = p.countNumArmiesToCollect();
		System.out.println("Player " + p.getMyNum() + ", you can place " + count + " armies.");
		// Option to exchange cards for additional armies
		System.out.println("Would you like to cash in your " + p.getNumCards() + " cards for " + p.getNumCards()
				+ " armies? (Y/N)");
		String input = keyboard.nextLine();
		if (input.equals("Y")) {
			count += cashCards(p);
		}
		// Player places armies on their countries, using MouseListener
		Country tempC;
		System.out.println("Click on a country to place an army there.");
		for (int i = 0; i < count; i++) {
			// DEBUG: System.out.println ("HI");
			tempC = w.countriesArray[chooseCountry()];
			while (tempC.getOwner() != p.getMyNum()) {
				System.out.println("Invalid: Please choose one of your own countries.");
				tempC = w.countriesArray[chooseCountry()];
			}
			tempC.addArmy(1);
		}
	}

	// =============================================================================
	// attack(): Player chooses a country from which to attack and a country to
	// attack, dice determine how many armies each country loses, if Player conquers
	// Country then Player moves armies there
	public static void attack(Player p) {
		// Player chooses a country from which to attack
		System.out.println("Choose a country from which to attack. ");
		Country tempA = w.countriesArray[chooseCountry()];
		while ((tempA.getOwner() != p.getMyNum()) || (tempA.getNumArmies() == 1)) {
			System.out.println("Invalid: Attack from one of your countries with 2+ armies.");
			tempA = w.countriesArray[chooseCountry()];
		}
		// Player chooses a country to attack
		System.out.println("Choose a country to attack. ");
		Country tempD = w.countriesArray[chooseCountry()];
		while ((tempD.getOwner() == p.getMyNum()) || !(w.isConnected(tempA.getArrayPos(), tempD.getArrayPos()))) {
			System.out.println("Invalid: Attack an adjacent country occupied by another Player.");
			tempD = w.countriesArray[chooseCountry()];
		}
		System.out.println("Player " + tempA.getOwner()+1 + " attacking Player " + tempD.getOwner()+1 + " from "
				+ tempA.getName() + " to " + tempD.getName() + ".");
		// Dice determine how many armies each country loses, number of dice
		// determined by number of armies on country
		// Attacking country's dice
		int A1 = (int) (Math.random() * 5 + 1.0);
		System.out.print("Player " + tempA.getOwner()+1 + " rolled " + A1);
		int A2 = 0;
		int A3 = 0;
		// Order dice based on face value
		int AUse1 = 0;
		int AUse2 = 0;
		int AUse3 = 0;
		if (tempA.getNumArmies() > 2) {
			A2 = (int) (Math.random() * 5 + 1.0);
			System.out.print(", " + A2);
			if (tempA.getNumArmies() > 3) {
				A3 = (int) (Math.random() * 5 + 1.0);
				System.out.print(", " + A3);
			}
		}
		// Case 1: Die 1 is highest
		if ((A1 >= A2) && (A1 >= A3)) {
			AUse1 = A1;
			if (A2 >= A3) {
				AUse2 = A2;
				AUse3 = A3;
			} else {
				AUse2 = A3;
				AUse3 = A2;
			}
		}
		// Case 2: Die 2 is highest
		else if ((A2 >= A1) && (A2 >= A3)) {
			AUse1 = A2;
			if (A1 >= A3) {
				AUse2 = A1;
				AUse3 = A3;
			} else {
				AUse2 = A3;
				AUse3 = A1;
			}
		}
		// Case 3: Die 3 is highest
		else if ((A3 >= A1) && (A3 >= A2)) {
			AUse1 = A1;
			if (A1 >= A2) {
				AUse2 = A1;
				AUse3 = A2;
			} else {
				AUse2 = A2;
				AUse3 = A1;
			}
		}
		System.out.println();
		// Defending country's dice
		int D1 = (int) (Math.random() * 5 + 1.0);
		System.out.print("Player " + tempD.getOwner()+1 + " rolled " + D1);
		int D2 = 0;
		if (tempD.getNumArmies() > 1) {
			D2 = (int) (Math.random() * 5 + 1.0);
			System.out.print(", " + D2);
		}
		// Order dice based on face value
		int DUse1 = 0;
		int DUse2 = 0;
		// Case 1: Die 1 is highest
		if (D1 >= D2) {
			DUse1 = D1;
			DUse2 = D2;
		}
		// Case 2: Die 2 is highest
		else {
			DUse1 = D2;
			DUse2 = D1;
		}
		// Match up attacker's dice and defender's dice in ranked order
		int ALoss = 0;
		int DLoss = 0;
		if (DUse1 >= AUse1) {
			ALoss++;
		} else {
			DLoss++;
		}
		if (DUse2 >= AUse2) {
			ALoss++;
		} else if (DUse2 != 0) {
			DLoss++;
		}
		// Clear fallen soldiers from the battlefield
		System.out.println();
    System.out.println ("You have lost " + ALoss + " armies. Your enemy has lost " + DLoss + " armies.");
		tempA.subtractArmy(ALoss);
		tempD.subtractArmy(DLoss);
		// Player moves armies to conquered country, Player can collect a card at
		// end of turn
		if (tempD.getNumArmies() < 1) {
			moveArmies(tempA, tempD);
			tempD.setOwner(tempA.getOwner());
			canGetCard = true;
		}
	}

	// =============================================================================
	// moveArmies(): Player moves armies between 2 of their countries, using
	// MouseListener
	public static void moveArmies(Country a, Country b) {
    System.out.println();
    System.out.println("You have " + a.getNumArmies() + " armies on " + a.getName()
				+ ". How many armies would you like to move to " + b.getName() + "?");
		int t = keyboard.nextInt();
		while ((t < 2) || (t > a.getNumArmies() - 1)) {
			System.out.println("Invalid: Move between 1 and " + (a.getNumArmies() - 1) + " armies.");
			t = keyboard.nextInt();
		}
		a.subtractArmy(t);
		b.addArmy(t);
	}


	// =============================================================================
	// endTurn(): toggles Player turn
	public static int endTurn(int o) {
		if (o == (NUMPLAYERS - 1)) {
			return 0;
		}
		return o++;
	}
	// =============================================================================
	// checkWin(): checks if one Player owns every country
	public static Boolean checkWin() {
		int o = w.countriesArray[0].getOwner();
		for (int i = 0; i < w.TOTALNUMCOUNTRIES; i++) {
			if (o != w.countriesArray[i].getOwner()) {
				return false;
			}
		}
		return true;
	}
	// =============================================================================
	// mouseClicked()
	@Override
	public void mouseClicked(MouseEvent e) {
    mainInstance.repaint();
	}

	// =============================================================================
	// mouseEntered()
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	// =============================================================================
	// mouseExited()
	@Override
	public void mouseExited(MouseEvent e) {
	}

	// =============================================================================
	// mousePressed()
	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	// =============================================================================
	@Override
	public void mouseReleased(MouseEvent e) {
		mainInstance.repaint();
	}

	// =============================================================================
	@Override
	public void keyPressed(KeyEvent arg0) {
		mainInstance.repaint();
	}

	// =============================================================================
	@Override
	public void keyReleased(KeyEvent e) {
	}

	// =============================================================================
	@Override
	public void keyTyped(KeyEvent e) {
	}

}
