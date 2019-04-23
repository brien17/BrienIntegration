// import java.util.Random;
// Cameron Brien
// class used in my main program
public class Loot {
  // fields
  protected int value;
  protected String name;

  // methods
  public Loot() {
    setName("Empty");
    setValue(0);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHealAmount() {
    return 0;
  }

  public void setHealAmount(int ha) {}

}
