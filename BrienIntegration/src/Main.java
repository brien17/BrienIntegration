import java.util.Scanner;

// Cameron Brien
// A program to show skills learned in COP 2006.


public class Main {
  // final is a keyword that makes it so a variable is immutable
  final int START = 12;

  public static void main(String[] args) {

    System.out.println("Welcome to my program");
    /*
     * description of data types 
     * 1. Byte - An 8-bit datatype that can be useful for memory saving in large arrays due to its 
     * small size. 
     * 2. Short - A 16-bit datatype that can be used to save memory when a byte is too small. 
     * 3. Int - a 32-bit datatype that can hold a signed integer or an unsigned integer. 
     * 4. Long - A 64-bit integer that can be signed or unsigned. 
     * 5. Float - A 32-bit datatype that can represent floating point numbers and is a memory saving
     * alternative to double. 
     * 6. Double - A 64-bit datatype that can represent floating point numbers, the default choice 
     * for floating point numbers. 
     * 7. Boolean - Has one of two values, true or false.
     * 8. Char - A 16-bit data type that holds a single unicode character.
     * 
     * A variable is a location in memory where information we will want to use later is stored.
     * 
     * scope determines what will have access to a variable
     */

    boolean isHeads = true;
    Scanner scan = new Scanner(System.in);
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
    System.out.println(userInt);
    System.out.println(userDouble);
    System.out.println(userString);

    System.out.println("enter a starting number " + "and an ending number");
    int start = scan.nextInt();
    int end = scan.nextInt();
    userString = userString.substring(start, end);
    System.out.println("Your substring is");
    System.out.println(userString);
    scan.close();

  }

}

class Clock {
  // fields
  private int angleOfHourHand;
  private int angleOfSecondHand;

  // methods
  public void time() {

  }

}
