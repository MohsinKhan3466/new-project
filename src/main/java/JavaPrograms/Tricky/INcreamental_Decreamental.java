package JavaPrograms.Tricky;

public class INcreamental_Decreamental {

    public static void main(String[] args) {

        int a=11;
        int b=22;
        int c;
        c=a+b + a++ + b++ + ++a + ++b;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
