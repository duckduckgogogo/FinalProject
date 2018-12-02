public class World {
  final int HEIGHT;
  final int WIDTH;
  final int TOTALNUMCOUNTRIES = 20;
  Country[] countriesArray = new Country[TOTALNUMCOUNTRIES];
  Card[] cardsArray = new Card[TOTALNUMCOUNTRIES];
  final int[][] CONNECTIONS = new int[TOTALNUMCOUNTRIES][TOTALNUMCOUNTRIES]; //final?

  public World () {
    //Instantiate cardsArray: 1 card per country, available
    for (int i = 0; i < TOTALNUMCOUNTRIES; i++) {
      cardsArray[i] = new Card (i);
    }

    countriesArray = setCountries(countriesArray);
    CONNECTIONS = setConnections (CONNECTIONS);
  }

  private Country[] setCountries (Country[] c) {
    c[0] = new Country (5, 0, "Val");
    c[1] = new Country ();
    //SHU AMANO
    return c;
  }

  private void connect (int[][] a, int b, int c) {
    a[b][c] = 1;
    a[c][b] = 1;
  }

  private int[][] setConnections (int[][] a) {
    connect (a, 0, 1);
    //SHU AMANO
    return a;
  }


  public void drawCountries () {

  }

  public void updateWorld () {
    drawCountries();
  }
}
