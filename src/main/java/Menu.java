//import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;


public class Menu<list> {

    BufferedReader br;
    private List<Person> list;

    public Menu() {
        this.list = new ArrayList<>();

    }

    public void printMenu() {
        System.out.println("---menu---");
        System.out.println("1. 조회");
        System.out.println("2. 신규 등록");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 기존 등록");
        System.out.println("6. 팀 검색");
        System.out.println("7. 이름 검색");
        System.out.println("8. 파일 저장");
        System.out.println("9. 파일 읽어오기");
        System.out.println("0. 종료");
        System.out.println("----------");
    }

    public boolean menuChoose(String input) {
        switch (input) {

            case "1":
                readData(list);
                break;

            case "2":
                createData(list);
                break;

            case "3":
                updateData(list);
                break;

            case "4":
                deleteData(list);
                break;

            case "5":
                existedData(list);
                break;

            case "6":
                searchTeam(list);
                break;

            case "7":
                searchName(list);
                break;

            case "8":
                saveData(list);
                break;

            case "9":
                readFile();
                break;


            case "0":
                System.out.println("종료");
                return false;

            default:
                System.out.println("잘못된 메뉴 선택");
        }
        return true;
    }

    private void saveData(List<Person> list){
        String path = Paths.get(".").toAbsolutePath().toString();
        String filename = path+"/data.txt";
        try{
            java.io.File file = new java.io.File(filename);
//                FileWriter fw = new FileWriter(file, true);
            FileWriter fw = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true));
            for(Person p:list){
                fw.write(p.toString());
                fw.write("\r\n");
                fw.flush();
            }
            fw.close();
            System.out.println("파일저장완료!!!");

        }catch(FileNotFoundException e){
            System.out.println("파일이 없음");
        }catch(IOException e){
            System.out.println(e);
        }
    }

    private List<Person>  readFile(){
        ArrayList<Person> list = new ArrayList<>();

//        String path = Paths.get(".").toAbsolutePath().toString();
//        String filename = path+"/data.txt";
//
//        java.io.File file = new java.io.File(filename);
        try {
            File file = new File("data.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = null;
            int i = 0;

            if (file.exists()) {
                while ((line = bufReader.readLine()) != null) {
                    System.out.println(line);

                    StringTokenizer st = new StringTokenizer(line, "/");

                    int student = Integer.parseInt(st.nextToken().trim());
                    String name = st.nextToken().trim();
                    String team = st.nextToken().trim();
                    int time = Integer.parseInt(st.nextToken().trim());
                    String date = st.nextToken().trim();

                    list.add(new Person(name, team, time, student, date));
                    i++;

                }
                bufReader.close();
            }
        }catch (FileNotFoundException e){
            System.out.println("no file");
        }catch(IOException e){
            System.out.println(e);
        }
        return list;
    }


    private void searchTeam(List<Person> list){

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
                        System.out.println("No Id Name Team Time(h) Date");
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

    private void searchName(List<Person> list){

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
                        System.out.println("No Id Name Team Time(h) Date");
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



    private void existedData(List<Person> list){
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
                searchName(list);
            }
            else if(choice.equals("2")){
                searchTeam(list);
            }
            else {
                System.out.println("틀린 번호 입니다.");
                existedData(list);
            }

            System.out.println("업데이트할 번호 입력");
            int num = Integer.parseInt(br.readLine())-1;
            if(valid(num)) {
                System.out.println("시간 입력");
                int t = Integer.parseInt((br.readLine()));
                this.list.get(num).setTime(this.list.get(num).getTime()+t);
                System.out.println("업데이트되었습니다.");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteData(List<Person> list) {

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        int i = 1;
        for (Person p: this.list) {
            System.out.println("No Id Name Team Time(h) Date");
            System.out.println(i + p.toString());
        }

        System.out.println("삭제할 번호 입력");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine())-1;
            if(valid(num)) {
                this.list.remove(num);
                System.out.println("삭제되었습니다.");
            }else {
                deleteData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateData(List<Person> list) {

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        try {
            int i = 1;
            for (Person p: this.list) {
                System.out.println("No Id Name Team Time(h) Date");
                System.out.println(i + p.toString());
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
                updateData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createData(List<Person> list) {
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
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        p.setDate(regDate);
        this.list.add(p);
        System.out.println("추가되었습니다.");
    }

    private void readData(List<Person> list) {

        if( this.list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("No Id Name Team Time(h)");
        System.out.println("==========================================");
        int i =1;
        for (Person p: this.list) {
            System.out.println(i + p.toString());
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