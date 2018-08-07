package classtasks.collections;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static boolean union(Set<Integer> set1, Set<Integer> set2) {
        return set1.addAll(set2);
    }

    public static boolean intersect(Set<Integer> set1, Set<Integer> set2) {
        return set1.retainAll(set2);
    }


    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(5);
        set1.add(6);
        set1.add(7);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);

        Sets.union(set1, set2);

        for (Integer element : set1) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (Integer element : set2) {
            System.out.print(element + " ");
        }

        System.out.println();
        Sets.intersect(set1, set2);


        for (Integer element : set1) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (Integer element : set2) {
            System.out.print(element + " ");
        }
    }
}
