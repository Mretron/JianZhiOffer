package com.zzj.code.chapter5.q7;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author etron
 * @date 2019/11/18 19:59
 */
public class Test {

    /**
     * 一个重要的公式,掌握即可
     * 数字a 和 数字b
     * ab < ba ： a在b的左边
     * ba < ab ： b在a的左边
     * ab = ba ： 随便
     * @param numbers
     * @return
     */
    public static String PrintMinNumber2(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        // 首先将数字全部转换成字符串
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        // 进行排序
        // 直接比较规则为：两者左右连起来，谁更小
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strNumbers.length; i++) {
            sb.append(strNumbers[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int arr[] = {3, 32 ,321};
        System.out.println(PrintMinNumber2(arr));
    }
}
