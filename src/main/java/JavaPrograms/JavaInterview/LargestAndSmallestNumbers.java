package JavaPrograms.JavaInterview;

import java.util.Arrays;

public class LargestAndSmallestNumbers {

    public static void main(String[] args) {

        int numbers[]={ 0, -10, 55, 20, -80, -90, 8474, -99, 9999};

        int smallest=numbers[0];
        int largest=numbers[0];

        for (int i=0;i<numbers.length;i++){
            if (numbers[i]>largest){
                largest=numbers[i];
            } else if (numbers[i]<smallest) {
                smallest=numbers[i];
            }
        }
        System.out.println("Array is::"+ Arrays.toString(numbers));
        System.out.println("Smallest Number is::"+smallest);
        System.out.println("Largest Number is::"+largest);

    }
}
