import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
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
  private Country[] setCountries (Country[] c) {
    c[0] = new Country ("A", 10, 10, 30, 10);
    c[1] = new Country ("B", 300, 250, 30, 50);
    c[2] = new Country ("C", 40, 40, 30, 15);
    c[3] = new Country ("D", 100, 120, 30, 70);
    c[4] = new Country ("E", 70, 70, 10, 40);
    //SHU AMANO
    //TEXT FILE */
	  return c;
=======


	  return c;
>>>>>>> 27cc1e7131de058f3923d16df9391542780b32ec
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
