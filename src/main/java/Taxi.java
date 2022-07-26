import java.util.*;
public class Taxi extends Vehicle {
    protected String condition = "일반";
    protected int maxPassenger = 4;
    protected int price = 1000;
    protected String destination;
    protected int distance;
    protected int totalIncome=0;

    public Taxi(int num) {
        super(num);
    }

    void getStatus(){
        System.out.println("번호: "+this.num);
        System.out.println("주유량: "+this.fuel);
        System.out.println("상태: "+this.condition+"\n");

    }

    public void changeCondition(String inputCondition) {
        if ("탑승불가".equals(inputCondition)|| "일반".equals(inputCondition) || "운행".equals(inputCondition)) {
            this.condition = inputCondition;
        } else{
            System.out.println("잘못 입력하셨습니다.\n\n");
        }
    }
    void getPassenger(int a, String destination, int distance) {
        this.destination = destination;
        this.distance = distance;
        if ("일반".equals(this.condition)) {
            if (this.maxPassenger - a >= 0) {
                this.maxPassenger -= a;
                System.out.printf("탑승 승객 수: %d\n", a);
                System.out.printf("잔여 승객 수: %d\n", this.maxPassenger);
                printPayment();
                this.condition = "운행중";
                System.out.println("상태: "+this.condition+"\n");

            } else {
                System.out.println("최대 승객 수 초과\n");
            }
        } else if ("운행중".equals(this.condition) || "탑승불가".equals(this.condition)){
            System.out.println("이용 불가능합니다.\n");

        }
    }

    void printPayment(){
        if(distance>8){
            System.out.printf("기본 요금 확인: %d\n",4000);
            System.out.printf("목적지: %s\n", destination);
            System.out.printf("목적지까지 거리: %d\n", distance);
            System.out.printf("지불할 요금: %d\n", (distance-1)*price+4000);
            this.totalIncome += (distance-1)*price+4000;
        } else{
            System.out.printf("기본 요금 확인: %d\n",3000);
            System.out.printf("목적지: %s\n", destination);
            System.out.printf("목적지까지 거리: %d\n", distance);
            System.out.printf("지불할 요금: %d\n", (distance-1)*price+3000);
            this.totalIncome += (distance-1)*price+3000;
        }


    }
    void payment(){
        this.condition = "일반";
        this.maxPassenger =4;
        System.out.println("주유량: "+this.fuel);
        if(this.fuel <10){
            this.condition = "탑승불가";
            System.out.println("상태: "+this.condition);
        }
        System.out.printf("누적 요금: %d\n\n",this.totalIncome);

    }


    void getFuel(int a) {
        this.fuel += a;
        if (this.fuel > 10) {
            System.out.println("주유량: " + this.fuel);
            System.out.println("상태: " + this.condition);
            System.out.println();
        } else if (this.fuel < 10) {
            this.condition = "탑승불가";
            System.out.printf("주유량 : %d\n", this.fuel);
            System.out.println("상태: "+this.condition);
            System.out.println("주유가 필요가 필요합니다.\n");
        }
        if (this.fuel < 0){
            System.out.println("잘못 입력하셨습니다.\n");
        }
    }
}