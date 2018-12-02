public class World {
  final int HEIGHT;
  final int WIDTH;
  final int TOTALNUMCOUNTRIES = 20;
  final int[][] CONNECTIONS;
  public World () {
    Country[] countriesArray = new Country[TOTALNUMCOUNTRIES];
    Card[] cardsArray = new Card [TOTALNUMCOUNTRIES];
    Connection int[][] = new Int[TOTALNUMCOUNTRIES][TOTALNUMCOUNTRIES];
  }

  public void drawCountries () {

  }

  public void updateWorld () {
    drawCountries();
  }
}
