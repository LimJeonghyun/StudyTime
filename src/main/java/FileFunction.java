import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*;
import java.nio.file.Paths;

public class FileFunction {

    public void saveData(ArrayList<Person> list){
        try{
            String path = Paths.get(".").toAbsolutePath().toString();
            String filename = path+"/data.txt";
            File file = new File(filename);
//                FileWriter fw = new FileWriter(file, true);
            FileWriter fw = new FileWriter(file, true);
//            PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true));
            for(Person p:list){
//                fw.write(p.toString() + "\n");
                fw.write(p.getName() + " / " + p.getStudent() + " / " + p.getTeam() + " / " + p.getTime() + " / " + p.getDate() + "\n");
            }
            fw.flush();
            fw.close();
            System.out.println("파일저장완료!!!");

        }catch(FileNotFoundException e){
            System.out.println("파일이 없음");
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public ArrayList<Person>  readFile(){
        ArrayList<Person> list = new ArrayList<>();

            try {
                File file = new File("data.txt");
                FileReader reader = new FileReader(file);
                BufferedReader bufReader = new BufferedReader(reader);
                String line = "";

                while ((line = bufReader.readLine()) != null) {

                    StringTokenizer st = new StringTokenizer(line, "/");

                    String name = st.nextToken().trim();
                    int student = Integer.parseInt(st.nextToken().trim());
                    String team = st.nextToken().trim();
                    int time = Integer.parseInt(st.nextToken().trim());
                    String date = st.nextToken().trim();

                    list.add(new Person(name, team, time, student, date));
                }
                bufReader.close();
            }catch (FileNotFoundException e){
                System.out.println("no file");
            }catch(IOException e){
                System.out.println(e);
            }

        return list;
    }
}
