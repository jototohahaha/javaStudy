package polymorphism.casting;

import sec06.exam03.package2.C;

public class ChildExample {
    public static void main(String[] args) {
        Parents parents = new Child();  //자동 타입 변환
        parents.field1 = "data1";
        parents.method1();
        parents.method2();

//        parents.field2 = "data2";
//        parents.method3();
        // 불가능

        Child child = (Child) parents;  //강제로 자식클래스로 타입 변환 --> 자식타입이 부모타입으로 변환되어 있는 상태에서만 가능
        child.field2 = "yyy";
        child.method3();
    }
}
