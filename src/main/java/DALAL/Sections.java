package DALAL;

import java.util.*;

public class Sections extends Course {

    private int sectionsNum;
    ArrayList<Student> students = new ArrayList<>();
    private Instructor instructor = new Instructor();
    public static final int LIMIT_OF_STUDENT = 35;
    private int creditsHours;

    Sections() {
        this(0, null, null, 0);
    }

    Sections(int sectionsNum, String courseCode) {
        setCourseCode(courseCode);
        setSectionsNum(sectionsNum);
    }

    Sections(int sectionsNum, ArrayList<Student> student, Instructor instructor, int creditsHours) {
        super(null, null);
        this.sectionsNum = sectionsNum;
        this.students = student;
        this.instructor = instructor;
        this.creditsHours = creditsHours;

    }

    public void setSectionsNum(int sectionsNum) {
        this.sectionsNum = sectionsNum;
    }

    public int getSectionsNum() {
        return this.sectionsNum;
    }

    // public void setStudent(ArrayList<Student> student){
    // this.student = student;
    // }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setCreditsHours(int creditsHours) {
        this.creditsHours = creditsHours;
    }

    public int getCreditsHours() {
        return this.creditsHours;
    }

    public static void addNewSection(ArrayList<Sections> section) {

        Sections sec = new Sections();
        Scanner input = new Scanner(System.in);
        int sectionsNum;
        String courseCode;
        String courseName;

        System.out.println("Enter the courseName");
        courseName = input.nextLine();
        System.out.println("Enter the sectionsNum");
        sectionsNum = input.nextInt();
        System.out.println("Enter the courseCode");
        courseCode = input.nextLine();

        sec.setCourseCode(courseCode);
        sec.setCourseName(courseName);
        sec.setSectionsNum(sectionsNum);

        boolean exist = false;
        for (Sections sec1 : section) {
            if (section.equals(sec)) {
                System.out.println("The section already exists");
                exist = true;
                break;
            }

        }
        if (exist == false) {
            section.add(sec);
            System.out.println("Adding section is successful");
        }

    }

    public void addStudents(Student student) {
        boolean exist = false;
        if (students.size() > LIMIT_OF_STUDENT) {
            System.out.println("The section is full, you can't add");
        }

        else
            for (int i = 0; i < students.size(); i++) {
                if (students.equals(i)) {
                    System.out.println("The Student already exists");
                    exist = true;
                    break;
                }

            }
        if (exist == false) {
            students.add(student);
            System.out.println("Adding student is successful");
        }

    }

    public static void addStudent(Sections section) {
        Student student = new Student();

        Scanner input = new Scanner(System.in);
        String name;
        int id;
        int sectionsNum;
        String courseCode;
        String courseName;
        String gender;

        System.out.println("Enter the name");
        name = input.nextLine();
        System.out.println("Enter the ID");
        id = input.nextInt();
        System.out.println("Enter the sectionsNum");
        sectionsNum = input.nextInt();

        System.out.println("Enter the courseCode");
        courseCode = input.nextLine();
        courseCode = input.nextLine();

        System.out.println("Enter the courseName");
        courseName = input.nextLine();
        System.out.println("Enter the  gender");
        gender = input.nextLine();

        student.setCourseCode(courseCode);
        student.setId(id);
        student.setName(name);
        student.setSectionsNum(sectionsNum);
        student.setCourseName(courseName);
        student.setGender(gender);
        System.out.println(student);
        section.addStudents(student);

    }

    public static void removeStudents(Student student, Sections section) {
        boolean exist = false;

        for (int i = 0; i < section.getStudents().size(); i++) {
            if (section.getStudents().get(i).equals(student)) {
                section.getStudents().remove(i);
                System.out.println("The Student is removed");
                exist = true;
                break;
            }

        }
        if (exist == false) {
            System.out.println("The student not exists ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Sections) {
            Sections section = (Sections) o;
            if (super.equals(section) && section.sectionsNum == this.sectionsNum
                    && section.creditsHours == this.creditsHours && section.instructor.equals(this.instructor))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "" + getCreditsHours() + " " + getInstructor() + " " + getStudents() + " "
                + getSectionsNum();
    }

}
