package chap_09.coffee;

import chap_09.user.User;

public class CoffeeByUser <T extends User> { //유저 클래스 또는 이를 상속하는 클래스만 받을 수 있음
    public T user;

    public CoffeeByUser(T user) {
        this.user = user;
    }

    public void ready(){
        System.out.println("커피 준비 완료 : " + user.name);
        user.addPointer();
    }
}
