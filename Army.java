public class Army {
  private final int OWNER;
  private int COUNTRY;
  private final Color MYARMYCOLOR;

  public Army (int owner, int country) {
    this.OWNER = owner;
    this.COUNTRY = country;
    this.MYARMYCOLOR = playerArray[owner].getMyColor();
  }


}
