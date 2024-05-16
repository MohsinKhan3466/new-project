package JavaPrograms;

public class Numberfrom1to100 {

    /*
    * Output numbers from 1 to 100
    *  Without using any numbers in code
     */


    public static void main(String[] args) {

        //Simply using String length

        int one= 'A'/'A';   /// it means 1
        String s1="..........";

        for (int i= one; i<=(s1.length()*s1.length());i++){
            System.out.println(i);
        }


        //By using Ascii code: a: 97; b: 98; c: 99; d: 100

        for (int i=one;i<='d';i++){
            System.out.println(i);
        }
    }
}
