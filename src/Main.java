import java.util.Scanner;

public class Main {
    static int sizex;
    static int sizey;
    static String name;
    public static void main(String[] args) throws InterruptedException {
        Options options=new Options();


    String str;
    Scanner scanner=new Scanner(System.in);
        System.out.println("выбирете имя героя");
        name=scanner.nextLine();
        System.out.println("выберите размер поля по оси Х(советую от 5 до 10)");
         sizex=scanner.nextInt();
        System.out.println("выберите размер поля по оси Y(советую от 5 до 10)");
         sizey= scanner.nextInt();

         options.showOptions();



}}
