import java.util.UUID;
enum State{Default, Driving, Parking};

public abstract class Transport {

    private String num;

    private int refuel;
    private int speed;
    private int minimumFare;

    private State curState;
    private int maxPassenger;

    private int curPassenger;

    public Transport(int minimumFare, int maxPassenger) {
        this.num = UUID.randomUUID().toString();
        this.refuel = 100;
        this.speed = 0;
        this.minimumFare = minimumFare;
        this.curState = State.Default;
        this.maxPassenger = maxPassenger;
        this.curPassenger = 0;
    }


    public boolean checkRefuel(){
        if(refuel >= 10){
            return true;
        }else{
            System.out.println("\t주유가 필요합니다.");
            return false;
        }
    }

    public void calculateRefuel(int l){

        if(l > 0) System.out.println("# 주유량 +" + l);
        else
            System.out.println("# 주유량 "+ l);

        refuel += l;
        //System.out.println("주유량 = " + refuel);
    }

    // 속도변경
    public void changeSpeed(int value){
        if(checkRefuel()){
            setSpeed(speed + value);
        }

    }

    public void clearPassenger(){
        setCurPassenger(0);
    }
    // 출력
    public abstract void print();
    // 운행
    public abstract void drive();
    // 탑승
    public void boarding(int n) {
        if(n > 0) System.out.println("# 승객 +" + n);
        else
            System.out.println("# 승객 " + n);
    }
    // 상태변경
    public abstract void changeState(State state);
    public String getNum() {
        return num;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public State getCurState() {
        return curState;
    }

    public void setCurState(State curState) {
        this.curState = curState;
    }

    public int getCurPassenger() {
        return curPassenger;
    }

    public void setCurPassenger(int curPassenger) {
        this.curPassenger = curPassenger;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getMinimumFare() {
        return minimumFare;
    }

    public int getRefuel() {
        return refuel;
    }

}
