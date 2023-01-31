package Thread;

import java.awt.*;

public class BeepPrintExample5 {
    //익명자식객체 사용
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i < 5; i++){
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e){}
                }
            }
        };
        thread.start();

        for(int i = 0; i < 5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(500);
            } catch (Exception e){}
        }
    }
}
