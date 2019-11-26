package com.zzj.code.chapter5.q10;

/**
 * @author etron
 * @date 2019/11/26 13:25
 */
public class Test {

    private static int longestSubstringWithoutDuplication(char[] str) {
        int curLength = 0;
        int maxLength = 0;

        // 创建一个长度为26的数组存储每个字符上次出现在字符串中位置的下标
        int[] position = new int[26];

        // 该数组所有元素的值都初始化为-1
        for(int i = 0; i< 26; ++i) {
            position[i] = -1;
        }

        for(int i = 0; i< str.length; ++i) {
            // 得到之前的出现的下标位置
            int prevIndex = position[str[i] - 'a'];
            if(prevIndex < 0 || i - prevIndex > curLength) {
                // prevIndex<0 说明没有出现过
                // i - prevIndex > curLength 说明距离比现在的最长还要长
                // 所以当前最长加一
                ++curLength;
            } else {
                // 说明出现过 或者 距离比现在的最长更短
                if(curLength > maxLength) {
                    maxLength = curLength;
                }

                curLength = i - prevIndex;
            }
            // 把这个位置记录在案
            position[str[i] - 'a'] = i;
        }
        if(curLength > maxLength) {
            maxLength = curLength;
        }

        position = null;
        return maxLength;
    }
}
