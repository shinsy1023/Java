/**
 * Created by shinsy1023 on 2016. 4. 30..
 */
class ParkedCar extends Car {
    int inTime;
    int inMin;
    int outTime;
    int outMin;
    String mem="F";
    static int pay=0;

    ParkedCar(String num, String car, int time, int min){
        this.carNum=num;
        this.kindOfCar=car;
        this.inTime=time;
        this.inMin=min;
    }

    public void memPark(int time, int min){
        this.inTime=time;
        this.inMin=min;
    }

    public void out(int time, int min){
        this.outTime=time;
        this.outMin=min;
    }

    public int pay(){
        int money;
        int min=(((outTime-inTime)*60)+(outMin-inMin))/10;
        switch (this.kindOfCar){
            case "소형":
                money=100*min;
                break;
            case "중형":
                money=200*min;
                break;
            default:
                money=300*min;
                break;
        }
        return money;
    }

    @Override
    public String toString() {
        return this.carNum+"   "+this.kindOfCar;
    }
}
