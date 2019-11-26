package com.zzj.code.chapter5.q8;

/**
 * @author etron
 * @date 2019/11/26 10:16
 */
public class Test {

    private static int GetTranslationCount(int number) {
        if(number < 0) {
            return 0;
        }
        // 首先将数字转换成字符串
        String numberInString = number + "";
        // 调方法，传入字符串的数组
        return GetTranslationCount(numberInString.toCharArray());
    }

    private static int GetTranslationCount(char[] number) {

        int length = number.length;
        int[] counts = new int[length];
        int count = 0;

        // 从尾部开始遍历
        for(int i = length - 1; i >= 0; --i) {
            count = 0;
            if(i < length - 1) {
                count = counts[i+1];
            } else {
                count = 1;
            }

            if(i < length - 1) {
                // 如果i不是最后一位
                // 计算与之后一位是否满足 >= 10 && <=25
                int digit1 = number[i] - '0';
                int digit2 = number[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                // 如果小于10，那就构不成两位数
                // 如 08 不符合规则--
                if(converted >= 10 && converted <= 25) {
                    if(i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        count = counts[0];
        counts = null;

        return count;
    }
}
