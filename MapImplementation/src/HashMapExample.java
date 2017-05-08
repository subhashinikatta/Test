import java.util.HashMap;
02
import java.util.Map;
03
 
04
public class HashMapExample {
05
     
06
    public static void main(String[] args) {
07
        Map vehicles = new HashMap();
08
         
09
        // Add some vehicles.
10
        vehicles.put("BMW", 5);
11
        vehicles.put("Mercedes", 3);
12
        vehicles.put("Audi", 4);
13
        vehicles.put("Ford", 10);
14
         
15
        System.out.println("Total vehicles: " + vehicles.size());
16
         
17
        // Iterate over all vehicles, using the keySet method.
18
        for(String key: vehicles.keySet())
19
            System.out.println(key + " - " + vehicles.get(key));
20
        System.out.println();
21
         
22
        String searchKey = "Audi";
23
        if(vehicles.containsKey(searchKey))
24
            System.out.println("Found total " + vehicles.get(searchKey) + " "
25
                    + searchKey + " cars!\n");
26
         
27
        // Clear all values.
28
        vehicles.clear();
29
         
30
        // Equals to zero.
31
        System.out.println("After clear operation, size: " + vehicles.size());
32
    }
33
}
