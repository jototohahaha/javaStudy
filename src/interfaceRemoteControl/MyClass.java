package interfaceRemoteControl;

public class MyClass {
    Remotecontrol rc = new Television();

    MyClass(){
    }

    MyClass(Remotecontrol rc){
        this.rc = rc;
        rc.turnOn();
        rc.setVolume(5);
    }

    void methodA(){
        Remotecontrol rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
    }
    void methodB(Remotecontrol rc){
        rc.turnOn();
        rc.setVolume(5);
    }
}
