package Week10;

public class Ex {

  private static class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
      this.name = name;
      this.meat = meat;
      this.price = price;
      this.breadRollType = breadRollType;
      System.out.println(this.name + " hamburger on a " + this.breadRollType + " with " + this.meat + ", price is " + this.price);
    }

    public void addHamburgerAddition1(String name, double price) {
      this.addition1Name = name;
      this.addition1Price = price;
      System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1Price);
    }

    public void addHamburgerAddition2(String name, double price) {
      this.addition2Name = name;
      this.addition2Price = price;
      System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2Price);
    }

    public void addHamburgerAddition3(String name, double price) {
      this.addition3Name = name;
      this.addition3Price = price;
      System.out.println("Added " + this.addition3Name + " for an extra " + this.addition3Price);
    }

    public void addHamburgerAddition4(String name, double price) {
      this.addition4Name = name;
      this.addition4Price = price;
      System.out.println("Added " + this.addition4Name + " for an extra " + this.addition4Price);
    }

    public double itemizeHamburger() {
      return this.price + this.addition1Price + this.addition2Price + this.addition3Price + this.addition4Price;
    }
  }

  private static class DeluxeBurger extends Hamburger {

    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;

    public DeluxeBurger() {
      super("Deluxe", "Sausage & Bacon", 14.54, "White roll");
      this.name = "Deluxe";
      this.meat = "Sausage & Bacon";
      this.price = 14.54;
      this.breadRollType = "White roll";
      this.addition1Name = "Chips";
      this.addition1Price = 2.75;
      this.addition2Name = "Drink";
      this.addition2Price = 1.81;
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
      System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
      System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
      System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
      System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public double itemizeHamburger() {
      System.out.println(this.name + " on a " + this.breadRollType + " with " + this.meat + ", price is " + this.price);
      System.out.println("Added " + this.addition1Name + "for an extra " + this.addition1Price);
      System.out.println("Added " + this.addition2Name + "for an extra " + this.addition2Price);
      return this.price + this.addition1Price + this.addition2Price;
    }

  }

  private static class HealthyBurger extends Hamburger {

    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
      super("Healthy", meat, price, "Brown rye roll");
    }

    public void addHealthyAddition1(String name, double price) {
      this.healthyExtra1Name = name;
      this.healthyExtra1Price = price;
      System.out.println("Added " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
    }

    public void addHealthyAddition2(String name, double price) {
      this.healthyExtra2Name = name;
      this.healthyExtra2Price = price;
      System.out.println("Added " + this.healthyExtra2Name + " for an extra " + this.healthyExtra2Price);
    }

    @Override
    public double itemizeHamburger() {
      return this.healthyExtra1Price + healthyExtra2Price + super.itemizeHamburger();
    }
  }

  public static void main(String[] args) {
    Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
    hamburger.addHamburgerAddition1("Tomato", 0.27);
    hamburger.addHamburgerAddition2("Lettuce", 0.75);
    hamburger.addHamburgerAddition3("Cheese", 1.13);
    System.out.println("Total Burger price is " + hamburger.itemizeHamburger());

    HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
    healthyBurger.addHamburgerAddition1("Egg", 5.43);
    healthyBurger.addHealthyAddition1("Lentils", 3.41);
    System.out.println("Total Healthy Burger price is  " + healthyBurger.itemizeHamburger());

    DeluxeBurger db = new DeluxeBurger();
    db.addHamburgerAddition3("Should not do this", 50.53);
    System.out.println("Total Deluxe Burger price is " + db.itemizeHamburger());
  }
}