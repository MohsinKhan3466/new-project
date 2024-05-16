package JavaPrograms;

public class NotANumber_NAN {
    // NAN means Not A Number

    public static void main(String[] args) {

        System.out.println(2/0);/*   Exception in thread "main" java.lang.ArithmeticException: / by zero
	                                 at JavaPrograms.NotANumber_NAN.main(NotANumber_NAN.java:8)
                                 */

        System.out.println(2.0/0.0);

        System.out.println(0.0/0.0);
        System.out.println(Math.sqrt(-1));

        System.out.println(Float.NaN==Float.NaN); /// false
        System.out.println(Float.NaN!=Float.NaN); /// true
    }
}
