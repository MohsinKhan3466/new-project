package JavaPrograms;

public class Nofrom1to100withoutUsingLoops {

    /* Without Using Loop
    1.Using Recursive function
    2. Java Stream
     */


    public static void main(String[] args) {
        printNum(1);
        System.out.println("\n-------------");
        ptNum(1,100);
    }
    public static void printNum(int num){

        if (num<=100) {
            System.out.println(num);
            num++;
            printNum(num);
        }
    }


    public static void ptNum(int stNum,int endNum){

        if (stNum<=endNum){
            System.out.println(stNum);
            stNum++;
            ptNum(stNum,endNum);
        }
    }
}
