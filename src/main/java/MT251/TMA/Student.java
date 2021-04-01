package MT251.TMA;

import java.util.*;

public class Student extends CollegePerson {

    private Map<String, String> schedule = new HashMap<>();
    private int currentCreditHours;
    private int totalCreditComplete;
    private final int REQUIRD_CREDIT_HOURS = 131;
    private String program;

    public Student() {
        this(null, true, 17, null);
    }

    public Student(String fullName, String programe) {
        this(fullName, true, 17, programe);
    }

    public Student(String fullName, boolean isMale, int age, String programe) {
        super(fullName, isMale, age);
        this.setProgram(program);

    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getRemainingCreditHours() {
        return REQUIRD_CREDIT_HOURS - (this.getCurrentCreditHours() + this.getTotalCreditComplete());
    }

    public int getCurrentCreditHours() {
        return currentCreditHours;
    }

    public void setCurrentCreditHours(int currentCreditHours) {
        this.currentCreditHours = currentCreditHours;
    }

    public int getTotalCreditComplete() {
        return totalCreditComplete;
    }

    public void setTotalCreditComplete(int totalCreditComplete) {
        this.totalCreditComplete = totalCreditComplete;
    }

    public Map<String, String> getSchedule() {
        return this.schedule;
    }

    /**
     * pirntSchedule method will return with all current schedule of student
     */
    public String printSchedule() {
        String schedule = "";
        for (String key : this.schedule.keySet()) {
            schedule += key + " ------- " + this.schedule.get(key) + "\n";
        }
        return schedule;
    }

    /**
     * getCourse method, method return of course code, if not exist it will return
     * null
     */
    public String getCourse(String course) {
        if (this.schedule.containsKey(course))
            return this.schedule.get(course);
        return null;
    }

    /**
     * on insertCourse method, we take courseCode and sectionNumber to upadate
     * Student schedule
     */
    public void insertCourse(String coureCode, String sectionNumber) {
        this.schedule.put(coureCode, sectionNumber);
    }

    /**
     * this method will do the next: check if sections is empty or not, if empty
     * will display error message, if sections not empty will ask about courseCode
     * and sectionNumber then will call searchForSeciton(), if return was null the
     * program will print error message, else will ask about studentName and
     * studentProgram then call searchForStudent(), if return was null we will
     * create new student and ask about all information after that add student to
     * section, else will check if student have the course or not, if student have
     * aleady will update sectionNumber, otherwise will add student on section and
     * update his Schedule
     * 
     */
    public static void addNewStudent(Set<Section> sections) {
        String sectionNumber = null;
        String courseCode = null;
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");
        } else {
            System.out.println("\n**************************");
            System.out.println("Section Information: ");
            System.out.println("**************************\n");

            System.out.print("Enter Course Code: ");
            courseCode = Registration.input.nextLine().trim();
            courseCode = Registration.input.nextLine().trim();

            System.out.print("Enter Section Number: ");
            sectionNumber = Registration.input.nextLine().trim();

            Section section = Section.searchForSection(courseCode, sectionNumber, sections);

            if (section != null) {
                System.out.println("\n**************************");
                System.out.println("Student Information: ");
                System.out.println("**************************\n");

                System.out.print("Enter Student Name: ");
                String studentName = Registration.input.nextLine().trim();

                System.out.print("Enter Student Program: ");
                String studentProgram = Registration.input.nextLine().trim();

                Student student = Student.searchForStudent(studentName, studentProgram, sections);
                if (student != null) {
                    if (student.getCourse(courseCode) != null) {
                        student.insertCourse(courseCode, sectionNumber);
                        System.out.println("\n---- Update Student " + student.getFullName() + " with id "
                                + student.getId() + " ----\n");

                    } else {
                        student.insertCourse(courseCode, sectionNumber);
                        System.out.println("\n---- Add new Student in  " + student.getCourse(courseCode) + " - with id "
                                + student.getId() + " ----\n");
                        student.setCurrentCreditHours(student.getCurrentCreditHours() + section.getCreditHours());
                        section.addNewStudent(student);
                    }

                } else {
                    student = new Student();

                    student.setFullName(studentName);
                    student.setProgram(studentProgram);
                    student.insertCourse(courseCode, sectionNumber);
                    student.setCurrentCreditHours(student.getCurrentCreditHours() + section.getCreditHours());

                    System.out.print("Age: ");
                    student.setAge(Registration.input.nextInt());
                    System.out.print("Gender M / F: ");
                    student.setIsMale(Registration.input.next().toUpperCase().equals("M"));

                    System.out.println("\n---- Add new Student in  " + student.getCourse(courseCode) + "- with id "
                            + student.getId() + " ----\n");
                    section.addNewStudent(student);
                }
            } else {
                System.out.println("---- Section not found, Please add new Section ----");

            }

        }
    }

    /**
     * on this method we will take section and student as arrgement, first of all,
     * will check if section is exist or not, if exist will pass student to
     * addNewStudent() with one arrgemnet, else will diplay error message
     */
    public static void addNewStudent(Section section, Student student) {
        Section searchForSec = Section.searchForSection(section.getCourseCode(), section.getSectionNumber(),
                Registration.sections);

        if (searchForSec != null) {
            section.addNewStudent(student);
        } else {
            System.out.println("---- Section not found, Please add new Section ----");

        }
    }

    /**
     * on this method we will take section and student as arrgement, first of all,
     * will check if section is exist or not, if exist will pass student to
     * removeStudent() with one arrgemnet, else will diplay error message
     */
    public static void removeStudent(Section section, Student student) {
        Section searchForSec = Section.searchForSection(section.getCourseCode(), section.getSectionNumber(),
                Registration.sections);
        if (searchForSec != null) {
            section.removeStudent(student);
        } else {
            System.out.println("---- Section not found, Please add new Section ----");

        }
    }

    /**
     * this method will do the next: check if sections is empty or not, if empty
     * will display error message, if sections not empty will ask about courseCode
     * and sectionNumber then will call searchForSeciton(), if return was null the
     * program will print error message, else will ask about studentName and
     * studentProgram then call searchForStudent(), if return was null display error
     * message, else removed student.
     * 
     */
    public static void removeStudent(Set<Section> sections) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than remove Student ----\n");
        } else {
            System.out.println("\n**************************");
            System.out.println("Student Information: ");
            System.out.println("**************************\n");

            System.out.print("Enter Student Name: ");
            String studentName = Registration.input.nextLine().trim();
            studentName = Registration.input.nextLine().trim();

            System.out.print("Enter Student Program: ");
            String studentProgram = Registration.input.nextLine().trim();
            Student student = Student.searchForStudent(studentName, studentProgram, sections);

            if (student != null) {
                System.out.println("\n**************************");
                System.out.println("Section Information: ");
                System.out.println("**************************\n");

                System.out.print("Enter Cousre Code: ");
                String courseCode = Registration.input.nextLine();

                System.out.print("Enter Section Number: ");
                String sectionNumber = Registration.input.nextLine();

                Section section = Section.searchForSection(courseCode, sectionNumber, sections);
                if (section != null) {
                    System.out.println("\n---- Student with id  " + student.getId() + " is Removed ----\n");
                    section.removeStudent(student);
                } else {
                    System.out.println("---- Section not found, Please add new Section ----");

                }
            } else {
                System.out.println("\n---- The Student not found ----\n");
            }

        }
    }

    /**
     * will take name, program and section as arrgements, then we will looking for
     * student in saide all sections, if student exits we will return student, else
     * method return null
     */
    public static Student searchForStudent(String name, String program, Set<Section> sections) {
        for (Section lookingForStudent : sections) {
            if (lookingForStudent.getStudent(name, program) != null)
                return lookingForStudent.getStudent(name, program);
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Program: " + this.getProgram() + "Sechdule: \n" + this.printSchedule()
                + "\tTotal Completed Hours: " + this.getTotalCreditComplete() + "Current Credit Hours: "
                + this.getCurrentCreditHours() + '\t' + "Remaining Credit Hours: " + this.getRemainingCreditHours()
                + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            return this.getFullName().equals(student.getFullName()) && this.getProgram().equals(student.getProgram());
        }
        return false;
    }
}
