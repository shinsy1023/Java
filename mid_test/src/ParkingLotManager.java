import java.util.ArrayList;

/**
 * Created by shinsy1023 on 2016. 4. 30..
 */
class ParkingLotManager {
    ArrayList<ParkedCar> park=new ArrayList<ParkedCar>();
    ArrayList<ParkedCar> member=new ArrayList<ParkedCar>();
    ArrayList<String> inout=new ArrayList<String>();

    public void add(String carNum, String kindOfCar, int time, int min){
        inout.add("입차 "+carNum+ " "+kindOfCar+" "+time+"시 "+min+"분");
    }

    public void delete(String carNum, String kindOfCar, int time, int min){
        inout.add("출차 "+carNum+ " "+kindOfCar+" "+time+"시 "+min+"분");
    }

}
