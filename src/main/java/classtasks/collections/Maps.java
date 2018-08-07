package classtasks.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {
        Map<String, String> personMap = new LinkedHashMap<>();
        personMap.put("Changer", "Daniel");
        personMap.put("Link", "Andrew");
        personMap.put("Url", "Eddie");
        personMap.put("Paliy", "Orest");
        personMap.put("Go", "Danny");
        personMap.put("Charger", "Daniel");
        personMap.put("Johnson", "Ray");
        personMap.put("Park", "Jason");
        personMap.put("Foy", "Andrew");
        personMap.put("Van der Meer", "Eddie");

        personMap.forEach((key, value) -> System.out.println(key + " " + value));
        Collection<String> names = new LinkedList<String>();
        int nameRepeats = 0;
        for (String str : personMap.values()) {
            if (!names.contains(str)) {
                names.add(str);
            } else {
                nameRepeats++;
            }
        }
        System.out.println(nameRepeats);


    }
}
