package chap_04;

public class _Quiz_04 {
    public static void main(String[] args){
        int hour = 10;
        boolean isSmallCar = false;
        boolean withDisabledPerson = true;

        int fee = hour * 4000;

        if (fee > 30000) fee = 30000;
        if(isSmallCar == true)  fee *= 0.5;
        if(withDisabledPerson == true) fee *= 0.5;

        System.out.println("주차 요금은 " + fee + "원 입니다.");
    }
}
