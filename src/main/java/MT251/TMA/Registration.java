package MT251.TMA;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Registration {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] arrge) {
        Set<Section> sections = new HashSet<Section>();
        System.out.println("Welcome in Registraion department program.\n\n");
        // addFakedate(sections, 1);
        // addFakedate(sections, 5);
        // addFakedate(sections, 0);
        // addFakedate(sections, 2);
        operatorsSelections(sections);
    }

    public static void operatorsSelections(Set<Section> sections) {
        int count = 0;
        System.out.println("Selece one of Operations: \n");
        System.out.println((++count) + "- Add new Section. ");
        System.out.println((++count) + "- Add new Student in specified section: ");
        // System.out.println((++count) + "- Add new Instrctor in specified section: ");
        System.out.println((++count) + "- Remove Student in specified section: ");
        System.out
                .println((++count) + "- Retrieving the average number of students per section of a specified course: ");
        System.out.println((++count) + "- Displaying all sections offered in the current semester: ");
        System.out.println((++count) + "- Saving all the registration data into a text file: ");
        System.out.println((++count) + "- toS");
        System.out.print("Select one: ");

        try {
            int selcet = input.nextInt();
            System.out.println();
            switch (selcet) {
            case 1:
                Section.createNewSection(sections);
                break;
            case 2:
                Student.addNewStudent(sections);
                break;
            case 3:
                Student.removeStudent(sections);
                break;
            case 4:
                Section.averageOfStudent(sections);
                break;
            case 5:
                Course.displayingCoruse(sections);
                break;
            case 6:
                savingAllData(sections);
                break;
            case 7:
                toS(sections);
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
            File file = new File("src\\main\\java\\TMA\\regsistation.txt");
            PrintWriter writer = new PrintWriter(file);
            TreeSet<Section> orderSections = new TreeSet<>(sections);
            for (Section section : orderSections)
                writer.println(section);
            writer.close();

            System.out.println("\n---- Saving data complete ----\n");
            continueOrNot(sections);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void toS(Set<Section> sections) {
        System.out.println(sections);
        continueOrNot(sections);
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

    public static void addFakedate(Set<Section> sections, int number) {

        System.out.println("dd");
        for (int i = 0; i < 3; i++) {
            Section section = new Section();
            section.setSectionNumber("Sec" + i);
            section.setBranch("jeddah");
            section.setCourseCode("mt" + number);
            for (int j = 0; j < 5; j++) {
                Student student = new Student();
                student.setFullName("student" + j + "" + i);
                student.setProgram("program" + number);
                student.insertCourse("mt" + number, "Sec" + i);
                section.addNewStudent(student);
            }
            sections.add(section);
            System.out.println("d");

        }
    }

}

/**
 * 
 * 
 * 
 * 
 * Instrctor i = new Instrctor(); i.setFullName("saleh alsaggaf");
 * i.setBirthday(new Date()); i.setId(52); i.setIsMale(true); Section s = new
 * Section(); s.setBranch("jeddah"); s.setCourseCode("mt251");
 * s.setEveryWeek(false); s.setCreditHours(8); s.setInstrctor(i);
 * s.setSectionNumber("123");
 * 
 * Section s2 = new Section(); s2.setBranch("jeddah");
 * s2.setCourseCode("mt251"); s2.setEveryWeek(false); s2.setCreditHours(8);
 * s2.setInstrctor(i); s2.setSectionNumber("123"); Student student = new
 * Student(); student.setSchedule(s2.getCourseCode(), s2.getCreditHours(),
 * "Moring"); student.setBirthday(new Date()); student.setFullName("Sami
 * danna"); student.setId(125464); student.setProgram("IT - Computer Science");
 * student.setIsMale(true); s2.addNewStudent(student);
 * s2.addNewStudent(student);
 * 
 * Student student2 = new Student(); student2.setSchedule(s2.getCourseCode(),
 * s2.getCreditHours(), "Moring"); student2.setBirthday(new Date());
 * student2.setFullName("Rami danna"); student2.setId(12364);
 * student2.setProgram("IT - Computer Science"); student2.setIsMale(true); //
 * s2.addNewStudent(); s2.addNewStudent(student2);
 * 
 * sections.add(s2); sections.add(s); for (Section ss : sections)
 * System.out.println(ss.toString()); System.out.println(); sections = null;
 * 
 */