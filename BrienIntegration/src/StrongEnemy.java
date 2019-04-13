// Cameron Brien
// class used in my main program
/*
 * In java inheritance lets you use the methods and fields from a parent class in another class.
 * This lets you reuse code and create new classes that retain the features of the old class but can
 * have their own fields and methods as well. You can also overload methods used
 * 
 */

public class StrongEnemy extends Enemy {
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
