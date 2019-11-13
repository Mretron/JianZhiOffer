package com.zzj.code;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {



    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> times = new HashMap<>();
        boolean flag = true;
        for(int i = 0 ; i<arr.length; i++) {
            if(map.get(arr[i]) != null) {
                map.put(arr[i], map.get(arr[i]) + 1);
                break;
            } else {
                map.put(arr[i], 0);
            }
        }
        for(Map.Entry temp : map.entrySet()) {
            if(times.get((Integer)temp.getValue()) != null) {
                flag = false;
                break;
            }
            times.put((Integer)temp.getValue(), 0);
        }
        return flag;
    }
}
