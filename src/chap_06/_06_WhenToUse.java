package chap_06;

public class _06_WhenToUse {
    public static void main(String[] args){
        int result = 1;
        for(int i = 0; i < 2; i++){
            result *= 2;
        }
        System.out.println(result);

        result = 1;
        for(int i = 0; i < 3; i++){
            result *= 3;
        }
        System.out.println(result);
    }
}
