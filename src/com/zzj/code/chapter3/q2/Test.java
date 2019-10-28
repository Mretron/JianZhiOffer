package com.zzj.code.chapter3.q2;

public class Test {

    /**
     * 初看之下好像没有问题，但是当输入的n很大的时候，我们求最大的n位数就会溢出
     * 也就是说我们要考虑大数问题
     * @param n
     */
    private static void Print1ToMaxOfNDigits_1(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }

        for(i = 1; i< number; ++i) {
            System.out.print(i + "\t");
        }
    }


    private static void Print1ToMaxOfDigits(int n) {
        if(n <= 0) {
            return;
        }

        char[] number = new char[n];
        for(int i=0; i < n ; i++) {
            number[i] = '0';
        }

        while(!Increment(number)) {
            // 当还能递增就打印
            PrintNumber(number);
        }

        number = null;
    }
    private static boolean Increment(char[] number) {
        // 是否越界
        boolean isOverflow = false;

        int nTakeOver = 0;

        int nLength = number.length;

        for(int i = nLength - 1; i >= 0; i--) {
            // 得到最后的一位需要递增.先判断是否需要加上之前进位的值
            int nSum = number[i] - '0' + nTakeOver;

            // 如果是最后一位
            if(i == nLength - 1) {
                // 直接递增
                nSum ++;
            }

            // 如果递增到大于等于10
            if(nSum >= 10) {
                if(i == 0) {
                    // 说明已经到极限了
                    isOverflow = true;
                } else {

                    nSum -= 10;
                    // 记录应该进一位
                    nTakeOver = 1;
                    // 保存最后的值
                    number[i] = (char)('0' +nSum);
                }
            } else {
                // 没有需要进位，直接递增
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印这个数
     * @param number
     */
    private static void PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        for(int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i] != '0' ) {
                isBeginning0 = false;
            }

            if(!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.print("\t");
    }


    /**
     * 上面的代码虽然比较直观，但是由于模拟了整数的加法
     * 接下来我们尝试全排列
     * @param n
     */
    private static void Print1ToMaxOfDigits1(int n) {
        if(n <= 0) {
            return;
        }

        char[] number = new char[n];

        for(int i = 0; i < 10 ; ++i) {
            number[i] = (char)(i + '0');
            Print1ToMaxOfNDigitsRecursively(number, n , 0);
        }
        number = null;
    }

    private static void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {

        if(index == length - 1) {
            PrintNumber(number);
            return;
        }

        for(int i = 0;i < 10 ; ++i) {
            number[index + 1] =(char)(i + '0');
            Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits_1(3);
    }
}
