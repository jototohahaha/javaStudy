package interfaceRemoteControl;

public class SmartTelevision implements Remotecontrol, Searchable{  //다중인터페이스
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("티비를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("티비를 끕니다.");
    }

    public void setVolume(int volume){
        if(volume > Remotecontrol.MAX_VOLUME){
            this.volume = Remotecontrol.MAX_VOLUME;
        } else if ( volume < Remotecontrol.MIN_VOLUME) {
            this.volume = Remotecontrol.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 티비 볼륨 : " + this.volume);
    }

    @Override
    public void Search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
