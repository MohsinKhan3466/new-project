package JavaPrograms;

public class StarPatter {
    public static void main(String[] args) {


    /* To print Pattern:

     *
     **
     ***
     ****
     *****
     */
        for (int i=0;i<=4;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------");

        /* To print Pattern:
         *****
         ****
         ***
         **
         *

         */
        for (int i=0;i<=4;i++){
            for (int j=4;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------");

        /* To Print Pattern:

         *
         **
         ***
         ****
         *****
         ****
         ***
         **
         *

         */

        for (int i=0;i<=4;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=0;i<=4;i++){
            for (int j=4;j>i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
