package chap_07;

import chap_07.camera.Camera;
import chap_07.camera.FactoryCam;
import chap_07.camera.SpeedCam;

public class _14_Polymorphism {
    public static void main(String[] args) {
        //다형성
        Camera camera  = new Camera();
        Camera factoryCam = new FactoryCam();
        Camera speedCam = new SpeedCam();


        camera.showMainFeature();
        factoryCam.showMainFeature();
        speedCam.showMainFeature();

        System.out.println("-----------");
        Camera[] cameras  = new Camera[3];
        cameras[0] = new Camera();
        cameras[1] = new FactoryCam();
        cameras[2] = new SpeedCam();

        for (Camera cam: cameras) {
            cam.showMainFeature();
        }

        System.out.println("-----------");

        //부모 클래스로 정의하여 자식 클래스에있는 메소드 사용 불가능
//        factoryCam.detectFire();
//        speedCam.checkSpeed();
//        speedCam.recognizeLicensePlate();

        if (camera instanceof Camera){
            System.out.println("카메라 입니다.");
        }

        if(factoryCam instanceof FactoryCam){
            //자료형을 자식 클래스 자료형으로 변환하면 자식클래스의 메소드 사용이 가능
            ((FactoryCam)factoryCam).detectFire();
        }

        if(speedCam instanceof SpeedCam){
            ((SpeedCam)speedCam).checkSpeed();
            ((SpeedCam)speedCam).recognizeLicensePlate();
        }

        Object[] objs = new Object[3];
        objs[0] = new Camera();
        objs[1] = new FactoryCam();
        objs[2] = new SpeedCam();

    }
}
