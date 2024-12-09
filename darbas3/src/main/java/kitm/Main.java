package kitm;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();

        Animal animal = new Bird();

        FlightEnabled flier = bird;

        Trackable tracked = bird;

        animal.move();
        flier.takeoff();
        flier.fly();
        tracked.track();
        flier.land();
    }
}