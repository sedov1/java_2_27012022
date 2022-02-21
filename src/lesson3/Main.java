package lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[]words={"aa","bb", "cc","dd","ee","aa","aa","bb","cc","gg","hh","ee"};
        System.out.println(Arrays.toString(words));
        Map <String,Integer> hmap=new HashMap<>();
        for (String x:words) {
            hmap.put(x,hmap.getOrDefault(x,0)+1);

        }
        System.out.println(hmap);
        Phone phbook= new Phone();
        phbook.add("Седов","80296543");
        phbook.add("Деркач","80295656543");
        phbook.add("Поркин","80295654454");

        System.out.println("тел:" +phbook.get("Седов"));
        System.out.println("тел:" +phbook.get("Деркач"));
        System.out.println("тел:" +phbook.get("Поркин"));
    }

}

