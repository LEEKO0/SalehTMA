package MT251.TMA;

public class Instrctor extends CollegePerson {

    private String biography;
    private String academicDegree;

    public Instrctor() {
        this(null, false, 25, null, "Bachelor");
    }

    public Instrctor(String fullName, boolean isMale, int age, String biography, String academicDegree) {
        super(fullName, isMale, age);
        this.setBiography(biography);
        this.setAcademicDegree(academicDegree);
    }

    /**
     * this method return value of biography
     */
    public String getBiography() {
        return this.biography;
    }

    /**
     * 
     * this method change value of biography
     */
    public void setBiography(String biography) {
        this.biography = biography;
    }

    /**
     * this method return value of academicDegree
     */
    public String getAcademicDegree() {
        return academicDegree;
    }

    /**
     * this method change value of academicDegree
     */
    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    @Override
    public String toString() {
        return super.toString() + "Academic Degree: " + this.getAcademicDegree() + "\nBiography: "
                + this.getBiography();

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Instrctor)
            if (super.equals(o)) {
                Instrctor instrctor = (Instrctor) o;
                return this.getBiography().equals(instrctor.getBiography());

            }
        return false;
    }

    /**
     * This method will add a new instructor in the specific section, after the
     * calling method we will take the section as an argument then, we create a new
     * Instructor obj and ask the user to enter the whole data for the Instructor,
     * finally we add and update the Instructor of section.
     * 
     * @param section
     */
    public static void addNewIntrecotr(Section section) {
        Instrctor instrctor = new Instrctor();

        System.out.println("\n**************************");
        System.out.println("Fill infromation for instrctor: ");
        System.out.println("**************************\n");

        System.out.print("Full Name: ");
        instrctor.setFullName(Registration.input.nextLine().trim());
        instrctor.setFullName(Registration.input.nextLine().trim());

        System.out.print("Gender M / F: ");
        instrctor.setIsMale(Registration.input.next().toUpperCase().equals("M"));

        System.out.print("Biography: ");
        String bString = Registration.input.nextLine().trim();
        bString = Registration.input.nextLine();
        instrctor.setBiography(bString);

        System.out.print("Academic Degree: ");
        String degree = Registration.input.nextLine().trim();
        instrctor.setAcademicDegree(degree);

        System.out.print("Age: ");
        instrctor.setAge(Registration.input.nextInt());
        System.out.println();
        section.setInstrctor(instrctor);
    }
}
