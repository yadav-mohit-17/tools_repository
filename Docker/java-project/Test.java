import java.util.Properties;

class Test {

  public static void printSystemProperties() {
    System.out.println("Printing System properties using java program");
    Properties prop = System.getProperties();
    System.out.println(prop);
  }

  public static void main(String[] args) {
    System.out.println("Java Program Started");
    printSystemProperties();
  }
}