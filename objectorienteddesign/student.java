import java.util.*;
public class student {
    String id;
    String name;
    public student(String id ,String name){
        this.id=id;
        this.name=name;
    }  
    /* @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof student))
            return false;

        student other = (student) obj;

        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}
class Mains{
    public static void main(String args[]){
       /* HashSet<student> hs=new HashSet<>();
        hs.add(new student("1","john"));
        hs.add(new student("2","jeasus"));
        hs.add(new student("3","james"));
        hs.add(new student("1","john"));
        System.out.println(hs.size());*/

        HashMap<String,student> hm=new HashMap<>();
        hm.put("1",new student("1","john"));
        hm.put("2",new student("2","jeasus"));
        hm.put("3",new student("3","james"));  
        hm.put("1",new student("1","george"));
        System.out.println(hm.size()); 


    }
}
