package chap_12;

import chap_12.clean.CleanTread;

public class _01_Thread {
    public static void main(String[] args) {
        //프로세스 : 여러개의 쓰레드를 가질 수 있음
        //쓰레드
        //cleanBySelf();

        CleanTread cleanTread = new CleanTread();
//        cleanTread.run(); // 직원 청소
        cleanTread.start();

        cleanByBoss(); // 사장 청소
    }

    public static void cleanBySelf(){
        System.out.println("혼자서 청소 시작");
        for(int i = 1; i <=10; i++){
            System.out.println("혼자 " + i + "번방 청소 중");
        }
        System.out.println("혼자 청소 끝");
    }

    public static void cleanByBoss(){
        System.out.println("사장 청소 시작");
        for(int i = 1; i <=10; i += 2){
            System.out.println("사장 " + i + "번방 청소 중");
        }
        System.out.println("사장 청소 끝");
    }
}


