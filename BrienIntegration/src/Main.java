import java.util.Scanner;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

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

    System.out.println("Welcome to my program");
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
    /*
     * boolean isHeads = true; //Scanner scan = new Scanner(System.in); //scannerDemo(scan); double
     * num1 = 5; // this is a call, the parenthesis contain an argument num1 = squareIt(num1);
     * System.out.println(num1);
     * 
     * Car myCar = new Car(); Car otherCar = new Car(); myCar.setColor("green");
     * System.out.println(myCar.getColor()); otherCar.setColor("blue");
     * System.out.println(otherCar.getColor()); myCar.setMake("corrola");
     * System.out.println(myCar.getMake());
     */

    Scanner scan = new Scanner(System.in);
    System.out.println("would you like to run integration or play game?");
    System.out.println("enter 1 for integration and 2 for game");
    int projectOrGame = scan.nextInt();
    if(projectOrGame == 2) {
      int run = 1;
      // creating the player object
      Player pl1 = new Player();
      // creating an enemy object
      Enemy en1 = new Enemy();
      // generating stats for the player
      pl1.newPlayer();
      // this is a call the parenthesis contain an argument
      // generating stats for the enemy
      en1.generateEnemy(pl1.getLevel());
  
      while (run == 1) {
  
        // make sure end turn is false at the beginning of the turn
        boolean endTurn = false;
        // this loop lets the player make certain actions without ending the turn
        do {
          // get player input
          System.out.println("Enter an Action or help");
          String input = scan.nextLine();
  

          endTurn = interpretInput(input, pl1, en1);
  
        } while (endTurn == false); 
        
        if(en1.showHealth() > 0) {
        
          run = enemyAttack(pl1, en1);
          
          while(run == 0) {
            System.out.println("you died");
            System.out.println("play agian? (y or n)");
            switch(scan.nextLine()) {
              case "y":
                run = 1;
              case "n":
                run = 0;
                System.out.println("thanks for playing");
              default:
                System.out.println("please enter y or n");
            }
          }
        }
        else {
          en1 = new Enemy();
          en1.generateEnemy(pl1.getLevel());
          System.out.println("a new enemy appears");
        }
      }
      
    }
    
    else if(projectOrGame == 1) {
      scannerDemo(scan);
      psi2(scan);
    }
      
      
  }

  // interpret user input
  public static boolean interpretInput(String input, Player pl1, Enemy en1) {
    // use a switch to determine what to return based on input
    switch (input.toLowerCase()) {
      case "help":
        System.out.println("type attack, health, or enemy health");
        return false;
      case "attack":
        System.out.println(playerAttack(pl1, en1));
        return true;
      case "health":
        System.out.println(pl1.showHealth());
        return false;
      case "enemy health":
        System.out.println(en1.showHealth());
        return false;
      default:
        System.out.println("input not understood");
        return false;
    }
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
      }
      else {
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

  // a method to use anything in the psi2 requirements I didn't find a place for
  public static void psi2(Scanner scan) {
    System.out.println("enter two numbers");
    int num1 = scan.nextInt();
    int num2 = scan.nextInt();
    // multiplication
    System.out.println(num1 + " * " + num2 + "is equal to " + (num1 * num2));
    
    // division
    System.out.println(num1 + " / " + num2 + "is equal to " + (num1 / num2));
    
    // modulo
    System.out.println(num1 + " modulo " + num2 + "is equal to " + (num1 % num2));
    
    // ++
    System.out.println(num1 + " and " + num2 + " plus 1 are " + ++num1 + ++num2);
    
    // ? is the ternary operator
    String biggerOrSmaller = (num1 > num2) ? "first bigger than second" : "second bigger than first";
    System.out.println(biggerOrSmaller);
    
  }

}


