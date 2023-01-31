package Thread;

import java.awt.*;

public class BeepPrintExample2_1 {
    public static void main(String[] args) {
        //익명 구현 객체 : 객체를 일회용으로 사용할 때
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i < 5; i++){
                    toolkit.beep();
                    try{Thread.sleep(500);}
                    catch (Exception e) { }
                }
            }
        });
        thread.start();

        for(int i = 0; i < 5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(500);
            } catch (Exception e) {}
        }

    }
}
