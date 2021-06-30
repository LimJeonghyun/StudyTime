import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Search {

    BufferedReader br;

    public void searchTeam(ArrayList<Person> list){

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("검색할 팀 입력");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String te = br.readLine();
            boolean check = false;

            int i = 1;
            for(Person p : list){
                if(p.getTeam().equals(te)){
                    if(!check) {
                        System.out.println("No Id Name Team Time(h) Date");
                        check = true;
                    }
                    System.out.println(i + ". " + p.toString());
                    i++;
                }
            }
            if(!check) System.out.println("검색 결과 없음");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchName(ArrayList<Person> list){

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("검색할 이름 입력");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String name = br.readLine();
            boolean check = false;

            int i = 1;
            for(Person p : list){
                if(p.getName().equals(name)){
                    if(!check) {
                        System.out.println("No Id Name Team Time(h) Date");
                        check = true;
                    }
                    System.out.println(i + ". " + p.toString());
                    i++;
                }
            }
            if(!check) System.out.println("검색 결과 없음");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
