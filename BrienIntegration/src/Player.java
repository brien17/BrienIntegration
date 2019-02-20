import java.util.Random;

public class Player {
  //fields
  int health;
  int level;
  int damageModifier;
  int accuracyModifier;
  
  
  //methods
  public int attack() {
    Random rand = new Random();
    int aim = rand.nextInt(3+ accuracyModifier);
    int damage = rand.nextInt(2) + damageModifier;
    if(aim > 0) {
      return damage;
    }
    else {
      return 0;
    }
  }
  
  public void newPlayer() {
    health = 4;
    level = 1;
    damageModifier = 1;
    accuracyModifier = 1;
  }
  public int getLevel() {
    return level;
  }
  
}
