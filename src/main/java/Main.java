import implementations.StringsBuilder;

public class Main {
    public static void main(String[] args) {
        StringsBuilder sb = new StringsBuilder();
        sb.append("Merhaba");
        sb.append("Dunya");
        System.out.println("tetstststt");
        System.out.println(sb.toString());
       // sb.reverse();
        sb.insert(7, " zeynep ");

        System.out.println(sb.toString());
    }
}