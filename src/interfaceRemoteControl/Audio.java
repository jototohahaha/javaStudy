package interfaceRemoteControl;

public class Audio implements Remotecontrol{
    private int volume;

    //추상 메소드실체
    @Override
    public void turnOn() {
        System.out.println("오디오를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > Remotecontrol.MAX_VOLUME){
            this.volume = Remotecontrol.MAX_VOLUME;
        } else if (volume < Remotecontrol.MIN_VOLUME) {
            this.volume = Remotecontrol.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 오디오 볼룸 : " + this.volume);
    }
}
