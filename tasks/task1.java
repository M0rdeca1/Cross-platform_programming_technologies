package com.company;

public class task1 {
    public static int convert(int i){
        return(i*60);
    }
    public static int points(int x, int y){
        return(x*2+y*3);
    }
    public static int footballPoints(int x, int y, int z){
        return(x*3+y);
    }
    public  static boolean divisibleByFive(int i){
        return(i%5==0);
    }
    public static boolean and(boolean a, boolean b){
        return(a&&b);
    }
    public  static int howManyWalls(int n, int w, int h){
        return(n/(w*h));
    }
    public static int squared(int a) {
        return a * a;
    }
    public static boolean profitableGamble(double prob, int prize, int pay){
        return prob*prize>pay;
    }
    public static int frames(int x, int y){
        return x*y*60;
    }
    public static int mod(int dividend, int divisor) {
        return (dividend - divisor * (dividend / divisor));
    }
    public static void main(String[] args) {
        System.out.println("convert(5) ➞ "+convert(5));
        System.out.println("points(13, 12) ➞ "+points(13, 12));
        System.out.println("footballPoints(3, 4, 2) ➞ "+footballPoints(3, 4, 2));
        System.out.println("divisibleByFive(5) ➞ "+divisibleByFive(5));
        System.out.println("and(true, false) ➞ "+and(true, false));
        System.out.println("howManyWalls(54, 1, 43) ➞ "+howManyWalls(54, 1, 43));
        System.out.println("squared(5) ➞ "+squared(5));
        System.out.println("profitableGamble(0.2, 50, 9) ➞ "+profitableGamble(0.2, 50, 9));
        System.out.println("frames(1, 1) ➞ "+frames(1, 1) );
        System.out.println("mod(5, 2) ➞ "+mod(5, 2)  );
    }
}
