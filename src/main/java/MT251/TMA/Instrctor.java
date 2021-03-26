package MT251.TMA;

import java.util.*;

public class Instrctor extends CollegePerson {
    // private ArrayList<String> teaching = new ArrayList<>();
    // private ArrayList<String> experience = new ArrayList<>();
    private String biography;

    public Instrctor() {
        this(null, null, false, null, null, null);
    }

    public Instrctor(String fullName, Date birthday, boolean isMale, ArrayList<String> teaching,
            ArrayList<String> experience, String biograhpy) {
        super(fullName, birthday, isMale);
        super.setId("I" + super.gen());
    }

    // public String getTeaching() {
    // String teaching = "";
    // for (String s : this.teaching)
    // teaching += s + "\n";
    // return teaching;
    // }

    // public void addNewTeaching(String teaching) {
    // this.teaching.add(teaching);
    // }

    // public String getExperience() {
    // String experience = "";
    // for (String s : this.experience)
    // experience += s + "\n";
    // return experience;
    // }

    // public void addNewExperience(String experience) {
    // this.experience.add(experience);
    // }

    public String getBiography() {
        return this.biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return super.toString() + "Biography: " + this.getBiography();
        // + "\nTeaching: " + this.getTeaching()
        // + "\nExperience: " + this.getExperience();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Instrctor)
            if (super.equals(o)) {
                Instrctor instrctor = (Instrctor) o;
                return this.getBiography().equals(instrctor.getBiography());
                // && this.getExperience().equals(instrctor.getExperience())
                // && this.getTeaching().equals(instrctor.getTeaching());
            }
        return false;
    }

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

        System.out.print("Age: ");
        instrctor.setAge(Registration.input.nextInt());
        System.out.println();
        section.setInstrctor(instrctor);
    }
}
