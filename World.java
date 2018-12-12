import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class World {
	static final int TOTALNUMCOUNTRIES = 43;
	static Country[] countriesArray = new Country[TOTALNUMCOUNTRIES];
	static Card[] cardsArray = new Card[TOTALNUMCOUNTRIES];
	static int[][] CONNECTIONS = new int[TOTALNUMCOUNTRIES][TOTALNUMCOUNTRIES]; // final?

	// Constructor
	public World() {
		for (int i = 0; i < TOTALNUMCOUNTRIES; i++) { // Instantiate cards: 1 card per country, available
			cardsArray[i] = new Card(i);
		}
		countriesArray = setCountries(countriesArray, "CountryData"); // Instantiate countries
		CONNECTIONS = setConnections(CONNECTIONS, "Connections");
	}

	// Instantiate countries (int numArmies, int CONTINENT, String name, Color d)
	private Country[] setCountries(Country[] c, String filename) {
		try {
			File input = new File(filename);
			Scanner sc = new Scanner(input);
			int i = 0;
			while (i < 43) {
				String[] countryInfo = sc.nextLine().split(",");
				String countryName = countryInfo[0];
				int countryX = Integer.parseInt(countryInfo[1]);
				int countryY = Integer.parseInt(countryInfo[2]);
				int countryWidth = Integer.parseInt(countryInfo[3]);
				int countryHeight = Integer.parseInt(countryInfo[4]);
				int countryContinent = Integer.parseInt(countryInfo[5]);
				c[i] = new Country(countryName, countryX, countryY, countryWidth, countryHeight, countryContinent);
				i++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Country Data File not found.");
			System.err.println(e);
		}
		return c;
	}

	// Create a Connection Matrix that represents all connections between countries
	private int[][] setConnections(int[][] a, String filename) { 
		try {
			File input = new File(filename);
			Scanner sc = new Scanner(input);
			
			for (int i = 0; i < TOTALNUMCOUNTRIES; i++) { 
				String[] connectionInfo = sc.nextLine().split(",");
				for (int j = 0; j < TOTALNUMCOUNTRIES; j++) {
					a[i][j] = Integer.parseInt(connectionInfo[j]); 
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Connection File not found.");
			System.err.println(e);
		}
		return a;
	}
	
	// Check if two countries are connected
	public Boolean isConnected(int i, int j) {
		if (CONNECTIONS[i][j] == 1) {
			return true;
		} else {
			return false;
		}
	}	
	
	// Check if everything is country is claimed 
	public Boolean isAllClaimed(Country[] c) {
		int numClaimed = 0;
		for (int i = 0; i < TOTALNUMCOUNTRIES; i ++) {
			if (c[i].getOwner() != 10) {
				numClaimed ++;
			}
		}
		if (numClaimed == TOTALNUMCOUNTRIES) {
			return true;
		} else {
			return false;
		}
	}
	
	// Draw countries
	public void drawCountries(Graphics g) {
		for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
			countriesArray[i].drawCountry(g);
		}
	}

	// Draws connections between two countries
	public void drawConnection(Graphics g, int i, int j) {
		int icenterX = (int) (countriesArray[i].getPosX() + Math.round(0.5*countriesArray[i].getWidth()));
		int icenterY = (int) (countriesArray[i].getPosY() + Math.round(0.5*countriesArray[i].getHeight()));
		int jcenterX = (int) (countriesArray[j].getPosX() + Math.round(0.5*countriesArray[j].getWidth()));
		int jcenterY = (int) (countriesArray[j].getPosY() + Math.round(0.5*countriesArray[j].getHeight()));
		if (countriesArray[i].getContinent() == countriesArray[j].getContinent()) {
			g.setColor(countriesArray[i].getColor());
		    g.drawLine(icenterX, icenterY, jcenterX, jcenterY);
		} else {
			g.setColor(Color.WHITE);
		    g.drawLine(icenterX, icenterY, jcenterX, jcenterY);
		}

	}
	
	// Draw connections between ALL countries
	public void drawAllConnections(Graphics g) {
		for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
			for (int j = i; j < TOTALNUMCOUNTRIES; j++) {
				if (isConnected(i,j)) {
					drawConnection(g, i,j);
				}
			}
		}
	}
	
	// Update world
	/*
	 * public void updateWorld () { drawCountries(countriesArray); }
	 */
}
