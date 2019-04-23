import java.util.Random;

// Cameron Brien
// class used in my main program

public class Enemy {
  // fields
  protected int health;
  protected int damageModifier;
  protected int accuracyModifier;

  // methods

  // display the enemies health
  public int showHealth() {
    return health;
  }

  // make the enemy take damage
  public void takeDamage(int damage) {
    health -= damage;
  }

  // make the enemy attack
  /**
   * This method is used to get the amount of damage that an enemy does when it attacks.
   * 
   * @return An int of the number of damage that the enemy deals
   */
  public int attack() {
    // use of the random class
    Random rand = new Random();
    // check if the enemy hits
    int hit = rand.nextInt(20 + accuracyModifier);
    // only do damage if the enemy hits
    if (hit > 10) {
      // get the enemy damage
      int damage = rand.nextInt(20) + damageModifier;
      return damage;
    } else {
      return 0;
    }
  }

  // constructor for enemy class
  /**
   * A constructor for the enemy class that sets its fields based on the level of the player.
   * 
   * @param playerLevel The level of the player.
   */
  public Enemy(int playerLevel) {
    health = 30 + playerLevel;
    damageModifier = playerLevel * 10;
    accuracyModifier = playerLevel * 10;
  }
}
