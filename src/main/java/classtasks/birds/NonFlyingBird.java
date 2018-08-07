package classtasks.birds;

public abstract class NonFlyingBird extends Bird {

  NonFlyingBird(String feathers, int layEggs) {
    super(feathers, layEggs);
  }

  @Override
  public final void fly() {
      System.out.println("Cannot fly");
  }
}
