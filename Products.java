import java.util.*;
public class Products {
    String pname;
    int price;
    double rating;
    public Products(String pname,int price,double rating){
        this.pname=pname;
        this.price=price;
        this.rating=rating;
    }    
}
class Main1{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        List<Products> l=new ArrayList<>();
        l.add(new Products("TV",17000,2));
        l.add(new Products("watch",50000,3));
        l.add(new Products("Fridge",25000,2.5));
                l.add(new Products("Fridge",15000,2.5));
        l.sort((p1,p2)-> {
            int res=Double.compare(p2.rating, p1.rating);
            if(res==0)
            {
                return Integer.compare(p1.price,p2.price);
            }
            return res;
    });
        for(Products p:l)
        {
            System.out.println(p.pname+" "+p.price+" "+p.rating);
        }
    
    }
}
