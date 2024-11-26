package org.example.greedy.array;

public class MinNumberOfCoins {

    public static int minNumberOfCoins(int[] coinValues, int[] coinCounts, int amountToPay) {
        // 使用的金币总数
        int totalCoinsUsed = 0;
        for (int i = coinValues.length - 1; i >= 0 && amountToPay > 0; i--) {
            // 当前面值金币最多能用多少枚
            int maxCoins = Math.min(amountToPay / coinValues[i], coinCounts[i]);
            // 更新剩余金额
            amountToPay -= maxCoins * coinValues[i];
            // 更新金币总数
            totalCoinsUsed += maxCoins;
        }
        // 如果还有剩余金额，则表示没有足够的金币完成支付
        return amountToPay > 0 ? -1 : totalCoinsUsed;
    }

    public static void main(String[] args) {
        int[] coinValues = {1, 2, 5, 10, 20, 50, 100}; // 金币面值
        int[] coinCounts = {3, 0, 2, 1, 0, 3, 10}; // 各面值金币的数量
        int amountToPay = 624; // 要支付的金额

        int result = minNumberOfCoins(coinValues, coinCounts, amountToPay);
        if (result != -1) {
            System.out.println("最少需要 " + result + " 枚金币来支付 " + amountToPay + " 元");
        } else {
            System.out.println("没有足够的金币来支付 " + amountToPay + " 元");
        }
    }

}
