package classtasks.birds;

public class Eagle extends FlyingBird {
    Eagle(String feathers, int layEggs) {
        super(feathers, layEggs);
    }

    @Override
    public void fly() {
        System.out.println("Flying like an eagle");
    }
}
