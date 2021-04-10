package com.company;

import java.util.Arrays;

public class task2 {
    public static int oppositeHouse(int hNum, int sNum){
        if (hNum%2==1){
            return ((sNum-hNum/2)*2);
        }
        else{
            return((sNum*2-hNum)+1);
        }
    }
    public static String nameShuffle(String s){
        String[] words=s.split("\\s");
        return(words[1]+" "+words[0]);
    }
    public  static double discount(double prise, double d){
        return(prise-prise / 100*(d));
    }
    public static int differenceMaxMin(int[] arr){
        int max=-9999999;
        int min=9999999;
        for(int i=0;i<arr.length;i++){
            if (arr[i]> max)
                max=arr[i];
            if (arr[i]<min)
                min=arr[i];
        }
        return(max-min);
    }
    public static int equal(int a,int b,int c){
        if (a==b && a==c)
            return 3;
        else if (a == b || b==c || c==a)
            return 2;
        else
            return 0;
    }
    public static String reverse(String s){
        String buf = "";
        for(int i=(s.length()-1); i>=0;i--){
            char c=s.charAt(i);
            buf = buf + c;
        }
        return buf;
    }
    public static int programmers(int a,int b,int c){
            int[] nums = {a,b,c};
            Arrays.sort(nums);
            return nums[2] - nums[0];
    }
    public static boolean getXO(String word) {
        word = word.toLowerCase();
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == 'x')
                countX ++;
            if (word.charAt(i) == 'o')
                countO++;
        }
        return countX  == countO;
    }
    public static String bomb(String s){
        s = s.toLowerCase();
        if (s.contains("bomb"))
            return("DUCK!");
        else
            return("Relax, there's no bomb.");
    }
    public static boolean sameAscii(String s1, String s2) {
        int str1_ascii = 0;
        int str2_ascii = 0;
        for (int i = 0; i < s1.length(); i++)
            str1_ascii += (int)s1.charAt(i);
        for (int i = 0; i < s2.length(); i++)
            str2_ascii += (int)s2.charAt(i);
        return str1_ascii == str2_ascii;
    }
    public static void main(String[] args) {
        System.out.println("oppositeHouse(5, 46) ➞ "+oppositeHouse(5, 46) );
        System.out.println("nameShuffle(\"Donald Trump\") ➞ "+nameShuffle("Donald Trump"));
        System.out.println("discount(89, 20) ➞ "+discount(89,20) );
        int[] arr={10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println("differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) ➞ "+differenceMaxMin(arr));
        System.out.println("equal(3, 4, 3) ➞ "+equal(3, 4, 3) );
        System.out.println("reverse(\"The quick brown fox.\") ➞ "+reverse("The quick brown fox."));
        System.out.println("programmers(147, 33, 526) ➞ "+programmers(147, 33, 526) );
        System.out.println("getXO(\"ooxx\") ➞ "+getXO("ooxx"));
        System.out.println("bomb(\"Hey, did you think there is a BOMB?\") ➞ "+bomb("Hey, did you think there is a BOMB?"));
        System.out.println("sameAscii(\"EdAbIt\", \"EDABIT\") ➞ "+sameAscii("EdAbIt", "EDABIT"));

    }
}
