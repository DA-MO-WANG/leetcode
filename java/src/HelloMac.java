public class HelloMac {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("hello mac 13");

        HelloMac helloMac = new HelloMac();
        Object clone = helloMac.clone();
        System.out.println(clone == helloMac);

    }
}
