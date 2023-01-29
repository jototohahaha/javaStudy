package chap_06;

public class _03_Return {
    public static String getPhoneNumber(){
        String phoneNum = "02-1234-5678";
        return phoneNum;
    }

    public static void main(String[] args){
        String phoneNum = getPhoneNumber();
        System.out.println(phoneNum);
    }
}
