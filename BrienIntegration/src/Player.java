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
  private String[] inventory = new String[10];
  
  //methods
  public Player() {
    // setting the players inventory to empty
    for(int i = 0 ; i < inventory.length; i++) {
      inventory[i] = "Empty";  
    }
  }
  
  // sets the stats for player class
  public void setPlayerClass(String pc) {
    switch(pc) {
      case "0":
        this.playerClass = "0";
        health = 100;
        level = 1;
        damageModifier = 10;
        accuracyModifier = 10;
        break;
        
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
  
  // clears the inventory
  public void clearInventory() {
    for(int i = 0 ; i < inventory.length; i++) {
      inventory[i] = "Empty";
    }
  }
  
  // returns the inventory
  public String getInventoryAt(int position) {
    return inventory[position];
  }
  // shows the inventory
  public void showInventory() {
    for(int i = 0 ; i < inventory.length; i++) {
      if(i == inventory.length - 1){
        System.out.print(inventory[i]);
      }
      else {
        System.out.print(inventory[i] + ", ");
      }
    }
  }
}
