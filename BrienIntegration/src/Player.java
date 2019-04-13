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
  //constructor for the player class
  public Player() {
    // setting the players inventory to empty
    for(int i = 0 ; i < inventory.length; i++) {
      inventory[i] = "Empty";  
    }
    health = 100;
    level = 1;
    damageModifier = 15;
    accuracyModifier = 15;
  }
  //constructor to set a player at a starting level
  public Player(int level) {
    // setting the players level to a given level
    this.level = level;
    // setting the players inventory to empty
    for(int i = 0 ; i < inventory.length; i++) {
      inventory[i] = "Empty";  
    }
    health = 100 + (10 * level);
    damageModifier = 15 + (2 * level);
    accuracyModifier = 15 + (2 * level);
  }
  
  // sets the stats for player class
  public void setPlayerClass(String pc) {
    playerClass = pc;
    if(pc.equals("cheater")) {
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
  // make the player take damage
  public void takeDamage(int damage){
    health -= damage;
  }
  
  // return the players damage modifier
  public int getDamageModifier() {
    return damageModifier;
  }
  
  //set players damage modifier 
  public void setDamageModifier(int dm) {
    damageModifier = dm;
  }
  // return the players accuracy
  public int getAccuracyModifier() {
    return accuracyModifier;
  }
  
  //set accuracy 
  public void setAccuracyModifier(int ac) {
    accuracyModifier = ac;
  }  
  
  // return the players level
  public int getLevel() {
    return level;
  }
  
  //set players level 
  public void setLevel(int level) {
    this.level = level;
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
  
  // make the player attack with an accuracy bonus and/or a damage bonus
  public int attack(int accuracyBonus, int damageBonus) {
    // use of random class
    Random rand = new Random();
    // determine if the player hits
    int hit = rand.nextInt(30 + accuracyModifier + accuracyBonus);
    // check that the player hits
    if(hit > 10) {
      // calculate and return damage
      int damage = rand.nextInt(20) + damageModifier + damageBonus;
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
  
  // print the entire inventory
  public void printInventory() {
    for(String item: inventory) {
      System.out.print(item + " ");
    }
  }
  
  // returns the inventory at a position
  public String getInventoryAt(int position) {
    return inventory[position];
  }
  
  // shows the inventory
  public void showInventory() {
    for(String item: inventory){
      System.out.println(item + " ");
    }
  }
}
