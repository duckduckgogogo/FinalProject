public class World {
  final int HEIGHT;
  final int WIDTH;
  final int COUNTRYHEIGHT;
  final int COUNTRYWIDTH;
  final int TOTALNUMCOUNTRIES = 20;
  Country[] countriesArray = new Country[TOTALNUMCOUNTRIES];
  Card[] cardsArray = new Card[TOTALNUMCOUNTRIES];
  final int[][] CONNECTIONS = new int[TOTALNUMCOUNTRIES][TOTALNUMCOUNTRIES]; //final?

  //Constructor
  public World () {
    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) { //Instantiate cards: 1 card per country, available
      cardsArray[i] = new Card (i);
    }
    countriesArray = setCountries(countriesArray); //Instantiate countries
    CONNECTIONS = setConnections (CONNECTIONS); //Instantiate country connections
  }

  //Instantiate countries (int numArmies, int CONTINENT, String name, Color d)
  private Country[] setCountries (Country[] c) {
    c[0] = new Country (5, 0, "Val", d);
    c[1] = new Country ();
    //SHU AMANO
    //TEXT FILE
    return c;
  }

  //Connect countries: (int country1, int country2)
  /*private void connect (int[][] a, int c1, int c2) {


    a[c1][c2] = 1;
    a[c2][c1] = 1;
  }*/

  //Set all the country connections using the connect method
  private int[][] setConnections (int[][] a) {
    //FILE SCANNER

    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
      for (int j = 0; j < TOTALNUMCOUNTRIES; j++) {
        a[i][j] = fileScanner.nextInt(); //CHECK
      }
    }

    //connect (a, 0, 1);
    //SHU AMANO
    //TEXT FILE
    return a;
  }

  //Draw countries
  public void drawCountries (Country[] c) {
    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
      drawRect (c[i].getPosX(), c[i].getPosY(), COUNTRYHEIGHT, COUNTRYWIDTH);
    }
  }

  //Draw numArmies
  public void drawArmies () {

  }

  //Update world
  public void updateWorld () {
    drawCountries(countriesArray);
  }
}
