public class Army {
  private final int OWNER;
  private int country;
  private final Color MYARMYCOLOR;
  private int armyPosX;
  private int armyPosY;

  public Army (int owner, int country) {
    this.OWNER = owner;
    this.COUNTRY = country;
    this.MYARMYCOLOR = playerArray[owner].getMyColor();
    this.armyPosX = countryArray[country].POSX;
    this.armyPosY = countryArray[country].POSY;
  }

  public void getCountry () {
    return country;
  }
hi
  public void setCountry (int a) {
    this.country = a;
  }



}
