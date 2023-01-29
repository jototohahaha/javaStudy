package chap_07;

public class _02_InstanceVariables {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();

        b1.modelName = "까망이";
        b1.resolution = "FHD";
        b1.color = "블랙";
        b1.price = 300000;

        System.out.println(b1.modelName);
        System.out.println(b1.color);
        System.out.println(b1.price);
        System.out.println(b1.resolution);

    }
}
