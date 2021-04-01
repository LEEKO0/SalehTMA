package DALAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import MT251.TMA.Section;

public class Course {

    private String courseCode;
    private String courseName;
    private Date courseDate;

    Course() {
        this(null, null);
    }

    Course(String courseCode, String courseName) {

        this.courseCode = courseCode;
        this.courseName = courseName;
        courseDate = new Date();
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getcourseCode() {
        return this.courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public static void display(Set<Sections> sections) {
        ArrayList<String> courses = new ArrayList<>();
        ArrayList<Integer> sectionsNumber = null;
        Set<String> allCourses = new TreeSet<>();

        for (Sections course : sections) {
            if (!courses.contains(course.getcourseCode())) {
                sectionsNumber = new ArrayList<>();
                for (Sections secNo : sections) {
                    if (course.getcourseCode().equals(secNo.getcourseCode())
                            && !sectionsNumber.contains(secNo.getSectionsNum()))
                        sectionsNumber.add(secNo.getSectionsNum());

                }
                Collections.sort(sectionsNumber);
                String sectinString = "";
                for (Integer i : sectionsNumber) {
                    sectinString += " " + i;
                }
                allCourses.add(course.getcourseCode() + ":" + sectinString);

            }
        }
        for (String C : allCourses)
            System.out.println(C);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Course) {
            Course corse = (Course) o;
            if (corse.getcourseCode().equals(this.courseCode) && corse.getCourseName().equals(this.courseName)
                    && corse.courseDate == this.getCourseDate())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getcourseCode() + " " + getCourseName() + " " + getCourseDate();
    }

}
