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

    /**
     * on displayCourses will diplay all current courses on this semeter, we will
     * check the size of collection if equal zero diplay faild message, else will
     * search and grap all courses and put them as key for Tree map, and grap
     * sections of courses then sort them, at the end will print all courses with
     * them sections ascending order
     */
    public static void displayCourses(Set<Section> sections) {
        if (sections.size() == 0) {
            System.out.println("\n---- The no any section yet, Please add new Section than add Student ----\n");
            Registration.continueOrNot(sections);
        } else {

            System.out.println("\n---- Course Code with Sections Numbers ----\n");
            Map<String, String> course = new TreeMap<String, String>();
            ArrayList<String> _sections;

            for (Section courseCode : sections) {
                _sections = new ArrayList<>();
                for (Section sectionNumber : sections) {
                    if (courseCode.getCourseCode().equals(sectionNumber.getCourseCode()))
                        _sections.add(sectionNumber.getSectionNumber());
                }
                if (!course.containsKey(courseCode.getCourseCode())) {
                    Collections.sort(_sections);
                    String allSections = "";
                    for (String sectionNumber : _sections) {
                        allSections += " " + sectionNumber;
                    }
                    course.put(courseCode.getCourseCode(), allSections);
                }
            }

            for (String s : course.keySet())
                System.out.println(s + ":" + course.get(s));
        }
    }

    @Override
    public String toString() {
        return "Coure Code: " + this.getCourseCode() + "\t\t" + "Credit Hours: " + this.getCreditHours();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Course)
            return this.getCourseCode().equals(((Course) o).getCourseCode())
                    && this.getCreditHours() == ((Course) o).getCreditHours();
        return false;

    }
}
