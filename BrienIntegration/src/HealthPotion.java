import java.util.Random;

//Cameron Brien
//class used in my main program

public class HealthPotion extends Loot {
  // fields
  private int healAmount;

  // methods
  /**
   * This is a public constructor for the health potion class, that initializes the healAmount and
   * name of the potion.
   */
  public HealthPotion() {
    Random rand = new Random();
    healAmount = rand.nextInt(30) + 5;
    name = "Health Potion";
  }

  /**
   * This is a method for the health potion class that returns the value of healAmount as an 
   * integer.
   */
  public int getHealAmount() {
    return healAmount;
  }

  /**
   * This is a method of the health potion class that sets the healAmount to an integer value that
   * to be equal to an int that is taken as an argument.
   */
  public void setHealAmount(int healAmount) {
    this.healAmount = healAmount;
  }
}
