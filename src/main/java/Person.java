public class Person {

    private String name;
    private String team;
    private int student;
    private int time;
    private String Date;
    private int num;

    public Person() {

    }

    public Person(int num, String name, String team, int time, int student, String Date) {
        this.name = name;
        this.team = team;
        this.time = time;
        this.student = student;
        this.Date = Date;
        this.num = num;

    }

    @Override
    public String toString() {
        return this.getNum()+1 + ". " + this.getStudent() + " "  + this.getName() + "   " + this.getTeam() + "팀  " + this.getTime() + "(h)  " + this.getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
