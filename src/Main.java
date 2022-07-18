public class Main {

    public static void main(String args[]){
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();

        bus1.boarding(2);

        bus1.calculateRefuel(-50);

        bus1.changeState(State.Parking);

        bus1.calculateRefuel(10);

        bus1.changeState(State.Driving);

        bus1.boarding(45);

        bus1.boarding(5);

        bus1.calculateRefuel(-55);

        System.out.println("-----------------------------------");
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        taxi1.takePassenger(2, "서울역", 2);

        taxi1.calculateRefuel(-80);

        taxi1.charge();

        taxi1.takePassenger(5);

        taxi1.takePassenger(3, "구로디지털단지역", 12);

        taxi1.calculateRefuel(-20);

        taxi1.charge();

    }
}
