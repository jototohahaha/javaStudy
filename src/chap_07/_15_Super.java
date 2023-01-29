package chap_07;

import chap_07.camera.FactoryCam;
import chap_07.camera.SpeedCam;

public class _15_Super {
    public static void main(String[] args) {
        //Super:  부모클래스를 자식클래스에서 사용
        FactoryCam factoryCam  = new FactoryCam();
        SpeedCam speedCam = new SpeedCam();

        factoryCam.recordVideo();
        System.out.println("-------------");
        speedCam.takePicture();
    }
}
