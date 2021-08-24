public class HelloMac {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("hello mac 13");

        HelloMac helloMac = new HelloMac();
        HelloMac clone = (HelloMac)helloMac.clone();
        System.out.println(clone == helloMac);

    }
}
