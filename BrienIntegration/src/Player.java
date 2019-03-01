import java.util.Random;

// Cameron Brien
// class used to model the player character

public class Player {
  //fields
  int health;
  int level;
  int damageModifier;
  int accuracyModifier;
  
  
  //methods
  
  // generate a new player
  public void newPlayer() {
    health = 10;
    level = 1;
    damageModifier = 1;
    accuracyModifier = 1;
  }
  
  // display the players health
  public int showHealth() {
    return health;
  }
  // make the player take damage
  public void takeDamage(int damage){
    health -= damage;
  }
  
  // return the players level
  public int getLevel() {
    return level;
  }
  
  // make the player attack
  public int attack() {
    // use of random class
    Random rand = new Random();
    // determine if the player hits
    int hit = rand.nextInt(3 + accuracyModifier);
    // check that the player hits
    if(hit > 0) {
      // calculate and return damage
      int damage = rand.nextInt(2) + damageModifier;
      return damage;
    }
    else {
      return 0;
    }
  }

}
