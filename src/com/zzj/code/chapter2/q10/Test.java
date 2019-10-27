package com.zzj.code.chapter2.q10;

public class Test {
    private void SortAge(int ages[], int length) {
        if(ages == null || length <= 0) {
            return;
        }

        int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for(int i=0; i<=oldestAge; i++) {
            timesOfAge[i] = 0;
        }

        for(int i = 0; i < length; i++) {
            int age = ages[i];
            if(age < 0 || age > oldestAge) {
                throw new RuntimeException("age out of range");
            }

            ++ timesOfAge[age];
        }

        int index = 0;
        for(int i = 0;i<=oldestAge; ++i) {
            for(int j=0; j<timesOfAge[i]; ++i) {
                ages[index] = i;
                ++index;
            }
        }
    }
}
