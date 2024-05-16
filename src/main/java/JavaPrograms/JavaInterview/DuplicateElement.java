package JavaPrograms.JavaInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateElement {
    public static void main(String[] args) {
        String names[]={"java","python","javascript","C","C++","java"};

        //1.Compare using simple for loop:

        for (int i=0;i< names.length;i++) {
            for (int j = i + 1; j < names.length; j++) {

                if (names[i].equals(names[j])) {
                    System.out.println("Duplicate Element is::" + names[i]);
                }
            }
        }

            System.out.println("***************************");

        //2.Compare using HashSet--> HashSet is an collection in Java: It is use to store unique values"Duplicate value
        //    are not allowed in HashSet.

            Set<String> store= new HashSet<String>();
            for (String name:names){
                if (store.add(name)==false){
                    System.out.println("duplicate Element is:"+name);
                }
            }

        System.out.println("***************************");

        //3. Using HashMap:
        Map<String,Integer> storeMap= new HashMap<String,Integer>();

            for (String name: names){
                Integer count= storeMap.get(name);

                if (count == null){
                    storeMap.put(name,1);
                }
                else {
                    storeMap.put(name,++count);
                }
            }
        //get the values from HashMAp:
        Set<Map.Entry<String,Integer>> entrySet=storeMap.entrySet();
            for (Map.Entry<String,Integer> entry:entrySet){
               if (entry.getValue()>1){

                   System.out.println("Duplicate Element is::"+entry.getKey());
               }
            }
    }
}
