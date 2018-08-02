package classtasks.birds;

public abstract class Bird {
    public String feathers;

    public int layEggs;

    Bird(String feathers, int layEggs) {
        this.feathers = feathers;
        this.layEggs = layEggs;
    }

    public abstract void fly();

    public String info() {
        return (this.getClass().getSimpleName() + "\nFeathers: " + this.feathers + "\n" + "Lay eggs:" + this.layEggs + "\n");
    }
}
