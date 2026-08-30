import java.util.*;
public class Employee{
    int id;
    String name;
    double salary;
    public Employee(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
}
    class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        List<Employee> e=new ArrayList<Employee>();
        e.add(new Employee(101,"John",50000.0));
        e.add(new Employee(102,"Alice",60000.9));
        for(Employee emp:e){
            if(emp.salary>x){
                System.out.println(emp.name+" "+emp.salary);
            }
        }
    }

}
