import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crud {
    public static void main(String[] args) {
        ArrayList<Person> list;

        Menu m = new Menu();
        Search sr = new Search();
        FileFunction ff = new FileFunction();
        Function f = new Function();

        list = ff.readFile();

        System.out.println("***시작***");

        while (true) {
            try {
               String choose =  m.printMenu();
                switch (choose) {

                    case "1":
                        f.readData(list);
                        break;

                    case "2":
                        f.createData(list);
                        break;

                    case "3":
                        f.updateData(list);
                        break;

                    case "4":
                        f.deleteData(list);
                        break;

                    case "5":
                        f.existedData(list);
                        break;

                    case "6":
                        sr.searchTeam(list);
                        break;

                    case "7":
                        sr.searchName(list);
                        break;

                    case "8":
                        ff.saveData(list);
                        break;

                    case "0":
                        System.out.println("종료");
                        return;

                    default:
                        System.out.println("잘못된 메뉴 선택");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean valid(ArrayList<Person> list, int num) {
        if (list.size() <= num) {
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }
}
