package chap_07.camera;

public class FactoryCam extends Camera{ //자식클래스
    public FactoryCam() {
        super("공장 카메라"); //부모클래스의 생성자에 접근
        //this.name = "공장카메라";
    }

    public void recordVideo() {
        // 동영상 녹화
        super.recordVideo();
        detectFire();
    }


    public void detectFire(){
        //화재감지
        System.out.println("화재를 감지합니다.");
    }

    public void showMainFeature() {
        System.out.println(this.name + "의 주요 기능 : 화재 감지");
    }
}
