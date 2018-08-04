package classtasks.birds;

public class Swallow extends FlyingBird {

    Swallow(String feathers, int layEggs) {
        super(feathers, layEggs);
    }

    @Override
    public void fly() {
        System.out.println("Flying like a swallow");
    }
}
