package MT251.TMA;

import java.util.*;

public class Section extends Course {

    private String sectionNumber;
    private Instrctor instrctor = new Instrctor();;
    private Map<String, Student> students = new HashMap<>();
    private String branch;
    public static final int MAXIUMUM_NUMBER = 25;
    private boolean isEveryWeek;

    public Section() {

    }

    public Section(String courseCode, int creditHours, String sectionNumber, String branch, boolean isEveryWeek,
            Instrctor instrctor) {
        this.branch = branch;
        super.setCourseCode(courseCode);
        super.setCreditHours(creditHours);
        this.setSectionNumber(sectionNumber);
        this.setInstrctor(instrctor);
        this.setBranch(branch);
        this.SetIsEveryWeek(isEveryWeek);

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

    public String getInstrctor() {
        return instrctor.toString();
    }

    public void setInstrctor(Instrctor instrctor) {
        this.instrctor = instrctor;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    /**
     * will display all students on formate id - name - progame
     * 
     * @return
     */
    public String displayStudents() {
        String studentList = "";
        int counter = 0;
        for (String key : students.keySet()) {
            studentList += ++counter + "-" + "  id: " + students.get(key).getId() + " \t " + "Name: "
                    + students.get(key).getFullName() + " \t " + "Program: " + students.get(key).getProgram() + '\n';
        }
        return studentList;
    }

    /**
     * this method will looking for a certain student by name and program
     */
    public Student getStudent(String name, String program) {
        Student student = new Student(name, program);
        for (String key : students.keySet()) {
            if (students.get(key).equals(student))
                return students.get(key);
        }
        return null;
    }

    /**
     * on this method will ask user to enter data of section then return section
     */
    public static Section fillSectionData(Section section) {
        System.out.print("Branch: ");
        section.setBranch(Registration.input.next());
        System.out.print("Credit hours: ");
        section.setCreditHours(Registration.input.nextInt());
        System.out.print("Is Every Week?  ");
        section.SetIsEveryWeek(Registration.input.nextBoolean());
        return section;
    }

    /**
     * createNewSection(), first of all, will ask user to enter courseCode and
     * sectionNumber, then check if sections empty or not, if empty will call
     * fillSectionData() to fill section data and added to set, else will check if
     * section aleady exist and if exist it print error message, if not will ask to
     * fill all data of section and ask to fill instructro info
     */
    public static void createNewSection(Set<Section> sections) {
        Section newSection = new Section();
        System.out.println("Please fill this information: 1:Course code. 2:Section Number. 3:Branch. ");
        System.out.print("Course code: ");
        newSection.setCourseCode(Registration.input.next());
        System.out.print("Section Number: ");
        newSection.setSectionNumber(Registration.input.next());

        if (sections.size() == 0) {
            Section.fillSectionData(newSection);
            sections.add(newSection);
            System.out.println("\n---- Add new section ---- \n");
            Instrctor.addNewIntrecotr(newSection);
        } else {
            int counter = 0;
            for (Section section : sections) {
                if (section.equals(newSection)) {
                    counter = -1;
                    break;
                }
            }
            if (counter == 0) {
                Section.fillSectionData(newSection);
                Instrctor.addNewIntrecotr(newSection);
                sections.add(newSection);
            } else {
                System.out.println("---- This section aleardy added ----");
            }
        }
    }

    /**
     * first of all check if student already exist or not, if exist will print error
     * message, else will check about size of student on section
     * 
     * @param student
     */
    public void addNewStudent(Student student) {
        if (this.students.containsKey(student.getId())) {
            System.out.println("\n---- The student is aleady added ----\n");
        } else if (this.students.size() <= MAXIUMUM_NUMBER) {
            System.out.println("\n----The student is added ----\n");

            student.insertCourse(this.getCourseCode(), this.getSectionNumber());
            student.setCurrentCreditHours(this.getCreditHours() + student.getCurrentCreditHours());
            this.students.put(student.getId(), student);
            System.out.println(student);

        } else
            System.out.println("\n----This section is filled----\n");
    }

    /**
     * remvoing student form section, first of all, check if student exist or not,
     * if not found print error message, else remove student
     */
    public void removeStudent(Student student) {

        if (this.students.containsKey(student.getId())) {
            // System.out.println("\n---- The Student with id " + student.getId() + " is
            // removed.----\n");
            System.out.println(student);
            this.students.remove(student.getId());
        } else
            System.out.println("\n---- Removed faild, Student not found ----\n");
    }

    /**
     * on this method will calculate avarage of student per course, firs of all will
     * check about size of section set, if equal zero print error message, else will
     * check about section and total of student on this course, if total of student
     * or number of section equal zero print error message, eles print avarage of
     * student.
     * 
     */

    public static void averageOfStudent(Set<Section> sections, String courseCode) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");
        } else {
            double totalStudent = 0.0;
            double numberSections = 0.0;
            for (Section section : sections) {

                if (section.getCourseCode().equals(courseCode)) {
                    totalStudent += section.getStudents().size();
                    numberSections++;
                }
            }

            if (totalStudent == 0.0 || numberSections == 0.0) {
                System.out.println("\n---- We don't found any students in " + courseCode + " ----\n");
            } else {
                double studentAvarge = totalStudent / numberSections;
                System.out.println(
                        "\n---- The avarge of student in  course " + courseCode + ", is " + studentAvarge + " ----\n");
            }

        }
    }

    /**
     * on this method will calculate avarage of student per course firs of all will
     * check about size of section set, if equal zero print error message, else take
     * course code and call averageOfStudent() with two arragemnt.
     * 
     */
    public static void averageOfStudent(Set<Section> sections) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");

        } else {
            System.out.println("\n**************************");
            System.out.println("Section Information: ");
            System.out.println("**************************\n");

            System.out.print("Enter Cousre Code: ");
            String courseCode = Registration.input.nextLine();

            courseCode = Registration.input.nextLine();
            averageOfStudent(sections, courseCode);
        }
    }

    /**
     * search for section by courseCode and sectionNumber, if section found return
     * section,else return null
     */
    public static Section searchForSection(String courseCode, String sectionNumber, Set<Section> sections) {

        Section section = new Section();
        section.setCourseCode(courseCode);
        section.setSectionNumber(sectionNumber);

        for (Section lookingForSection : sections) {
            if (lookingForSection.equals(section)) {
                return lookingForSection;
            }

        }

        return null;
    }

    /**
     * add new section, check if setion aleardy exist or not, if not add seciton,
     * else print error message
     */
    public static void addSection(Set<Section> sections, Section section) {
        Section searchForSec = searchForSection(section.getCourseCode(), section.getSectionNumber(), sections);
        if (searchForSec == null) {
            sections.add(section);
            System.out.println("\n---- Add new section ---- \n");
        } else {
            System.out.println("---- This section aleardy added ----");

        }

    }

    public String studentsData() {
        String studentAll = "";
        for (Student s : students.values())
            studentAll += "\n" + s;
        return studentAll;
    }

    @Override
    public String toString() {
        return "\n==================================================================\n" + super.toString() + "\t\t"
                + "Is Every Week: " + this.isEveryWeek() + "\n" + "Section Number: " + this.getSectionNumber() + "\n"
                + "Branch: " + this.getBranch() + "\n"
                + "------------------------------------------------------------\n" + "Instrctor: \n"
                + instrctor.toString() + "\n------------------------------------------------------------\n"
                + "List of Students: \n" + studentsData()
                + "\n==================================================================\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Section)
            return ((Section) o).getCourseCode().equals(this.getCourseCode())
                    && ((Section) o).getSectionNumber().equals(this.getSectionNumber());
        return false;
    }

}
