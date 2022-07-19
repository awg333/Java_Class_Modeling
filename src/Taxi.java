public class Taxi extends Transport{
    private String destination;
    private int destDistance;
    private int defaultDistance;
    private int distanceFare;
    private int income;

    public Taxi() {
        super(3000, 4);
        this.defaultDistance = 1;
        this.distanceFare = 1000;

        System.out.println("### " + getNum() + "번 택시 운행 시작 ###");
    }

    public void takePassenger(int n){
        System.out.println("# 숭객 " + n);
        this.destination = "아무데나 가주세요";
        this.destDistance = 10;
        boarding(n);
    }

    public void takePassenger(int n, String destination, int destDistance){
        System.out.println("# 숭객 " + n + ", 목적지 = " + destination + ", 목적지까지 거리 = " + destDistance + "km");
        this.destination = destination;
        this.destDistance = destDistance;
        boarding(n);
    }

    @Override
    public void print() {
        System.out.println("# 택시 정보 출력");
        if(getCurState() == State.Driving){
            System.out.println("\t탑승 승객 수 = " + getCurPassenger());
            System.out.println("\t잔여 승객 수 = " + (getMaxPassenger() - getCurPassenger()));
            System.out.println("\t기본 요금 확인 = " + getMinimumFare());
            System.out.println("\t목적지 = " + destination);
            System.out.println("\t목적지까지 거리 = " + destDistance + "km");
            System.out.println("\t지불할 요금 = " + calculateFare());
            System.out.println("\t상태 = 운행중");
        }else{
            if(checkRefuel()){
                System.out.println("\t상태 = 대기중");
                System.out.println("\t주유량 = " + getRefuel());
                System.out.println("\t누적 요금 = " + income);
            }else{
                System.out.println("\t상태 = 운행불가");
                System.out.println("\t주유량 = " + getRefuel());
                System.out.println("\t누적 요금 = " + income);
            }

        }
    }

    @Override
    public void drive() {
        if(checkRefuel()){
            //운행중!
            System.out.println("\t출발!");
        }else{
            changeState(State.Default);
        }
    }

    @Override
    public void boarding(int n) {
        super.boarding(n);
        if(getCurState() == State.Driving){
            System.out.println("\t승객이 타고있습니다.");
        }else{
            if(getCurPassenger() + n <= getMaxPassenger()){
                setCurPassenger(getCurPassenger()+n);
                changeState(State.Driving);
                print();
            }else{
                System.out.println("\t최대 승객 수 초과");
            }
        }
    }

    @Override
    public void changeState(State state) {
        if(state == getCurState()){
            System.out.println("\t동일한 상태변경 요청입니다.");
        }else{
            if(state == State.Driving){
                setCurState(state);
                drive();
            }else{
                setCurState(state);
                print();
            }
        }

    }

    public void charge(){
        System.out.println("# 요금 결제");
        income += calculateFare();
        destination = "";
        destDistance = 1;
        clearPassenger();
        changeState(State.Default);
    }

    public int calculateFare(){
        return getMinimumFare() * defaultDistance + (destDistance - defaultDistance) * distanceFare;
    }
}
