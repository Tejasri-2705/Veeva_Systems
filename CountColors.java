/*1)count colours from a comma seperated input string ignore spaces before and after colour names handle mixed casing uniformly in input if there are numerical values or symbols ignore them 
    test cases:-  example 1:-  input---red,blue,green,yellow,red,green red
     output:- red-3,blue-1,green-2,yellow-1
          ex-2)  red ,blue , green , yellow
     ex-3) Red,blue,red,yellow
  ex-4) red,blue,123red,#red,green1,
ex-5)  " "   ==o/p:-0*/
import java.util.*;
public class CountColors{
    public static void main(String args[])
    {
        String s="R12ed, Gre53en , Blue, Red, Yellow, Green, Red";
        s = s.toLowerCase();
        String a[]=s.split(",");
        HashMap<String,Integer> hm=new HashMap<>();
        for(String i:a)
        {
                i=i.trim();
                i=i.replaceAll("\\d","");
                hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(Map.Entry<String,Integer> e:hm.entrySet())
        {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
