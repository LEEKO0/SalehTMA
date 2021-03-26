package MT251.TMA;

import java.util.*;

public class Section extends Course implements Comparable<Section> {

    private String sectionNumber;
    private Instrctor instrctor = new Instrctor();;
    private Map<String, Student> students = new HashMap<>();
    private String branch;
    public static final int MAXIUMUM_NUMBER = 25;
    private boolean isEveryWeek;

    public Section() {
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public boolean isEveryWeek() {
        return isEveryWeek;
    }

    public void SetIsEveryWeek(boolean isEveryWeek) {
        this.isEveryWeek = isEveryWeek;
    }

    public void setEveryWeek(boolean isEveryWeek) {
        this.isEveryWeek = isEveryWeek;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStudents() {
        String studentList = "";
        int counter = 0;
        for (String key : students.keySet()) {
            studentList += ++counter + "-" + "  id: " + students.get(key).getId() + " \t " + "Name: "
                    + students.get(key).getFullName() + " \t " + "Program: " + students.get(key).getProgram() + '\n';
        }
        return studentList;
    }

    public Student getStudent(String name, String program) {
        for (String key : students.keySet()) {
            if (students.get(key).getFullName().equals(name))
                if (students.get(key).getProgram().equals(program))
                    return students.get(key);
        }
        return null;
    }

    public double getStudentNumber() {
        return this.students.size();
    }

    public static void createNewSection(Set<Section> sections) {
        Section newSection = new Section();
        System.out.println("Please fill this information: 1:Course code. 2:Section Number. 3:Branch. ");
        System.out.print("Course code: ");
        newSection.setCourseCode(Registration.input.next());
        System.out.print("Section Number: ");
        newSection.setSectionNumber(Registration.input.next());

        if (sections.size() == 0) {
            System.out.print("Branch: ");
            newSection.setBranch(Registration.input.next());
            System.out.print("Credit hours: ");
            newSection.setCreditHours(Registration.input.nextInt());
            System.out.print("Is Every Week?  ");
            newSection.SetIsEveryWeek(Registration.input.nextBoolean());

            sections.add(newSection);
            System.out.println("\n---- Add new section ---- \n");
            Instrctor.addNewIntrecotr(newSection);
        } else {
            int counter = 0;
            for (Section section : sections) {
                if (section.getCourseCode().equals(newSection.getCourseCode())) {
                    if (section.getSectionNumber().equals(newSection.getSectionNumber())) {
                        counter = -1;
                        break;
                    }
                }
            }
            if (counter == 0) {

                System.out.print("Branch: ");
                newSection.setBranch(Registration.input.next());
                System.out.print("Credit hours: ");
                newSection.setCreditHours(Registration.input.nextInt());
                System.out.print("Is Every Week?  ");
                newSection.SetIsEveryWeek(Registration.input.nextBoolean());

                Instrctor.addNewIntrecotr(newSection);
                sections.add(newSection);
            } else {
                System.out.println("---- This section aleardy added ----");
            }
        }
        Registration.continueOrNot(sections);
    }

    public void addNewStudent(Student student) {
        if (this.students.containsKey(student.getId())) {
            System.out.println("\n---- The student is aleady added ----\n");
        } else if (this.students.size() <= MAXIUMUM_NUMBER) {
            System.out.println("\n----The student is added ----\n");
            this.students.put(student.getId(), student);
        } else
            System.out.println("\n----This section is filled----\n");
    }

    public void removeStudent(Student student) {
        // System.out.println(student);
        if (this.students.containsKey(student.getId())) {
            System.out.println("\n---- the student with id " + student.getId() + " is removed.----\n");
            this.students.remove(student.getId());
        } else
            System.out.println("\n---- Student not found ----\n");
    }

    public String getInstrctor() {
        return instrctor.toString();
    }

    public void setInstrctor(Instrctor instrctor) {
        this.instrctor = instrctor;
    }

    public static void averageOfStudent(Set<Section> sections) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");
            Registration.continueOrNot(sections);
        } else {

            System.out.println("\n**************************");
            System.out.println("Section Information: ");
            System.out.println("**************************\n");

            System.out.print("Enter Cousre Code: ");
            String courseCode = Registration.input.nextLine();

            courseCode = Registration.input.nextLine();
            double totalStudent = 0.0;

            for (Section section : sections) {
                if (section.getCourseCode().equals(courseCode)) {
                    totalStudent += section.getStudentNumber();
                }
            }
            if (totalStudent == 0.0) {
                System.out.println("\n---- We don't found any students in " + courseCode + " ----\n");
                Registration.continueOrNot(sections);
            }
            System.out.print("Enter Section Number:");
            String sectionNumber = "";
            sectionNumber = Registration.input.nextLine();
            double studentAvarge = 0.0;

            for (Section section : sections) {
                if (section.getSectionNumber().equals(sectionNumber)) {
                    studentAvarge = totalStudent / section.getStudentNumber();
                    break;
                }
            }

            if (studentAvarge == 0.0)
                System.out.println("\n---- Section not found, Please add new section with this number " + sectionNumber
                        + " to " + courseCode + " course " + "----\n");
            else
                System.out.println("\n---- The avarge of student in sectionNumber " + sectionNumber + " to "
                        + courseCode + " course,  is " + studentAvarge + " ----\n");
            Registration.continueOrNot(sections);
        }
    }

    public static Section searchForSection(String courseCode, String sectionNumber, Set<Section> sections) {
        for (Section lookingForSection : sections) {
            if (lookingForSection.getCourseCode().equals(courseCode)
                    && lookingForSection.getSectionNumber().equals(sectionNumber)) {
                return lookingForSection;
            }

        }

        System.out.println("---- Section not found, Please add new Section ----");
        return null;
    }

    @Override
    public String toString() {

        return "\n=================================\n" + super.toString() + "\t\t" + "Is Every Week: "
                + this.isEveryWeek() + "\n" + "Section Number: " + this.getSectionNumber() + "\n" + "Branch: "
                + this.getBranch() + "\n" + "-----------------------------\n" + "Instrctor: \n" + instrctor.toString()
                + "\n-----------------------------\n" + "List of Students: \n\n" + this.getStudents()
                + "\n=================================\n";
    }

    @Override
    public int compareTo(Section o) {
        int COURSE_COMAPARE = this.getCourseCode().compareTo(o.getCourseCode());
        int SECTION_COMPARE = this.getSectionNumber().compareTo(o.getSectionNumber());
        if (COURSE_COMAPARE == 0) {
            if (SECTION_COMPARE > 0)
                return 1;
            else if (SECTION_COMPARE < 0)
                return -1;
            return 0;
        } else if (COURSE_COMAPARE > 0)
            return 1;
        else if (COURSE_COMAPARE < 0)
            return -1;
        return 0;
    }

}
