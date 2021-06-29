import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    BufferedReader br;
    private List<Person> list;

    public Menu() {
        this.list = new ArrayList<>();
    }

    public void printMenu() {
        System.out.println("---menu---");
        System.out.println("1. 조회");
        System.out.println("2. 신규 추가");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 기존 추가");
        System.out.println("6. 팀 검색");
        System.out.println("7. 이름 검색");
        System.out.println("0. 종료");
        System.out.println("----------");
    }

    public boolean menuChoose(String input) {
        switch (input) {

            case "1":
                readData();
                break;

            case "2":
                createData();
                break;

            case "3":
                updateData();
                break;

            case "4":
                deleteData();
                break;

            case "5":
                existedData();
                break;

            case "6":
                searchTeam();
                break;

            case "7":
                searchName();
                break;

            case "0":
                System.out.println("종료");
                return false;

            default:
                System.out.println("잘못된 메뉴 선택");
        }
        return true;
    }

    private void searchTeam(){

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("검색할 팀 입력");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String te = br.readLine();
            boolean check = false;

            for(Person p : list){
                if(p.getTeam().equals(te)){
                    if(!check) {
                        System.out.println("No StudentId Name Team Time(h) Date");
                        check = true;
                    }
                    System.out.println(p.toString());
                }
            }
            if(!check) System.out.println("검색 결과 없음");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void searchName(){

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("검색할 이름 입력");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String name = br.readLine();
            boolean check = false;

            for(Person p : list){
                if(p.getName().equals(name)){
                    if(!check) {
                        System.out.println("No StudentId Name Team Time(h) Date");
                        check = true;
                    }
                    System.out.println(p.toString());
                }
            }
            if(!check) System.out.println("검색 결과 없음");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void existedData(){
        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("---선택---");
        System.out.println("1. 이름");
        System.out.println("2. 팀명");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String choice = br.readLine();
            if(choice.equals("1")){
                searchName();
            }
            else if(choice.equals("2")){
                searchTeam();
            }
            else {
                System.out.println("틀린 번호 입니다.");
                existedData();
            }

            System.out.println("업데이트할 번호 입력");
            int num = Integer.parseInt(br.readLine());
            if(valid(num-1)) {
                System.out.println("시간 입력");
                int t = Integer.parseInt((br.readLine()));
                this.list.get(num-1).setTime(this.list.get(num-1).getTime()+t);
                System.out.println("업데이트되었습니다.");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteData() {

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        for (Person p: this.list) {
            System.out.println(p.getNum()+1 + "번째 학생 이름:" + p.getName() + "팀명: " + p.getTeam());
            System.out.println(" 누적 시간: " + p.getTime());
        }

        System.out.println("삭제할 번호 입력");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine())-1;
            if(valid(num)) {
                this.list.remove(num);
                for(int i=0; i < list.size(); i++)
                    this.list.get(i).setNum(i);
                System.out.println("삭제되었습니다.");
            }else {
                deleteData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateData() {

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        try {
            for (Person p: this.list) {
                System.out.println(p.getNum()+1 + "번째 학생 이름:" + p.getName() + "팀명: " + p.getTeam());
                System.out.println(" 누적 시간: " + p.getTime());
            }

            System.out.println("수정할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine())-1;
            if(valid(num)) {
                System.out.println("이름 입력");
                this.list.get(num).setName(br.readLine());
                System.out.println("학번 입력");
                this.list.get(num).setStudent(Integer.parseInt(br.readLine()));
                System.out.println("팀명 입력");
                this.list.get(num).setTeam(br.readLine());
                System.out.println("시간 입력");
                this.list.get(num).setTime(Integer.parseInt(br.readLine()));
                System.out.println("수정되었습니다.");
            } else {
                updateData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createData() {
        Person p = new Person();
        try {
            System.out.println("이름 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            p.setName(br.readLine());
            System.out.println("학번 입력");
            p.setStudent(Integer.parseInt(br.readLine()));
            System.out.println("팀명 입력");
            p.setTeam(br.readLine());
            System.out.println("시간 입력");
            p.setTime(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setNum(this.list.size());
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        p.setDate(regDate);
        this.list.add(p);
        System.out.println("추가되었습니다.");
    }

    private void readData() {

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("No StudentId Name Team Time(h)");
        System.out.println("==========================================");
        for (Person p: this.list) {
            System.out.println(p.toString());
        }
    }

    private boolean valid(int num) {
        // 배열 범위
        if (this.list.size() <= num) {
            System.out.println("없는 번호 입니다.");
            return false;
        }

        return true;
    }

}
