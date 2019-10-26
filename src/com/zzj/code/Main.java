package com.zzj.code;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map a = new HashMap();
        WeakReference<Map> weakReference = new WeakReference<>(a);
        // a 虽然被指向了null,但是如果没有触发gc垃圾回收机制，weakReference依然可以指向a的值，因为a还没有被垃圾回收
       /* a = null;
        System.gc();
        System.out.println(weakReference.get());*/
        System.gc();
        Map b = weakReference.get();
        System.out.println(a);
        System.out.println(b);
    }
}
