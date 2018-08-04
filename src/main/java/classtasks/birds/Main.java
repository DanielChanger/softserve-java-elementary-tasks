package classtasks.birds;

public class Main {
    public static void main(String[] args) {
        Bird[] birds = {
                new Eagle("Eagle feathers", 3),
                new Swallow("Swallow feathers", 5),
                new Penguin("Penguin feathers", 2),
                new Chicken("Chicken feathers", 10)
        };

        for (Bird temp : birds) {
            System.out.print(temp.info());
            temp.fly();
            System.out.println();
        }
    }
}
