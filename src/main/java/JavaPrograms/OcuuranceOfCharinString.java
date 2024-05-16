package JavaPrograms;

public class OcuuranceOfCharinString {

    public static void main(String[] args) {

        String str="hi son i am having sunshine in this selenium here";

        System.out.println(str.indexOf('s'));//1st occurrence

        System.out.println(str.indexOf('s',str.indexOf('s')+1));  //2nd occurrence

        System.out.println(str.lastIndexOf('s')); //3rd Or last occurrence

        System.out.println(str.indexOf("hello"));//  instead of null  it will return '-1' because it is not present in the string
    }
}
