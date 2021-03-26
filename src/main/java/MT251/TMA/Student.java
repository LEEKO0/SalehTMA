package MT251.TMA;

import java.util.*;

public class Student extends CollegePerson implements Comparable<Student> {

    private Map<String, String> schedule = new HashMap<>();
    private int currentCreditHours;
    private int remainingCreditHours;
    private String program;

    public Student() {
        this(null, null, false);
    }

    public Student(String fullName, Date birthday, boolean isMale) {
        super(fullName, birthday, isMale);
        super.setId("S" + super.gen());

    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getRemainingCreditHours() {
        return remainingCreditHours;
    }

    public void setRemainingCreditHours(int remainingCreditHours) {
        this.remainingCreditHours = remainingCreditHours;
    }

    public int getCurrentCreditHours() {
        return currentCreditHours;
    }

    public void setCurrentCreditHours(int currentCreditHours) {
        this.currentCreditHours = currentCreditHours;
    }

    public String getSchedule() {
        String schedule = "";
        for (String key : this.schedule.keySet()) {
            schedule += key + " ------- " + this.schedule.get(key) + "\n";
        }
        return schedule.toString();
    }

    public String getCourse(String course) {
        if (this.schedule.containsKey(course))
            return this.schedule.get(course);
        return null;
    }
    // public void setSchedule(String courseCode, int creditHours, String period) {
    // this.schedule.setCourseCode(courseCode);
    // this.schedule.setCreditHours(creditHours);
    // this.schedule.setPeriod(period);
    // }

    public void insertCourse(String coureCode, String sectionNumber) {
        this.schedule.put(coureCode, sectionNumber);
    }

    @Override
    public int compareTo(Student o) {
        return this.getId() == (o.getId()) ? 0 : 1;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Sechdule: \n" + this.getSchedule() + '\n' + "Current Credit Hours: "
                + this.getCurrentCreditHours() + '\n' + "Remaining Credit Hours: " + this.getRemainingCreditHours()
                + '\n' + "Program: " + this.getProgram();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student)
            if (super.equals(o)) {
                Student student = (Student) o;
                return this.getSchedule().equals(student.getSchedule())
                        && this.getCurrentCreditHours() == student.getCurrentCreditHours()
                        && this.getRemainingCreditHours() == student.getRemainingCreditHours()
                        && this.getProgram().equals(student.getProgram());
            }
        return false;
    }

    public static void addNewStudent(Set<Section> sections) {
        String sectionNumber = null;
        String courseCode = null;
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");
            Registration.continueOrNot(sections);
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

            System.out.println("\n**************************");
            System.out.println("Student Information: ");
            System.out.println("**************************\n");

            if (section != null) {
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
            }
            Registration.continueOrNot(sections);

        }
    }

    public static void removeStudent(Set<Section> sections) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than remove Student ----\n");
            Registration.continueOrNot(sections);
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
                    Registration.continueOrNot(sections);
                }
            } else {
                System.out.println("\n---- The Student not found ----\n");
                Registration.continueOrNot(sections);
            }

        }
    }

    public static Student searchForStudent(String name, String program, Set<Section> sections) {
        for (Section lookingForStudent : sections) {
            if (lookingForStudent.getStudent(name, program) != null)
                return lookingForStudent.getStudent(name, program);
        }
        return null;
    }

}
