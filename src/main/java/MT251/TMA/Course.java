package MT251.TMA;

import java.util.*;

public abstract class Course {
    private String courseCode;
    private int creditHours;

    public Course() {
        this(null, 0);
    }

    public Course(String courseCode, int creditHours) {
        this.setCourseCode(courseCode);
        this.setCreditHours(creditHours);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public static void displayingCoruse(Set<Section> sections) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");
            Registration.continueOrNot(sections);
        } else {
            System.out.println("\n---- Course Code with Sections Numbers ----\n");

            Set<String> course = new TreeSet<>();
            String courseWithSections = "";

            for (Section getCourse : sections) {
                courseWithSections = getCourse.getCourseCode() + ":{";
                for (Section getSections : sections) {
                    if (getCourse.getCourseCode().equals(getSections.getCourseCode()))
                        courseWithSections += getSections.getSectionNumber() + ",";
                }
                course.add(courseWithSections += "}");
            }

            for (String s : course)
                System.out.println(s);
            Registration.continueOrNot(sections);
        }
    }

    @Override
    public String toString() {
        return "Coure Code: " + this.getCourseCode() + "\t" + "Credit Hours: " + this.getCreditHours();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Course)
            return this.getCourseCode().equals(((Course) o).getCourseCode())
                    && this.getCreditHours() == ((Course) o).getCreditHours();
        return false;

    }
}
