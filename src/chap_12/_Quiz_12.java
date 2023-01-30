package chap_12;

public class _Quiz_12 {
    public static void main(String[] args) {
        Runnable runnableA = () -> {
          for(int i = 1; i < 6; i++){
              System.out.println("A상품 준비 " + i + "/5");
          }
            System.out.println("-- A상품 준비 완료 --");
        };
        Runnable runnableB = () ->{
            for(int i = 1; i < 6; i++){
                System.out.println("B상품 준비 " + i + "/5");
            }
            System.out.println("-- B상품 준비 완료 --");
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

        threadA.start();
        threadB.start();

        while (threadA.isAlive() || threadB.isAlive()){
            //밑에 코드와 같은 역할
        }
//        try {
//            threadA.join();
//            threadB.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Runnable runnableSet = () ->{
            System.out.println("== 세트상품 포장 시작 ==");
            for(int i = 1; i < 6; i++){
                System.out.println("세트 상품 포장 " + i + "/5");
            }
            System.out.println("== 세트 상품 포장 완료 ==");
        };
        Thread threadSet = new Thread(runnableSet);
        threadSet.start();



    }
}


