package sec01.exam02;

public class StudetExample {

	public static void main(String[] args) {
		Student student = new Student("홍길동", "123456-12345566", 1);
		System.out.println("name: "+ student.name);
		System.out.println("ssn: " + student.ssn);
		System.out.println("student No: " + student.studentNo);
	}

}
