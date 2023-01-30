package sec01.exam06;

public class SportsCar extends Car{
	@Override
	public void speedUp() {speed += 10;}
	
	//아래와 같이 재정의 불가능
//	@Override
//	public void stop() {
//		System.out.println("스포츠카를 멈춤");
//		speed = 0;
//	}
	
}
