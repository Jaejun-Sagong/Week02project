import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bus b1 = new Bus(12);
        Bus b2 = new Bus(34);

        Taxi t1 = new Taxi(56);
        Taxi t2 = new Taxi(78);

        System.out.println("b1의 번호: "+b1.num);
        System.out.println("b2의 번호: "+b2.num);

        b1.getPassenger(2);
        b1.getFuel(-50);
        b1.changeCondition("차고지행");
        b1.getFuel(10);
        b1.changeCondition("운행중");
        b1.getPassenger(45);
        b1.getPassenger(5);
        b1.getFuel(-55);

        t1.getStatus();
        t2.getStatus();
        t1.getPassenger(2,"서울역", 2);
        t1.getFuel(-80);
        t1.payment();
        t1.getPassenger(5,"수서역",20);
        t1.getPassenger(3,"구로디지털단지역",12);
        t1.getFuel(-20);
        t1.payment();

    }
}