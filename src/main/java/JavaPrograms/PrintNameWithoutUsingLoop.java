package JavaPrograms;

import java.util.Scanner;

public class PrintNameWithoutUsingLoop {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String name= sc.nextLine();

        printName(1,500,name);

    }

    public static  void printName(int stnum,int endNUm,String name){

        if (stnum<=endNUm){
            System.out.println(name);
            stnum++;
            printName(stnum,endNUm,name);
        }
    }
}
