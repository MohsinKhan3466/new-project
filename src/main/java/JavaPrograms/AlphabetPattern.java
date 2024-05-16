package JavaPrograms;

public class AlphabetPattern {

    /* To Print Pattern:
A
A B
A B C
A B C D
A B C D E
A B C D E F
     */
    public static void main(String[] args) {

        int alpha=65;

        for (int i=0;i<=5;i++){
            for (int j=0;j<=i;j++){
                System.out.print((char)(alpha+j)+" "); // 65+0=65==> ASCII value of 'A'
            }
            System.out.println( );
        }
    }
}
