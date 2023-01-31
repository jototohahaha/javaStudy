package Thread;

public class BeepPrintExample4 {
    // 메인 스레드와 작업스레드가 동시에 실행됨
    public static void main(String[] args) {
        Thread thread = new BeepThread();
        thread.start(); //BeepThread 클래스의 run 메소드가 실행됨

        for(int i = 0; i < 5; i++){
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e){}
        }
    }
}
