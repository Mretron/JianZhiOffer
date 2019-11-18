package com.zzj.code;

public class Test3 {


    public static Test3 t1 = new Test3();

    public static Test3 t2 = new Test3();

    {
        System.out.println("构造块");
    }

    static
    {
        System.out.println("静态块");
    }

    public static void main(String[] args)
    {
        System.out.println(t1);
    }
}
