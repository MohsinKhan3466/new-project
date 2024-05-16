package JavaPrograms.JavaInterview;

import java.util.ArrayList;
import java.util.List;

public class FizzBUZZ {
        public static List<String> fizzbuzz(int n) {
            List<String> result = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                String add = "";

                if (i % 3 == 0) {
                    add += "Fizz";
                }

                if (i % 5 == 0) {
                    add += "Buzz";
                }

                if (add.equals("")) {
                    result.add(Integer.toString(i));
                } else {
                    result.add(add);
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int n = 5;
            List<String> output = fizzbuzz(n);
            for (String s : output) {
                System.out.println(s);
            }
        }
    }


