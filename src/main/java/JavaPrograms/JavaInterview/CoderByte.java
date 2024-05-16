package JavaPrograms.JavaInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoderByte {
        public static boolean QuestionsMarks(String strParam) {
            int len0 = strParam.length();
            int sum = 0;
            int sum1 = 0;
            List<Character> list1 = new ArrayList<Character>();
            int i;
            int index = 0;
            for (i = 0; i < len0; i++) {
                char s = strParam.charAt(i);
                if (Character.isDigit(s)) {
                    index = i;
                    break;
                }
            }
            int index2 = 0;
            for (int j = i + 1; j < len0; j++) {
                char s = strParam.charAt(j);
                if (Character.isDigit(s)) {
                    index2 = j;
                    break;
                }
            }
            for (int k = index; k <= index2; k++) {
                char s = strParam.charAt(k);
                if (Character.isDigit(s)) {
                    sum1 = sum1 + Integer.parseInt(String.valueOf(s));
                }
            }
            System.out.println(sum1);
            int sums = 0;
            for (int m = index; m <= index2; m++) {
                char s = strParam.charAt(m);
                if (s == '?') {
                    sums = sums + 1;
                }
            }
            if (sum1 > 9 && sums == 3) {
                return true;
            } else {
                return false;
            }
        }

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            System.out.print(QuestionsMarks(s.nextLine()));
        }
    }
