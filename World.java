// =============================================================================
/**
* World contains array of countries, connections between countries
*
* @author Ashira Mawji & Shu Amano
**/
// =============================================================================


// =============================================================================
// IMPORTS
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

// =============================================================================
public class World {

	// =============================================================================
	// INSTANCE FIELDS
	static final int TOTALNUMCOUNTRIES = 43;
	static Country[] countriesArray = new Country[TOTALNUMCOUNTRIES];
	static int[][] CONNECTIONS = new int[TOTALNUMCOUNTRIES][TOTALNUMCOUNTRIES];

// =============================================================================
	// CONSTRUCTOR
	public World() {
		countriesArray = setCountries(countriesArray, "CountryData");
		CONNECTIONS = setConnections(CONNECTIONS, "Connections");
	}

// =============================================================================
	// setCountries(): uses text file to instantiate each Country's specifications
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
				c[i].setArrayPos(i);
				i++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Country Data File not found.");
			System.err.println(e);
		}
		return c;
	}

// =============================================================================
// setConnections (): uses text file to create array of which countries are
// connected
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

// =============================================================================
// isConnected(): checks whether 2 countries are connected
	public boolean isConnected(int i, int j) {
		if (CONNECTIONS[i][j] == 1) {
			return true;
		} else {
			return false;
		}
	}

// =============================================================================
// drawCountries(): draws each Country in countriesArray[]
	public void drawCountries(Graphics g) {
		for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
			countriesArray[i].drawCountry(g);
		}
	}

// =============================================================================
	// drawConnection(): draws connection between two countries
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

// =============================================================================
	// drawAllConections(): draws connections between all countries
	public void drawAllConnections(Graphics g) {
		for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
			for (int j = i; j < TOTALNUMCOUNTRIES; j++) {
				if (isConnected(i,j)) {
					drawConnection(g, i,j);
				}
			}
		}
	}

// =============================================================================
	// isAllClaimed(): checks if all countries are claimed
	public boolean isAllClaimed(Country[] c) {
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


// =============================================================================
// updateWorld(): updates drawings of countries and connections
	public void updateWorld (Graphics g) {
		drawCountries(g);
		drawAllConnections(g);
	}
}
// class World
// =============================================================================
