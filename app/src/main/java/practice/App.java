/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package practice;

public class App {
    private String greeting =  "What's up!";
    private String animal;
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String newGreeting) {
         greeting = newGreeting;
    }

    public void catsVsDogsAsk(String animal){
        this.animal = animal;
    }
    public String getAnimal(){
        return animal;
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
