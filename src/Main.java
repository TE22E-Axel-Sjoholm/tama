import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Tama> tamaList = new ArrayList<>();
        while (true) {
            for(int i = 0; i < tamaList.size(); i++){
                System.out.println(i+1 + ". Ladda " + tamaList.get(i).name);
            }
            System.out.println(tamaList.size()+1 + ". Skapa en ny tama");
            var val = sc.nextInt();
            sc.nextLine();
            if (val == tamaList.size()+1) {
                System.out.println("Vad ska din nya tama heta?");
                String name = sc.nextLine();
                Tama newTama = new Tama(name);
                tamaList.add(newTama);
                newTama.gameLoop();
            } else {
                tamaList.get(val-1).gameLoop();
            }
        }
    }


    public static int menuChoice(String[] val) {
        while (true) {
            for (int i = 0; i < val.length; i++) {
                System.out.println(i + 1 + ". " + val[i]);
            }
            var choice = sc.nextLine();
            return Integer.parseInt(choice);
        }
    }
}