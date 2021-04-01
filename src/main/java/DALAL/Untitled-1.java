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