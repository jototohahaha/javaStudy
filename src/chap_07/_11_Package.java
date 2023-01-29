package chap_07;

import java.util.Random;

public class _11_Package {
    public static void main(String[] args) {
        //패키지 랜덤클래스 사용
        Random random = new Random();
        System.out.println("랜덤정수: " + random.nextInt()); //정수 범위 내에서 정수형 값 반환
        System.out.println(random.nextInt(10)); //0이상 10 미만 정수 값 반환
        System.out.println(random.nextDouble()); //0.0이상 1.0 미만 실수

        // 5.0 ~ 10.0 미만의 실수를 뽑기위해
        double min = 5.0;
        double max = 10.0;
        System.out.println(min + (max - min) * random.nextDouble());

        //로또 번호 1~45
        System.out.println("로또번호 : " + ( random.nextInt(45) + 1));

        //Math, Scanner, StingBuilder, StringBuffer, StringTokenizer,
        //BigInteger, BigDecimal
    }
}
