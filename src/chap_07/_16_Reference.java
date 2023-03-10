package chap_07;

import chap_07.camera.Camera;

public class _16_Reference {
    public static void main(String[] args) {
        //참조

        //기본 자료형: int float double, long boolean - 기본값을 가짐
        int[] i = new int[3];
        System.out.println(i[0]);

        double[] d = new double[3];
        System.out.println(d[0]);

        //참조자료형(메소드를 가질 수 있음)  reference data types: String, 클래스로 만들어진 자료형 - 기본값은 null
        String[] s = new String[3];
        System.out.println(s[0]);

        Camera[] c = new Camera[3];
        System.out.println(c[0] == null);


        ///////////////////////////////////////////
        System.out.println("--------------------------p");
        int a = 10;
        int b = 20;
        b = a;
        System.out.println(a);
        System.out.println(b);
        b = 30;
        System.out.println(a);
        System.out.println(b);


        System.out.println("-----------------------");
        Camera c1 = new Camera();
        Camera c2 = new Camera();
        c1.name = "카메라1";
        c2.name = "카메라2";
        System.out.println(c1.name);
        System.out.println(c2.name);
        c2 = c1; ///c1 주소값을 복사
        System.out.println(c1.name);
        System.out.println(c2.name);
        changeName(c2); //c1주소값의 값을 변경하여  c1도 바뀜
        System.out.println(c1.name);
        System.out.println(c2.name);

        c2 = null;
        System.out.println(c2.name);
    }

    public static void changeName(Camera camera){
        camera.name = "잘못된 카메라";
    }
}
