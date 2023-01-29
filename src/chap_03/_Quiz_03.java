package chap_03;

public class _Quiz_03 {
    public static void main(String[] args){
        String str = "901231-1234567";
        System.out.println(str.substring(0, str.indexOf("-") + 2));
    }
}
