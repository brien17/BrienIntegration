import java.util.Random;

public class Enemy {
  //fields
  int health;
  int damageModifier;
  int accuracyModifier;
  
  //methods
  public void generateEnemy(int playerLevel) {
    health = 3 + playerLevel;
    damageModifier = playerLevel;
    accuracyModifier = playerLevel;
  }
  public int showHealth() {
    return health;
  }
  public void takeDamage(int damage){
    health = health - damage;
  }
  public int attack() {
    Random rand = new Random();
    int aim = rand.nextInt(2 + accuracyModifier);
    int damage = rand.nextInt(2) + damageModifier;
    if(aim > 0) {
      return damage;
    }
    else {
      return 0;
    }
  }
  
  
  
}
