import java.util.ArrayList;
import java.util.Random;
public class Tama {
    private int hunger = 0;
    private int boredom = 0;
    private ArrayList<String> words = new ArrayList<String>();
    private boolean isAlive = true;
    private Random rand = new Random();
    public String name;

    public Tama(String name) {
        this.name = name;
    }

    public void gameLoop(){
        while (getAlive()) {
            int val = Main.menuChoice(new String[]{"Lär den nya ord", "Få den att säga något", "Gör ingenting", "Mata den", "Statistik om tama", "Exit"});
            if (val == 1) {
                System.out.println("Vilket ord vill du lära den?");
                teach(Main.sc.nextLine());
                tick();
            } else if (val == 2) {
                speak();
                tick();
            } else if (val == 3) {
                tick();
            } else if (val == 4) {
                feed();
                tick();
            } else if (val == 5) {
                printStats();
                tick();
            } else if (val == 6) {
                break;
            }
            if (!getAlive()) {
                System.out.println(name + " dog, REST IN PEACE");
            }
        }
    }
    public void feed(){
        if(hunger >= 2) {
            hunger -= 2;
        } else{
            hunger = 0;
        }
    }
    public void speak(){
        if (words.size() != 0) {
            System.out.println(name + " säger " + words.get(rand.nextInt(words.size())));
            reduceBoredom(2);
        } else {
            System.out.print(name + " kan inga ord, lär den ett: ");
            teach(Main.sc.nextLine());
        }
    }
    public void teach(String word){
        words.add(word);
        reduceBoredom(2);
    }
    public void tick(){
        boredom++;
        hunger++;
    }
    public void printStats(){
        if(isAlive) {
            System.out.println(name + " är vid liv och har " + hunger + " hunger och har " + boredom + " boredom");
        }
    }
    public boolean getAlive(){
        if(hunger > 10 || boredom > 10){
            return false;
        } else {
            return true;
        }
    }
    private void reduceBoredom(int i){
        if(boredom >= i){
            boredom -= i;
        } else{
            boredom = 0;
        }
    }
}
