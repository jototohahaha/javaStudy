package chap_12.clean;

public class CleanTread extends Thread{
    public void run(){
        System.out.println("-- 직원 청소 시작(thread) --");
        for(int i = 2; i <=10; i += 2){
            System.out.println("직원 " + i + "번방 청소 중 (thread)");
        }
        System.out.println("-- 직원 청소 끝 (thread) --");
    }
}
