import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Function {
    BufferedReader br;
    Search sr = new Search();
    Crud cr = new Crud();

    public void existedData(ArrayList<Person> list){
        if( list.size() == 0 ){
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
                sr.searchName(list);
            }
            else if(choice.equals("2")){
                sr.searchTeam(list);
            }
            else {
                System.out.println("틀린 번호 입니다.");
                existedData(list);
            }

            System.out.println("업데이트할 번호 입력");
            int num = Integer.parseInt(br.readLine())-1;
            if(Crud.valid(list, num)) {
                System.out.println("시간 입력");
                int t = Integer.parseInt((br.readLine()));
                int total = t + list.get(num).getTime();
                System.out.println("time :" + total);
                list.get(num).setTime(total);
                System.out.println("업데이트되었습니다.");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(ArrayList<Person> list) {

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        for (Person p: list) {
            System.out.println("No Id Name Team Time(h) Date");
            System.out.println(p.toString());
        }

        System.out.println("삭제할 번호 입력");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine())-1;
            if(Crud.valid(list, num)) {
                list.remove(num);
                System.out.println("삭제되었습니다.");
            }else {
                deleteData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateData(ArrayList<Person> list) {

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        try {
            for (Person p: list) {
                System.out.println("No Id Name Team Time(h) Date");
                System.out.println(p.toString());
            }

            System.out.println("수정할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine())-1;
            if(Crud.valid(list, num)) {
                System.out.println("이름 입력");
                list.get(num).setName(br.readLine());
                System.out.println("학번 입력");
                list.get(num).setStudent(Integer.parseInt(br.readLine()));
                System.out.println("팀명 입력");
                list.get(num).setTeam(br.readLine());
                System.out.println("시간 입력");
                list.get(num).setTime(Integer.parseInt(br.readLine()));
                System.out.println("수정되었습니다.");
            } else {
                updateData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createData(ArrayList<Person> list) {

        Person p = new Person();
        int num = list.size();
        try {
            System.out.println("이름 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
//            name = br.readLine();
            p.setName(br.readLine());
            System.out.println("학번 입력");
//            student = Integer.parseInt(br.readLine());
            p.setStudent(Integer.parseInt(br.readLine()));
            System.out.println("팀명 입력");
//            team = br.readLine();
            p.setTeam(br.readLine());
            System.out.println("시간 입력");
//            time = Integer.parseInt(br.readLine());
            p.setTime(Integer.parseInt(br.readLine()));
            p.setNum(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String Date = date.format(formatter);
        p.setDate(Date);

//        Person p = new Person(name, team, time, student, Date);
        list.add(p);
        System.out.println("추가되었습니다.");
    }

    public void readData(ArrayList<Person> list) {
        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("No Id Name Team Time(h)");
        System.out.println("==========================================");
        for (Person p: list) {
            System.out.println(p.toString());
        }
    }



    }
