package chap_11;

import org.w3c.dom.ls.LSOutput;

public class _04_Finally {
    public static void main(String[] args) {
        try{
            System.out.println("택시의 문을 연다. ");
           // throw new Exception("휴무택시");
        } catch (Exception e){
            System.out.println("!! 문제 발생 : " + e.getMessage());
        } finally { //무조건 실행하는 구문
            System.out.println("택시의 문을 닫는다. ");
        }

        //try + catch(s)
        //try + catch(s) + finally
        //try + finally

        System.out.println("-------------------------------");

        try {
            System.out.println(3 / 0);
        }finally {
            System.out.println("프로그램 정상 종료");
        }
    }


}
