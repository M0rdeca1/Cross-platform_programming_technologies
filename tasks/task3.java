package com.company;

public class task3 {
    public static Object[][] millionsRounding(Object[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            double rounded = Math.round((double) (int) arr[i][1] / 1000000) * 1000000;
            Integer roundedInt = Integer.valueOf((int) rounded);
            arr[i][1] = roundedInt;
        }
        return arr;
    }

    public static double[] otherSides(double x) {
        double x1 = x * 2;
        double x2 = Math.sqrt(Math.pow(x1, 2) - Math.pow(x, 2));
        double[] arr = {x1, x2};
        return (arr);
    }

    public static String rps(String plr1, String plr2) {
        if (plr1.equals(plr2))
            return "TIE";
        if (plr1.equals("rock") && plr2.equals("scissors")
                || plr1.equals("paper") && plr2.equals("rock")
                || plr1.equals("scissors") && plr2.equals("paper"))
            return "Player 1 wins";
        else
            return "Player 2 wins";
    }

    public static int warOfNumbers(int[] nums) {
        int even_sum = 0;
        int odd_sum = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                even_sum += num;
            else
                odd_sum += num;
        }
        return Math.abs(even_sum - odd_sum);
    }

    public static String reverseCase(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i]))
                charArray[i] = Character.toLowerCase(charArray[i]);
            else if (Character.isLowerCase(charArray[i]))
                charArray[i] = Character.toUpperCase(charArray[i]);
        }
        return new String(charArray);
    }

    public static String inatorInator(String s) {
        String ch = "aeiouy";
        int l = s.length();
        if (ch.contains(Character.toString(s.charAt(s.length() - 1))))
            return s + "-inator" + " " + l + "000";
        else
            return s + "inator" + " " + l + "000";
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a * b <= w * h) || (a * c <= w * h) || (b * c <= w * h);
    }

    public static double totalDistance(double fuel, double fuel_cons, int passengers, boolean fan) {
        fuel_cons *= (1 + 0.05 * passengers);
        if (fan)
            fuel_cons *= 1.1;
        return Math.round(fuel / fuel_cons * 10000.0) / 100.0;
    }
    public static double mean(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num: nums) {
            sum += num;
            count++;
        }
        return Math.round((double)sum/count*100.0)/100.0;
    }
    public static boolean parityAnalysis(int num) {
        int sum = 0;
        int num_ = num;
        while(num_>0){
            sum += num_%10;
            num_ /= 10;
        }
        return sum%2 == num%2;
    }

    public static void main(String[] args) {
        Object[][] testArr = {{"Nice", 942208}, {"Abu Dhabi", 1482816}, {"Naples", 2186853}, {"Vatican City", 572}};
        Object[][] res = millionsRounding(testArr);
        for (int i = 0; i < testArr.length; i++) {
            System.out.print((String) res[i][0] + " ");
            System.out.println((int) res[i][1]);
        }
        double[] arr2 = otherSides(2);
        System.out.print("otherSides(2) ➞  ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(" " + arr2[i]);
        }
        System.out.println();
        System.out.println("rps(\"rock\", \"paper\") ➞ " + rps("rock", "paper"));
        int[] arr3 = {12, 90, 75};
        System.out.println("warOfNumbers([12, 90, 75]) ➞" + warOfNumbers(arr3));
        System.out.println("reverseCase(\"Happy Birthday\") ➞" + reverseCase("Happy Birthday"));
        System.out.println("inatorInator(\"Shrink\") ➞" + inatorInator("Shrink"));
        System.out.println("doesBrickFit(1, 1, 1, 1, 1) ➞" + doesBrickFit(1, 1, 1, 1, 1));
        System.out.println("totalDistance(70.0, 7.0, 0, false) ➞" + totalDistance(70.0, 7.0, 0, false));
        int[] t9={1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
        System.out.println("mean([1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3]) ➞" + mean(t9) );
        System.out.println("parityAnalysis(3) ➞" + parityAnalysis(3)  );
    }
}
