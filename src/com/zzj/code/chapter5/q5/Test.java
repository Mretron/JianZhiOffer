package com.zzj.code.chapter5.q5;

/**
 * @author etron
 * @date 2019/11/18 18:47
 */
public class Test {

    private static int numberOf1Between1AndN(int n, int x) {
        if(n < 0 || x < 1 || x > 9) {
            return 0;
        }
        // i : 代表第几位
        // high : 代表高位，也就是多少个i00**
        // temp: 代表这个末尾数
        int curr, low , temp, high = n, i = 1, total = 0;
        while(high != 0) {
            // 高位可以有多少个i00**
            high = n / (int)Math.pow(10, i);

            // 得到低位所有值
            temp = n % (int)Math.pow(10, i);

            // 获取第i位
            curr = temp / (int)Math.pow(10, i - 1);
            // 获取第i位的低位
            low = temp%(int)Math.pow(10, i - 1);

            if(curr == x) {
                // 等于x
                // total 就加上 高位high*真实值 加上低位  再加上一
                total += high*(int)Math.pow(10, i-1) + low + 1;
            } else if(curr < x) {
                // 小于x
                total += high*(int)Math.pow(10, i-1);
            } else {
                // 大于x
                // 就加上高位
                total += (high + 1) * (int) Math.pow(10, i-1);
            }
            i++;
        }
        return total;
    }

    public static void main(String[] args) {
        int nums = numberOf1Between1AndN(21354, 1);
        System.out.println(nums);
    }
}
