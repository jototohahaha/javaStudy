package chap_07;

public class _Quiz_07 {
    public static void main(String[] args) {
        Hamburger[] hamburgers = new Hamburger[3];
        hamburgers[0] = new Hamburger();
        hamburgers[1] = new CheeseBurger();
        hamburgers[2] = new ShrimpBurger();

        System.out.println("주문하신 메뉴를 만듭니다. ");
        System.out.println("--------------------------");
        for(Hamburger hamburger: hamburgers){
            hamburger.cook();
            System.out.println("-------------------------");
        }
        System.out.println("메뉴 준비가 완료되었습니다. ");
    }


}

 class Hamburger{
    public String name;
    public Hamburger(){
        this("햄버거");
    }

     public Hamburger(String name){
        this.name = name;
    }

    public void cook(){
        System.out.println(this.name + "를 만듭니다. \n빵 사이에 들어가는 재료는?");
        System.out.println("> 양상추");
        System.out.println("+ 패티");
        System.out.println("+ 피클");
    }
}

 class CheeseBurger extends Hamburger{
    public CheeseBurger() {
        super("치즈버거");

    }

     @Override
     public void cook() {
         super.cook();
         System.out.println("+ 치즈");
     }
 }
 class ShrimpBurger extends Hamburger{
    public ShrimpBurger(){
        super("새우버거");
    }

     @Override
     public void cook() {
         super.cook();
         System.out.println("+ 새우");
     }
}



