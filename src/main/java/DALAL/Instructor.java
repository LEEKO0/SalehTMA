
package DALAL;

public class Instructor extends Course {
    
    private int id;
    private String name;
    private String gender;

    
    Instructor(){
        this(0,null,null);
    }
    
    Instructor(int id,String name,String gender){
       super(null,null);
       this.id = id;
       this.name = name;
       this.gender = gender;    
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Instructor){
            Instructor inst = (Instructor)o;
            if(super.equals(inst)&& inst.gender .equals(this.gender) && inst.id == this.id && inst.name.equals(this.name))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return super.toString()+ " " + getId() + " " + getName()+ " " + getGender();
    }
}
