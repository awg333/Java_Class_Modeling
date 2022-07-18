public class Bus extends Transport{

    public Bus() {
        super(1000, 30);
        System.out.println("### " + getNum() + "번 버스 운행 시작 ###");
        changeState(State.Driving);
    }

    @Override
    public void print() {
        System.out.println("# 버스 정보 출력");
        if(getCurState() == State.Driving){
            System.out.println("\t탑승 승객 수 = " + getCurPassenger());
            System.out.println("\t잔여 승객 수 = " + (getMaxPassenger() - getCurPassenger()));
            System.out.println("\t요금 확인 = " + getCurPassenger() * getMinimumFare());
        }else{
            System.out.println("\t상태 = 차고지행");
            System.out.println("\t주유량 = " + getRefuel());
        }
    }

    @Override
    public void calculateRefuel(int l){
        super.calculateRefuel(l);
        if(checkRefuel()){
            if(getCurState() == State.Driving)
                System.out.println("\t주유량 = " + getRefuel());
            else{
                print();
            }
        }else{
            changeState(State.Parking);
            print();
        }

    }
    @Override
    public void drive() {
        if(checkRefuel()){
            //운행중!
            System.out.println("\t운행 시작");
        }else{
            changeState(State.Parking);
        }
    }

    @Override
    public void boarding(int n) {
        super.boarding(n);
        if(getCurPassenger() + n <= getMaxPassenger()){
            setCurPassenger(getCurPassenger() + n);
            print();
        }else{
            System.out.println("\t최대 승객 수 초과");
        }
    }

    @Override
    public void changeState(State state) {
        if(state == getCurState()) {
            System.out.println("# 이미 운행중");
        }else{
            if(state == State.Driving){
                System.out.println("# 상태 변경 : 운행중");
                setCurState(State.Driving);
                drive();
            }else{
                System.out.println("# 상태 변경 : 차고지행");
                setCurState(State.Parking);
                clearPassenger();
            }
        }

    }
}
