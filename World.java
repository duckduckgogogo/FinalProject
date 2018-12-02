public class World {
  final int HEIGHT;
  final int WIDTH;
  final int TOTALNUMCOUNTRIES = 20;

  public World () {
    Country[] countriesArray = new Country[TOTALNUMCOUNTRIES];
    Card[] cardsArray = new Card [TOTALNUMCOUNTRIES];
  }

  public void drawCountries () {

  }

  public void updateWorld () {
    drawCountries();
  }
}
