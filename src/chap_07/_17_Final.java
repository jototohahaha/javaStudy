package chap_07;

import chap_07.camera.ActionCam;
import chap_07.camera.SlowActionCam;

public class _17_Final {
    public static void main(String[] args) {
        //Final
        ActionCam actionCam = new ActionCam();
        //actionCam.lens = "표준 렌즈"; -> final을 이용하여 값 변경이 불가능함
        actionCam.recordVideo();
        actionCam.makeVideo();

        System.out.println("---------------------" +
                "");
        SlowActionCam slowActionCam = new SlowActionCam();

        slowActionCam.makeVideo();


    }
}
