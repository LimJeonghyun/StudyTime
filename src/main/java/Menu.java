//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.*;

public class Menu {
    BufferedReader br;

    public String printMenu() throws IOException{
        System.out.println("---menu---");
        System.out.println("1. 조회");
        System.out.println("2. 신규 등록");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 기존 등록");
        System.out.println("6. 팀 검색");
        System.out.println("7. 이름 검색");
        System.out.println("8. 파일 저장");
        System.out.println("0. 종료");
        System.out.println("----------");

        br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}