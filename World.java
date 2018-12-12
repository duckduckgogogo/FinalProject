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
  static final int[][] CONNECTIONS = new int[TOTALNUMCOUNTRIES][TOTALNUMCOUNTRIES]; //final?

  //Constructor
  public World () {
    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) { //Instantiate cards: 1 card per country, available
      cardsArray[i] = new Card (i);
    }
    countriesArray = setCountries(countriesArray, "CountryData.txt"); //Instantiate countries
    //CONNECTIONS = setConnections (CONNECTIONS); //Instantiate country connections
  }

  //Instantiate countries (int numArmies, int CONTINENT, String name, Color d)
  private Country[] setCountries (Country[] c, String filename) {
	  try {
	    File input = new File(filename);
	    Scanner sc = new Scanner(input);
	    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
	    	
	    	String[] countryInfo = sc.nextLine().split(",");
			String countryName = countryInfo[0];
			int countryX = Integer.parseInt(countryInfo[1]);
			int countryY = Integer.parseInt(countryInfo[2]);
			int countryWidth = Integer.parseInt(countryInfo[3]);
			int countryHeight = Integer.parseInt(countryInfo[4]);
			int countryContinent = Integer.parseInt(countryInfo[5]);
	    	c[i] = new Country(countryName, countryX, countryY, countryWidth, countryHeight, countryContinent);
	    	System.out.println();
	    	}
		}
		catch(FileNotFoundException e) {
		    System.err.println("File not found.");
		    System.err.println(e);
		}
	  
	/*c[0] = new Country ("A", 10, 10, 30, 10, 1);
    c[1] = new Country ("B", 300, 250, 30, 50, 1);
    c[2] = new Country ("C", 40, 40, 30, 15, 1);
    c[3] = new Country ("D", 100, 120, 30, 70, 1);
    c[4] = new Country ("E", 70, 70, 10, 40, 1);
    //SHU AMANO
    //TEXT FILE */
	  return c; 
  }

  //Connect countries: (int country1, int country2)
  /*private void connect (int[][] a, int c1, int c2) {


    a[c1][c2] = 1;
    a[c2][c1] = 1;
  }*/

  //Set all the country connections using the connect method
  /*private int[][] setConnections (int[][] a) {
    //FILE SCANNER

    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
      for (int j = 0; j < TOTALNUMCOUNTRIES; j++) {
        a[i][j] = nextInt(); //CHECK
      }
    }*/

    //connect (a, 0, 1);
    //SHU AMANO
    //TEXT FILE
    //return a;
  //}

  //Draw countries
  public void drawCountries (Graphics g) {
    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
      countriesArray[i].drawCountry(g);
    }
  }

  //Update world
  /*public void updateWorld () {
    drawCountries(countriesArray);
  }*/
}
