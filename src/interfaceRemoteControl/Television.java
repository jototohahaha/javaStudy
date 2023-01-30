package interfaceRemoteControl;

public class Television implements Remotecontrol{
    private int volume;

    //추상 메소드의 실체 메소드
    public void turnOn(){
        System.out.println("티비를 켭니다.");
    }

    public void turnOff(){
        System.out.println("티비를 끕니다.");
    }

    public void setVolume(int volume){
        if(volume > Remotecontrol.MAX_VOLUME){
            this.volume = Remotecontrol.MAX_VOLUME;
        } else if (volume < Remotecontrol.MIN_VOLUME) {
            this.volume = Remotecontrol.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 티비 볼륨 : " + this.volume);
    }

}
