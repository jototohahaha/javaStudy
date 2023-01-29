package chap_07.camera;

public class SpeedCam extends Camera{ //자식클래스
    public SpeedCam() {
        super("과속단속 카메라");
        //this.name = "과속단속 카메라";
    }

    public void takePicture() {
        // 사진 촬영
        super.takePicture();
        checkSpeed();
        recognizeLicensePlate();
    }


    public void checkSpeed(){
        //속도체크
        System.out.println("속도를 측정합니다.");
    }

    public void recognizeLicensePlate(){
        //번호인식
        System.out.println("차량번호를 인식합니다.");
    }

    @Override //annotation
    public void showMainFeature() {
        System.out.println(this.name + "의 주요 기능: 속도측정, 번호인식");
    }
}
