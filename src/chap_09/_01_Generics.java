package chap_09;

public class _01_Generics {
    public static void main(String[] args) {
        // 제네릭스.: 참조자료형만 가능
        // int -> Integer.parseInt();
        //double -> Double.toString();
        //float -> Float
        Integer[] iArray = {1, 2, 3, 4, 5};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] sArray = {"A", "B", "C", "D", "E"};

        printIntArray(iArray);
        printDoubleArray(dArray);
        printStringArray(sArray);

        System.out.println("--------------");
        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }

    // T : type, K : key, V : value, E : element
    //제네릭스
    private static <T> void printAnyArray(T[] array){ //제네릭스
        for(T t: array){
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private static void printStringArray(String[] sArray) {
        for(String str: sArray){
            System.out.print(str + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(Double[] dArray) {
        for(double d: dArray){
            System.out.print(d + " ");
        }
        System.out.println();
    }

    private static void printIntArray(Integer[] iArray) {
        for(int i: iArray){
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
