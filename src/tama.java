import java.util.ArrayList;
import java.util.Random;
public class tama {
    private int hunger = 0;
    private int boredom = 0;
    private ArrayList<String> words = new ArrayList<String>();
    private boolean isAlive = true;
    private Random rand = new Random();
    public static String name;
    public void feed(){
        if(hunger >= 2) {
            hunger -= 2;
        } else{
            hunger = 0;
        }
    }
    public void speak(){
        System.out.println(name + " säger " + words.get(rand.nextInt(words.size())));
        reduceBoredom(2);
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
