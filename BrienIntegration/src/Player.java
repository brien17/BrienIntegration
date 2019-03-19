import java.util.Random;

// Cameron Brien
// class used to model the player character

public class Player {
  //fields
  private int health;
  private int level;
  private int damageModifier;
  private int accuracyModifier;
  private String playerClass;
  //methods
  
  // constructor for player class
  public void setStats(String pc) {
    switch(pc) {
      case "0":
        health = 100;
        level = 1;
        damageModifier = 10;
        accuracyModifier = 10;
        break;
        
    }
  }
  
  // set the class
  public void setPlayerClass(String playerClass) {
    this.playerClass = playerClass;
  }
  
  // get the class
  public String getPlayerClass() {
    return playerClass;
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
    int hit = rand.nextInt(30 + accuracyModifier);
    // check that the player hits
    if(hit > 10) {
      // calculate and return damage
      int damage = rand.nextInt(20) + damageModifier;
      return damage;
    }
    else {
      return 0;
    }
  }
}
