package ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        String [] str = {"aaa", "ccc", "bbb"};
        doTask1(str,1,2);
        System.out.println();
        System.out.println(doToArrayList1(str));

        new Box<Apple>().getWeight();
        new Box<Orange>().getWeight();
    }

    public static void doTask1 (String [] s, int i1, int i2){
        String s1 = s[i1];
        s[i1] = s[i2];
        s[i2] = s1;
        for (int i = 0; i<s.length; i++){
            System.out.printf("%s ", s[i]);
        }
    }

    public static boolean doToArrayList(String [] s){
        ArrayList<String> arrayList = new ArrayList<String>();
        return Collections.addAll(arrayList, s);
    }

    public static ArrayList<String> doToArrayList1(String [] s){
        ArrayList<String > arrayList = new ArrayList<String >(Arrays.asList(s));
        return arrayList;
    }
}
