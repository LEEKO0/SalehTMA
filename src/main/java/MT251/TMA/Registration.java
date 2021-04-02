package MT251.TMA;

import java.io.*;
import java.util.*;

public class Registration {
    static Scanner input = new Scanner(System.in);

    static Set<Section> sections = new HashSet<Section>();

    public static void main(String[] arrge) {
        System.out.println("Welcome in Registraion department program.\n\n");
        operatorsSelections(sections);

    }

    public static void operatorsSelections(Set<Section> sections) {
        int count = 0;
        System.out.println("Selece one of Operations: \n");
        System.out.println((++count) + "- Add new Section. ");
        System.out.println((++count) + "- Add new Student in specified section: ");
        System.out.println((++count) + "- Remove Student in specified section: ");
        System.out
                .println((++count) + "- Retrieving the average number of students per section of a specified course: ");
        System.out.println((++count) + "- Displaying all sections offered in the current semester: ");
        System.out.println((++count) + "- Saving all the registration data into a text file: ");
        System.out.println((++count) + "- test all oprations");
        System.out.print("Select one: ");

        try {
            int selcet = input.nextInt();
            System.out.println();
            switch (selcet) {
            case 1:
                Section.createNewSection(sections);
                continueOrNot(sections);
                break;
            case 2:
                Student.addNewStudent(sections);
                continueOrNot(sections);
                break;
            case 3:
                Student.removeStudent(sections);
                continueOrNot(sections);
                break;
            case 4:
                Section.averageOfStudent(sections);
                continueOrNot(sections);
                break;
            case 5:
                Course.displayCourses(sections);
                continueOrNot(sections);
                break;
            case 6:
                savingAllData(sections);
                continueOrNot(sections);
                break;
            case 7:
                runProgram(sections);
                continueOrNot(sections);
                break;
            default:
                operatorsSelections(sections);
            }
        } catch (Exception e) {
            continueOrNot(sections);
        }
    }

    public static void savingAllData(Set<Section> sections) {
        try {
            File file = new File("src/main/java/MT251/TMA/regsistation.txt");
            PrintWriter writer = new PrintWriter(file);
            for (Section section : sections)
                writer.println(section);
            writer.close();

            System.out.println("\n---- Saving data complete ----\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void continueOrNot(Set<Section> sections) {
        System.out.print("Continue Y / N: ");
        String select = input.next().toUpperCase();

        if (select.equals("Y"))
            operatorsSelections(sections);

        else if (!select.equals("N"))
            continueOrNot(sections);

        else
            System.out.println("\n---- Thank you  ----\n");
    }

    /**
     * on runPrograme()
     * 
     */
    public static void runProgram(Set<Section> sections) {

        ArrayList<Student> allStudent = new ArrayList<>();

        allStudent.add(new Student("Saleh Ali", true, 22, "IT - Computer Science", 49));
        allStudent.add(new Student("Ammar Saleh", true, 27, "BU - Accounting", 25));
        allStudent.add(new Student("Ahmed Ali", true, 26, "IT - Computing with Business", 30));
        allStudent.add(new Student("Ali Ahmed", true, 18, "BU - Marketing", 60));
        allStudent.add(new Student("Dalal Ahmed ", false, 21, "IT - Computing", 29));
        allStudent.add(new Student("Rabba Ahmed ", false, 22, "IT - Network and Security", 13));
        allStudent.add(new Student("Ahlam Saleh", false, 20, "IT - Computing", 29));
        allStudent.add(new Student("Abdorhman Saleh", true, 20, "IT - Network and Security", 29));
        allStudent.add(new Student("Omar Abdorhman", true, 20, "IT - Network and Security", 29));
        allStudent.add(new Student("Asmaa Ahmed", false, 27, "IT - Computing with Business", 29));
        allStudent.add(new Student("Nora Ahmed", false, 20, "IT - Computer Science", 29));
        allStudent.add(new Student("ELtaybe Karrar", true, 23, "IT - Computer Science", 29));
        allStudent.add(new Student("Rami Osama", true, 22, "IT - Software Engineer", 29));

        ArrayList<Instrctor> instrctors = new ArrayList<>();
        instrctors.add(new Instrctor("Ahmed Rakha", true, 45,
                "Born in Egypt in 1976, BSc, MSc and PhD in Computer Engineering. Assistant Professor at the Department of Systems and Computers Engineering at Al-Azhar University in Cairo, Egypt since 2014. Currently Assistant Professor at Information Technology and Computing College at Arab Open University  KSA. Major specialization in Artificial Intelligence, Machine Learning, Data Engineering and Data Science.",
                "PhD"));
        instrctors.add(new Instrctor("Malak Alameer", false, 30,
                "Mrs. Malak holds a Master of Science in Computer-Based Information System (CBIS) from University of Sunderland in 2008, Sunderland, UK and a B.Sc. degree in Computer Science from the University of King Abdul-Aziz University, Jeddah, Saudi Arabia, in 1991. ",
                "PhD"));
        instrctors.add(new Instrctor("Suha Alsheikh", false, 22,
                "Dr.Suha AlShaikh received her PHD form King Saud University in Riyadh in December 2011. Throughout her Master study in King Saud University she served as a tutor for the tutorial classes in the department of Mathematics and the department of Statistic. Also throughout her PHD study she worked as a part time lecturer in Dammam University , and Arab Open University (for five years). Right after she got her PHD, she received an offer for a full time position as an Assistant Professor in the department of information technology and computing in Arab Open University. In her current position she is the head of  ITC department in Dammam and Ahsa branches, a quality coordinator in Dammam branch and she also a coordinator of some of the FCS courses on the level of Saudi Arabia.    ",
                "PhD"));

        ArrayList<Section> newSections = new ArrayList<>();

        newSections.add(new Section("MT103", 4, "1301", "jeddah", false, instrctors.get(0)));
        newSections.add(new Section("MT103", 4, "1302", "jeddah", false, instrctors.get(0)));
        newSections.add(new Section("M251", 8, "1301", "jeddah", true, instrctors.get(1)));
        newSections.add(new Section("M251", 8, "1302", "jeddah", true, instrctors.get(1)));
        newSections.add(new Section("M251", 8, "1303", "jeddah", true, instrctors.get(1)));
        newSections.add(new Section("MT131", 4, "1301", "jeddah", false, instrctors.get(2)));
        newSections.add(new Section("MT131", 4, "1303", "jeddah", false, instrctors.get(2)));
        newSections.add(new Section("MT112", 8, "1301", "jeddah7", true, instrctors.get(1)));

        System.out.println("\n---- ADDING NEW SECTION ----\n");
        for (Section sec : newSections)
            Section.addSection(sections, sec);

        Section.addSection(sections, newSections.get(0));
        Section.addSection(sections, newSections.get(2));
        Section.addSection(sections, newSections.get(1));

        System.out.println("\n---- ADDING STUDING AND REMOVE STUDENTS AT: " + newSections.get(0).getCourseCode() + " - "
                + newSections.get(0).getSectionNumber() + " ----\n");
        for (int i = 0; i < 4; i++)
            Student.addNewStudent(newSections.get(0), allStudent.get(i));
        Student.removeStudent(newSections.get(0), allStudent.get(0));
        Student.removeStudent(newSections.get(0), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AT: " + newSections.get(1).getCourseCode() + " - "
                + newSections.get(1).getSectionNumber() + " ----\n");

        for (int i = 3; i < 8; i++)
            Student.addNewStudent(newSections.get(1), allStudent.get(i));
        Student.removeStudent(newSections.get(1), allStudent.get(0));
        Student.removeStudent(newSections.get(1), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AT: " + newSections.get(2).getCourseCode() + " - "
                + newSections.get(2).getSectionNumber() + " ----\n");

        for (int i = 7; i < 12; i++)
            Student.addNewStudent(newSections.get(2), allStudent.get(i));
        Student.removeStudent(newSections.get(2), allStudent.get(0));
        Student.removeStudent(newSections.get(2), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AND REMOVE STUDENTS AT: " + newSections.get(3).getCourseCode() + " - "
                + newSections.get(3).getSectionNumber() + " ----\n");
        for (int i = 0; i < 4; i++)
            Student.addNewStudent(newSections.get(3), allStudent.get(i));
        Student.removeStudent(newSections.get(3), allStudent.get(0));
        Student.removeStudent(newSections.get(3), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AT: " + newSections.get(4).getCourseCode() + " - "
                + newSections.get(4).getSectionNumber() + " ----\n");

        for (int i = 3; i < 8; i++)
            Student.addNewStudent(newSections.get(4), allStudent.get(i));
        Student.removeStudent(newSections.get(4), allStudent.get(0));
        Student.removeStudent(newSections.get(4), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AT: " + newSections.get(5).getCourseCode() + " - "
                + newSections.get(5).getSectionNumber() + " ----\n");

        for (int i = 7; i < 12; i++)
            Student.addNewStudent(newSections.get(5), allStudent.get(i));
        Student.removeStudent(newSections.get(5), allStudent.get(0));
        Student.removeStudent(newSections.get(5), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AND REMOVE STUDENTS AT: " + newSections.get(6).getCourseCode() + " - "
                + newSections.get(6).getSectionNumber() + " ----\n");
        for (int i = 0; i < 4; i++)
            Student.addNewStudent(newSections.get(6), allStudent.get(i));
        Student.removeStudent(newSections.get(6), allStudent.get(0));
        Student.removeStudent(newSections.get(6), allStudent.get(0));

        System.out.println("\n---- ADDING STUDING AND REMOVE STUDENTS AT: " + newSections.get(6).getCourseCode() + " - "
                + newSections.get(6).getSectionNumber() + " ----\n");
        for (int i = 0; i < 4; i++)
            Student.addNewStudent(newSections.get(7), allStudent.get(i));
        Student.removeStudent(newSections.get(7), allStudent.get(0));
        Student.removeStudent(newSections.get(7), allStudent.get(0));

        Course.displayCourses(sections);
        Section.averageOfStudent(sections, "M251");
        Section.averageOfStudent(sections, "MT112");
        Section.averageOfStudent(sections, "MT131");
        Section.averageOfStudent(sections, "MT103");
        Section.averageOfStudent(sections, "MT101");

        savingAllData(sections);
    }
}
