package JavaPrograms.JavaInterview;

public class ReverseString {

    public static void main(String[] args) {

        //Q and Ans:
        //1. Difference betw String And StringBuffer: String is immutable and StringBuffer is Mutable:
        //2. Do we have reverse() function in String:  No we dont have reverse() function in String:

        String s="Selenium";

        //1.Using for loop:
        int len=s.length();
        String rev="";

        for (int i=len;i>=0;i--){
            rev= rev+s.charAt(i);
        }
        System.out.println(rev);

        //2.Using StringBuffer

        StringBuffer sf=new StringBuffer(s);
        System.out.println(sf.reverse());
    }
}
