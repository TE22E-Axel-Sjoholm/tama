import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Tama> tamaList = new ArrayList<>();
        while (true) {
            String name;
            for(int i = 0; i < tamaList.size(); i++){
                System.out.println(i+1 + ". Ladda " + tamaList.get(i).name);
            }
            System.out.println(tamaList.size()+1 + ". Skapa en ny tama");
            var val1 = sc.nextInt();
            sc.nextLine();
            if (val1 == tamaList.size()+1) {
                System.out.println("Vad ska din nya tama heta?");
                name = sc.nextLine();
                Tama newTama = new Tama(name);
                tamaList.add(newTama);
                newTama.gameLoop();
            } else if (val1 == 1) {
                tamaList.get(0).gameLoop();
            } else if (val1 == 2) {
                tamaList.get(1).gameLoop();
            } else if (val1 == 3) {
                tamaList.get(2).gameLoop();
            }else if (val1 == 4) {
                tamaList.get(3).gameLoop();
            } else if (val1 == 5) {
                tamaList.get(4).gameLoop();
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