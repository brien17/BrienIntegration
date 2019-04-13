public class StrongEnemy extends Enemy{
  // constructor for StrongEnemy class
  public StrongEnemy(int playerLevel) {
    super(playerLevel);
  }
  
  // make the enemy attack 
  public int attack() {
    int damage = super.attack();
    return damage * 2;
  } 
}
