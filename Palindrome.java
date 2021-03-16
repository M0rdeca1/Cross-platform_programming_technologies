import java.util.Scanner;
public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] words = s.split("\\s");
        boolean check;
        for (String word : words) {
            check = isPalindrome(word);
            System.out.println(check);
        }
        }
    public static String reverseString(String s){
        //Возвращает строку в обратном порядке
        String buf = "";
        for(int i=(s.length()-1); i>=0;i--){
            char c=s.charAt(i);
            buf = buf + c;
        }
        return buf;
    }
    public static boolean isPalindrome(String s){
        //Возвращает true, если строка является полиндромом, false в другом случае
        String m=reverseString(s).toLowerCase();
        String n =s.toLowerCase();
        return n.equals(m);
        }
    }

