import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crud {
    public static void main(String[] args) {
        Menu m = new Menu();
        System.out.println("***시작***");
        boolean check = true;
        while (check) {
            try {
                m.printMenu();
                BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in)); // Using BufferedReader
                String input = sbr.readLine();
                check = m.menuChoose(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
