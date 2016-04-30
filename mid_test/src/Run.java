import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by shinsy1023 on 2016. 4. 30..
 */
public class Run {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int choice;
        String carNum;
        String kindOfCar;
        int time;
        int min;
        int i;
        Boolean pass=true;
        Boolean find;
        ParkingLotManager manager=new ParkingLotManager();
        ParkedCar car;
        while(pass){
            car=new ParkedCar("1234", "소형", 0, 0);
            find=false;
            System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", "1.입차", "2.출차", "3.회원등록", "4.회원삭제", "5.회원목록", "6.총매출", "7.입출차", "8.주차현황");
            choice=s.nextInt();
            switch (choice){
                case 1:
                    System.out.printf("차량번호를 입력해주세요\n");
                    carNum=s.next();
                    for(i=0; i<manager.member.size(); i++){
                        car=manager.member.get(i);
                        if(car.carNum.equals(carNum)){
                            find=true;
                            break;
                        }
                    }
                    if (find){
                        System.out.printf("입차 시각의 시간을 적어주세요\n");
                        time=s.nextInt();
                        System.out.printf("입차 시각의 분을 적어주세요\n");
                        min=s.nextInt();
                        car.memPark(time, min);
                        manager.add(car.carNum, car.kindOfCar, time, min);
                    }else{
                        System.out.printf("차종을 적어주세요\n");
                        kindOfCar=s.next();
                        System.out.printf("입차 시각의 시간을 적어주세요\n");
                        time=s.nextInt();
                        System.out.printf("입차 시각의 분을 적어주세요\n");
                        min=s.nextInt();
                        car=new ParkedCar(carNum, kindOfCar, time, min);
                        manager.add(car.carNum, car.kindOfCar, time, min);
                    }
                    manager.park.add(car);
                    break;
                case 2:
                    System.out.printf("차량번호를 입력해주세요\n");
                    carNum=s.next();
                    for(i=0; i<manager.park.size(); i++){
                        car=manager.park.get(i);
                        if (car.carNum.equals(carNum)){
                            break;
                        }
                    }
                    System.out.printf("출차 시각의 시간을 적어주세요\n");
                    car.outTime=s.nextInt();
                    System.out.printf("출차 시각의 분을 적어주세요\n");
                    car.outMin=s.nextInt();
                    manager.delete(carNum, car.kindOfCar, car.outTime, car.outMin);
                    if (car.mem=="T"){
                        System.out.printf("주차비는 0원입니다\n");
                    }else {
                        System.out.printf("주차비는 %d원입니다\n", car.pay());
                        ParkedCar.pay+=car.pay();
                    }
                    manager.park.remove(i);
                    break;
                case 3:
                    System.out.printf("차량번호를 적어주세요\n");
                    carNum=s.next();
                    System.out.printf("차종을 적어주세요\n");
                    kindOfCar=s.next();
                    car=new ParkedCar(carNum, kindOfCar, 0, 0);
                    car.mem="T";
                    manager.member.add(car);
                    break;
                case 4:
                    System.out.printf("차량번호를 적어주세요\n");
                    carNum=s.next();
                    for(i=0; i<manager.member.size(); i++){
                        car=manager.member.get(i);
                        if (car.carNum.equals(carNum)){
                            break;
                        }
                    }
                    manager.member.remove(car);
                    break;
                case 5:
                    for(i=0; i<manager.member.size(); i++){
                        System.out.printf("%s\n", manager.member.get(i));
                    }
                    break;
                case 6:
                    System.out.printf("총 매출은 %d원입니다\n", ParkedCar.pay+(manager.member.size()*100000));
                    break;
                case 7:
                    for (i=0; i<manager.inout.size(); i++) {
                        System.out.printf("%s\n", manager.inout.get(i));
                    }
                    break;
                case 8:
                    for (i=0; i<manager.park.size(); i++){
                        car=manager.park.get(i);
                        System.out.printf("%-3d%-6s%-6s%-8s\n", i+1, car.carNum, car.kindOfCar, car.mem);
                    }
                    break;
                default:
                    pass=false;
                    System.out.printf("종료합니다\n");
                    break;
            }

        }
    }
}

