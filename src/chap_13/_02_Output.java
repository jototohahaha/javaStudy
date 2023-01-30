package chap_13;

public class _02_Output {
    public static void main(String[] args) {
        //System.out.printf
       //System.out.format

        System.out.println("-------- 정수 ---------");
        System.out.printf("%d%n", 1);
        System.out.printf("%d %d %d %n", 1, 2, 3);
        System.out.printf("%d %n", 1234);
        System.out.printf("%6d %n",1234);
        System.out.printf("%06d%n", 1234);
        System.out.printf("%6d%n",-1234);
        System.out.printf("%+6d%n", 1234);
        System.out.printf("%,12d%n", 1000000000);

        System.out.println("------- 실수 -------");
        System.out.printf("%f%n", Math.PI);
        System.out.printf("%.2f%n", Math.PI);
        System.out.printf("%6.2f%n", Math.PI);
        System.out.printf("%-6.2f%n", Math.PI);
        System.out.printf("%06.2f\n", Math.PI);
        System.out.printf("%+6.2f\n", Math.PI);


        System.out.println("------- 문자열 -------");
        System.out.printf("%s%n", "Java");
        System.out.printf("%6s%n", "Java"); // __Java
        System.out.printf("%-6s%n", "Java"); // Java__
        System.out.printf("%6.2s%n", "Java"); // ____Ja 전체 문자열에서 2글자만
        System.out.printf("%-6.2s%n", "Java"); // Ja____ 전체 문자열에서 2글자만

        System.out.println("------- 응용 -------");
        System.out.println("이름 영어 수학 평균");
        System.out.println("강백호 " + 90 + " " + 80 + " " + 85.0);
        System.out.println("서태웅 " + 100 + " " + 100 + " " + 100.0);
        System.out.println("최치수 " + 95 + " " + 100 + " " + 97.5);

        System.out.println("------ 응용2 ------");
        System.out.println("이름      영어   수학   평균");
        System.out.printf("%-6s %4d %4d %6.1f%n", "강백호", 90, 80, 85.0);
        System.out.printf("%-6s %4d %4d %6.1f%n", "서태웅", 100, 100, 100.0);
        System.out.printf("%-6s %4d %4d %6.1f%n", "최치수", 95, 100, 97.5);

    }
}
