package sample.model;

import java.util.ArrayList;
import java.util.Arrays;

public class TestWork {

    public static void main(String[] args){
        ArrayList<Integer> i1= new ArrayList<>(Arrays.asList(3,7,9));
        ArrayList<Integer> i2= new ArrayList<>(Arrays.asList(0,3,5,7));
        ArrayList<Integer> i3= new ArrayList<>(Arrays.asList(2));

        Menge m1 = new Menge('A',i1);
     //   Menge m2 = new Menge('B',i3);
        Menge m3 = new Menge('C',i2);
        Operation o = new Operation();
        o.mengeErstellen(m1);
   //      o.mengeErstellen(m2);
        o.mengeErstellen(m3);
        System.out.println(o.mengen);
      //  System.out.println(o.getSizeOfArrayList());
        System.out.println(o.differenzFürZwei('C', 'A'));
        System.out.println(o.differenzFürZwei('A', 'C'));
        System.out.println(o.mengen);
        System.out.println(o.delta('A','C'));
        System.out.println(o.mengen);
    }
}
