import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static tama mytama = new tama();

    public static void main(String[] args) {
        System.out.println("vad heter din tama?");
        tama.name = sc.nextLine();
        while(mytama.getAlive()) {
            int val = menuChoice(new String[]{"Lär den nya ord", "Få den att säga något", "Gör ingenting", "Mata den"});
            if (val == 1) {
                System.out.println("Vilket ord vill du lära den?");
                mytama.teach(sc.nextLine());
            } else if (val == 2) {
                mytama.speak();
            } else if (val == 3) {
                break;
            } else if (val == 4){
                mytama.feed();
            }
        }
    }


    public static int menuChoice(String[] val) {
        while (true) {
            for (int i = 0; i < val.length; i++) {
                System.out.println(i + 1 + ". " + val[i]);
            }
            var choice = sc.nextLine();
            if (Character.isDigit(choice.charAt(0)) && choice.length() == 1) {
                return Integer.parseInt(choice);
            }
        }
    }
}