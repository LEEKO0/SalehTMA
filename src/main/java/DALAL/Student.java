package DALAL;

public class Student extends Instructor {
    
    private double coursePrice;
    private int sectionsNum;
      
    Student(){
      this(0.0);
    }
    
    Student(double coursePrice){
        super(0,null,null);
      this.coursePrice = coursePrice;
    }
    
    public void setCoursePrice(double coursePrice){
        this.coursePrice = coursePrice;
    }
    public double getCoursePrice(){
        return coursePrice;
    }
    
    public void setSectionsNum(int sectionsNum){
        this.sectionsNum = sectionsNum;
    }
    public int getSectionsNum(){
         return this.sectionsNum;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Student){
            Student student = (Student)o;
            if(super.equals(student)&& student.coursePrice == this.coursePrice)
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return  " " + super.toString() + " " + getCoursePrice() ;
    }
    
//    + " " + super.getCourseName()+ " " + getCoursePrice() + " " + getCourseDate()
//    + super.getcourseCode()
    
}
