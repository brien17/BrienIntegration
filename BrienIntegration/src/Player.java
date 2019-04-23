import java.util.Random;

// Cameron Brien
// class used to model the player character

public class Player {
  // fields
  private int maxHealth;
  private int health;
  private int level;
  private int damageModifier;
  private int accuracyModifier;
  private String playerClass;
  private Loot[] inventory = new Loot[10];

  // methods
  // constructor for the player class
  /**
   * A constructor for the player class that starts the player at level 1 and sets the fields to the
   * starting values.
   */
  public Player() {
    // setting the players inventory to empty
    this.clearInventory();
    maxHealth = 100;
    health = 100;
    level = 1;
    damageModifier = 15;
    accuracyModifier = 15;
  }

  // constructor to set a player at a starting level
  /**
   * A constructor for the player class that starts the player at a custom level and sets the fields
   * to the starting values.
   * 
   * @param level The level you want the player to start at.
   */
  public Player(int level) {
    // setting the players level to a given level
    this.level = level;
    // setting the players inventory to empty
    this.clearInventory();
    maxHealth = 100 + (10 * level);
    health = 100 + (10 * level);
    damageModifier = 15 + (2 * level);
    accuracyModifier = 15 + (2 * level);
  }

  // sets the stats for player class
  /**
   * Used to change the players fields based on the class that is entered at the start.
   * 
   * @param pc The class that the player wants to be.
   */
  public void setPlayerClass(String pc) {
    playerClass = pc;
    if (pc.equals("cheater")) {
      health = 10000;
      damageModifier = 1000;
      accuracyModifier = 1000;
    }
  }

  // get the class
  public String getPlayerClass() {
    return playerClass;
  }

  // display the players health
  public int showHealth() {
    return health;
  }

  // display the players health
  public void setHealth(int health) {
    this.health = health;
  }

  // make the player take damage
  public void takeDamage(int damage) {
    health -= damage;
  }

  // return the players damage modifier
  public int getDamageModifier() {
    return damageModifier;
  }

  // set players damage modifier
  public void setDamageModifier(int dm) {
    damageModifier = dm;
  }

  // return the players accuracy
  public int getAccuracyModifier() {
    return accuracyModifier;
  }

  // set accuracy
  public void setAccuracyModifier(int ac) {
    accuracyModifier = ac;
  }

  // return the players level
  public int getLevel() {
    return level;
  }

  // set players level
  public void setLevel(int level) {
    this.level = level;
  }

  // make the player attack
  /**
   * This is a method to get the amount of damage the player does when they attack with no bonuses.
   * 
   * @return The damage that the player does.
   */
  public int attack() {
    // use of random class
    Random rand = new Random();
    // determine if the player hits
    int hit = rand.nextInt(30 + accuracyModifier);
    // check that the player hits
    if (hit > 10) {
      // calculate and return damage
      int damage = rand.nextInt(20) + damageModifier;
      return damage;
    } else {
      return 0;
    }
  }

  // make the player attack with an accuracy bonus and/or a damage bonus
  /**
   * This method is used to get the amount of damage that a the player does when they attack with an
   * accuracy and/or damage bonus.
   * 
   * @param accuracyBonus The players accuracy bonus to make it easier to hit.
   * @param damageBonus The players damage bonus to make them do more damage.
   * @return The amount of damage that the player does.
   */
  public int attack(int accuracyBonus, int damageBonus) {
    // use of random class
    Random rand = new Random();
    // determine if the player hits
    int hit = rand.nextInt(30 + accuracyModifier + accuracyBonus);
    // check that the player hits
    if (hit > 10) {
      // calculate and return damage
      int damage = rand.nextInt(20) + damageModifier + damageBonus;
      return damage;
    } else {
      return 0;
    }
  }

  // clears the inventory
  /**
   * This method clears the player's inventory.
   */
  public void clearInventory() {
    for (int i = 0; i < inventory.length; i++) {
      inventory[i] = new Loot();
    }
  }

  // returns the inventory at a position
  public String getInventoryAt(int position) {
    return inventory[position].getName();
  }

  // shows the inventory
  /**
   * This method displays the players inventory.
   */
  public void showInventory() {
    boolean empty = true;
    for (Loot item : inventory) {
      if (item.getName().equals("Empty") == false) {
        empty = false;
        System.out.println(item.getName() + " ");
      }
    }
    if (empty == true) {
      System.out.println("your inventory is empty");
    }
  }

  /**
   * This method heals the player and consume a health potion from their inventory (if they have
   * one).
   */
  public boolean useHealthPotion() {
    boolean turnOver = false;
    for (Loot item : inventory) {
      if (item.getName().equals("Health Potion")) {
        this.health += item.getHealAmount();
        if (health > maxHealth) {
          int overHealth = health - maxHealth;
          health = maxHealth;
          System.out.println("you healed for " + (item.getHealAmount() - overHealth));
        } else {
          System.out.println("you healed for " + item.getHealAmount());
        }
        turnOver = true;
        return turnOver;
      }
    }
    System.out.println("You don't have any health potions to use");
    return turnOver;
  }
}
