package JavaPrograms.JavaInterview;

public class RemoveJunkString {

    public static void main(String[] args) {
        String s="莫辛·汗·纳西姆·汗 and some English with 0123456789";

        String s1= s.replaceAll("[^a-zA-z0-9]","");
        System.out.println(s1);
    }
}
