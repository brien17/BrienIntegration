import java.util.Scanner;

// Cameron Brien
// A program to show skills learned in COP 2006.

public class Main {
  // final is a keyword that makes it so a variable is immutable
  final int START = 12;

  // this is a header
  // public is an access modifier
  // void is the return type (it has no return)
  // main is the method name
  public static void main(String[] args) {

    /*
     * description of data types 1. Byte - An 8-bit datatype that can be useful for memory saving in
     * large arrays due to its small size. 2. Short - A 16-bit datatype that can be used to save
     * memory when a byte is too small. 3. Int - a 32-bit datatype that can hold a signed integer or
     * an unsigned integer. 4. Long - A 64-bit integer that can be signed or unsigned. 5. Float - A
     * 32-bit datatype that can represent floating point numbers and is a memory saving alternative
     * to double. 6. Double - A 64-bit datatype that can represent floating point numbers, the
     * default choice for floating point numbers. 7. Boolean - Has one of two values, true or false.
     * 8. Char - A 16-bit data type that holds a single unicode character.
     * 
     * A variable is a location in memory where information we will want to use later is stored.
     * 
     * scope determines what will have access to a variable
     */

    // greet the user
    System.out.println("Welcome to my program");
    // create a scanner object
    Scanner scan = new Scanner(System.in);
    System.out.println("would you like to run integration or play game?");
    System.out.println("enter i for integration and g for game");
    int projectOrGame = 0;
    // choose to run the project or the game
    while (projectOrGame == 0) {
      switch (scan.nextLine()) {
        case "i":
          projectOrGame = 1;
          break;
        case "g":
          projectOrGame = 2;
          break;
        default:
          System.out.println("input not understood");
      }
    }
    // if they want to play the game
    if (projectOrGame == 2) {
      // this is a call and the parenthesis contain an argument
      runGame(scan);
    }
    // run the integration demo
    else if (projectOrGame == 1) {
      scannerDemo(scan);
      psi2(scan);
    }
  }

  // run the game
  public static void runGame(Scanner scan) {

    // set the player as alive
    int playerAlive = 1;
    // creating the player object
    Player pl1 = new Player();
    // creating an enemy object
    Enemy en1 = new Enemy(1);
    // Setting the class for the player
    setpc(scan, pl1);
    // Setting the stats based on class
    pl1.setStats(pl1.getPlayerClass());
    // always have something inside the loop that changes the condition
    while (playerAlive == 1) {

      // make sure end turn is false at the beginning of the turn
      boolean endTurn = false;
      // this loop lets the player make certain actions without ending the turn
      do {
        // get player input
        System.out.println("Enter an Action or help");
        String input = scan.nextLine();

        // make an action and determine if the player's turn is over or not
        endTurn = interpretInput(input, pl1, en1);

      } while (endTurn == false); // keep going until the player's turn is over

      // check that the enemy is sill alive
      if (en1.showHealth() > 0) {

        // have the enemy attack and check if that kills the player
        playerAlive = enemyAttack(pl1, en1);

        // if the player is dead
        while (playerAlive == 0) {
          System.out.println("you died");
          System.out.println("play agian? (y or n)");

          // choose to play again or not
          switch (scan.nextLine()) {
            case "y":
              playerAlive = 1;
              break;
            case "n":
              playerAlive = 0;
              System.out.println("thanks for playing");
              break;
            default:
              System.out.println("please enter y or n");
          }
        }
      }
      // if the enemy is dead
      else {
        int level = pl1.getLevel();
        en1 = new Enemy(level);
        System.out.println("a new enemy appears");
      }
    }
  }

  // interpret user input
  public static boolean interpretInput(String input, Player pl1, Enemy en1) {
    // use a switch to determine what action to take based on user input
    switch (input.toLowerCase()) {
      case "help":
        System.out.println("type attack, health, or enemy health");
        return false;
      case "attack":
        System.out.println(playerAttack(pl1, en1));
        return true;
      case "health":
        System.out.println("you have " + pl1.showHealth() + " health");
        return false;
      case "enemy health":
        System.out.println("Enemy has " + en1.showHealth() + " health");
        return false;
      default:
        System.out.println("input not understood");
        return false;
    }
  }
  
  // set players class
  public static void setpc(Scanner scan, Player pl1) {
    boolean end = false;
    do {
      System.out.println("enter the class you want or help for list of classes");
      String input = scan.nextLine();
      switch(input.toLowerCase()) {
        case "help":
          
        case "0":
          pl1.setPlayerClass("0");
          System.out.println("you are now a " + pl1.getPlayerClass());
          end = true;
          break;
        default:
          System.out.println("input not understood");
      }
      
    }
    while(end == false);
  }

  // player attack
  public static String playerAttack(Player pl1, Enemy en1) {
    int damage = pl1.attack();
    if (damage > 0) {
      en1.takeDamage(damage);
      return "You did " + damage + " damage";
    } else {
      return "You missed";
    }

  }

  // enemy attack
  public static int enemyAttack(Player pl1, Enemy en1) {
    int damage = en1.attack();
    if (damage > 0) {
      pl1.takeDamage(damage);
      System.out.println("Enemy hits you for " + damage + " damage");
      if (pl1.showHealth() <= 0) {
        return 0;
      } else {
        return 1;
      }
    } else {
      System.out.println("Enemy missed");
      return 1;
    }
  }

  // this is a header, the parenthesis contain a parameter
  public static void scannerDemo(Scanner scan) {
    System.out.println("enter an integer");
    int userInt = scan.nextInt();
    System.out.println("enter a double");
    double userDouble = scan.nextDouble();
    /*
     * in a scanner nextline doesn't work after a next with any type of number so you have to clear
     * it out by entering nextline twice
     */
    scan.nextLine();
    System.out.println("enter an string");
    String userString = scan.nextLine();
    System.out.println("You entered");
    System.out.println(userInt);
    System.out.println(userDouble);
    System.out.println(userString);
    // Casting is taking an object of one type and turning it into another type
    int userDoubleAsInt = (int) userDouble;
    System.out.println("Your double as an int would be " + userDoubleAsInt);

    System.out.println("enter a starting number and an ending number to get make a substring from "
        + "your string");
    int start = scan.nextInt();
    int end = scan.nextInt();
    String userSubstring = userString.substring(start, end);
    System.out.println("Your substring is \"" + userSubstring + "\"");
  }

  // a method to use anything in the psi2 requirements I didn't find a convinient place for yet
  public static void psi2(Scanner scan) {
    System.out.println("enter two numbers");
    int num1 = scan.nextInt();
    int num2 = scan.nextInt();
    // multiplication
    System.out.println(num1 + " * " + num2 + " is equal to " + (num1 * num2));

    // division
    System.out.println(num1 + " / " + num2 + " is equal to " + (num1 / num2));

    // --
    System.out.println(num1 + " and " + num2 + " minus 1 are " + --num1 + " and " + --num2);

    // ? is the ternary operator
    String biggerOrSmaller = (num1 > num2) ? "your first number is bigger than second number"
        : "your second number is bigger than first number";
    System.out.println(biggerOrSmaller);
    // +=
    int sum = 0;
    sum += num1 + num2;
    System.out.println(num1 + " plus " + num2 + " is " + sum);

    // math class
    System.out.println(
        num1 + " squared " + num2 + " squared are " + Math.pow(num1, 2) + " " + Math.pow(num2, 2));

    // conditional operator
    if (num1 > 0 && num1 < 100) {
      System.out.println("all prime numbers smaller than your number are");
      boolean prime = true;
      // for loop
      // ++
      for (int i = 0; i < num1; i++) {
        prime = true;
        for (int j = 2; j < i; j++) {
          // %
          if (i % j == 0) {
            prime = false;
            // break ends the execution of a loop and runs the code just below the loop
            break;

          }
        }
        if (prime == false) {
          // continue skips the current iteration of a loop, but does not terminate a loop
          continue;
        }
        System.out.println(i);
      }
    }
    // compare to
    String example1 = "hello";
    String example2 = "hello";
    int same = example1.compareTo(example2);
    boolean equals = example1.equals(example2);
    System.out.println("" + same + equals);
    // using the == operator to compare strings doesn't compare their content but actually compares
    // the location in memory of the two strings
  }
  // operator precedence is the order in which operations will be done if there are more than one
  // operation on a line

}


