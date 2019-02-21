import java.util.Random;

public class Enemy {
  //fields
  int health;
  int damageModifier;
  int accuracyModifier;
  
  //methods
  
  // generate a new enemy
  public void generateEnemy(int playerLevel) {
    health = 3 + playerLevel;
    damageModifier = playerLevel;
    accuracyModifier = playerLevel;
  }
  
  // display the enemies health
  public int showHealth() {
    return health;
  }
  
  // make the enemy take damage
  public void takeDamage(int damage){
    health -= damage;
  }
  
  // make the enemy attack 
  public int attack() {
    // use of the random class
    Random rand = new Random();
    // check if the enemy hits
    int hit = rand.nextInt(2 + accuracyModifier);
    // only do damage if the enemy hits
    if(hit > 0) {
      // get the enemy damage
      int damage = rand.nextInt(2) + damageModifier;
      return damage;
    }
    else {
      return 0;
    }
  }
    
}
