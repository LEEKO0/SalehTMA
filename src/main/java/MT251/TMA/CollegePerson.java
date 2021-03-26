package MT251.TMA;

import java.util.*;

/**
 * this abstract class is for everyone in
 */
public abstract class CollegePerson extends Object {
    private String id;
    private String fullName;
    private Date birthday;
    private int age;
    private boolean isMale;

    public CollegePerson() {
        this(null, null, false);
    }

    public CollegePerson(String fullName, Date birthday, boolean isMale) {

    }

    /**
     * 
     * writing getter and setter for all properties
     */
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // public Date getBirthday() {
    // return this.birthday;
    // }

    // public void setBirthday(Date birthday) {
    // this.birthday = birthday;
    // }

    public boolean getIsMale() {
        return this.isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    /**
     * calculate age
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // generat random numbers for id
    public static int gen() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() + "\t\t" + "Full Name: " + this.getFullName() + "\t" + "Age: " + this.getAge()
                + "\t\t" + "Gender: " + (this.getIsMale() ? "Male" : "Female") + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CollegePerson) {
            CollegePerson collegePerson = (CollegePerson) o;
            return this.getId() == collegePerson.getId() && this.getFullName().equals(collegePerson.getFullName())
                    && this.getIsMale() == collegePerson.getIsMale();
        }
        return false;
    }
}
