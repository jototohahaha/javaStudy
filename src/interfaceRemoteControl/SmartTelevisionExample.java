package interfaceRemoteControl;

public class SmartTelevisionExample {
    public static void main(String[] args) {
        SmartTelevision tv = new SmartTelevision();
        
        //각 인터페이스 타입의 변수에 대입 가능
        Remotecontrol rc = tv; 
        Searchable searchable = tv;
    }
}
