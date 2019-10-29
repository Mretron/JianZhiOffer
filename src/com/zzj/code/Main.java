package com.zzj.code;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    private int a = 0;
    private int b = 2;

    public Main(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public static void main(String[] args) {



        Integer a = new Integer(50);
        Main main = new Main(2,3);
        Main main1 = new Main(2, 3);

        System.out.println(main.equals(main1));
    }
}
