import java.util.Scanner;

public class Main {
    static int sizex;
    static int sizey;
    static String name;
    public static void main(String[] args) throws InterruptedException {
        Game game=new Game();


    String str;
    Scanner scanner=new Scanner(System.in);
        System.out.println("выбирете имя героя");
        name=scanner.nextLine();
        System.out.println("выберите размер поля по оси Х");
         sizex=scanner.nextInt();
        System.out.println("выберите размер поля по оси Y");
         sizey= scanner.nextInt();

         game.startGame();



}}
