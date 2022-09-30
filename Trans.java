public class Trans {
    public static void main(String[] args){

        //c_speed,gas_give   bus:run,get   texi:in,out
    Bus b1=new Bus(123,100);
    Texi t1=new Texi(234,100);
    t1.gas_give(0);
    t1.in(3,"대전역",10);
    t1.out();
    t1.gas_give(100);








    }
}



class Model{
    int number;
    int gas;
    int speed;
    int max_cus;
    int cus;
    int pay;
    boolean state;

    Model(){
        this.gas = 100;
        this.speed = 0;
    }
    void c_speed(int A){
        speed+=A; System.out.printf("현재속도:%d\n",speed);
    }
    void gas_give(int A){
        gas+=A; System.out.printf("주유량=%d\n",gas);
        if(gas<10){
            state=false; System.out.printf("상태 = 차고지행\n주유가 필요합니다.");
        }
    }



}



class Bus extends Model{

    Bus(int number, int speed){
        this.max_cus=30;
        this.pay=1000;
        this.number=number;
        this.speed=speed;
        this.state=true;
    }
     boolean run(boolean b){
        state=b;
        if(state == true){
            System.out.println("운행중\n");
        }else {
            System.out.println("차고지행\n");
        }
         return b;
     }
    void get(int A){
        cus+=A; pay+=A*pay;
        if(max_cus<cus){
            cus-=A; System.out.printf("최대승객수 초과\n");
        }
        System.out.printf("탑승 승객 수 = %d\n잔여 승객 수 =%d\n요금 = %d",A,cus,pay);
    }






}

class Texi extends Model {
    String end;
    int street;
    int basic_street;
    int basic_pay;
    int much_pay;

    Texi(int number, int speed) {
        this.max_cus = 4;
        this.basic_pay = 3000;
        this.much_pay = 1000;
        this.basic_street = 1;
        this.number = number;
        this.speed = speed;
        this.state = true;
    }

    void in(int A, String B, int C) {
        cus = A;
        end = B;
        street = C;
        if(gas<1){
            System.out.printf("기름이 없어 운행할 수 없습니다.\n");
        }else if (cus > max_cus) {
            System.out.printf("최대 승객 수 초과");
        } else if (street < basic_street) {
            System.out.printf("거리가 짧아 운행할 수 없습니다.");
        } else {
            pay += basic_pay + C * much_pay;
            System.out.printf("탑승 승객수 = %d\n기본 요금 확인=%d\n목적지 = %s\n목적지까지 거리 = %dkm\n지불할 요금=%d\n상태 운행중\n", cus, basic_pay, end, street, pay);
        }
    }
    void out(){
        gas-=street*10;
        System.out.printf("주유량=%d\n누적요금=%d\n",gas,pay);
        if(gas<1){
            state=false;
            System.out.printf("상태 = 운행불가\n주유 필요\n");
        }
    }







}