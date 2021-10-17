import java.util.Scanner;

public class Storekeper implements Fieldebel {
    private int tochkaX= Main.sizex-1;
    private int tochkaY=0;
    Sword sword=new Sword();
    PotionOfHP potionOfHP=new PotionOfHP();
    Guard guard=new Guard();

    public int getTochkaX() {
        return tochkaX;
    }

    public int getTochkaY() {
        return tochkaY;
    }

    public int sell(){
        System.out.println("Добро пожаловать в лавку. Что бы вы хотели купить?");
        System.out.println("1.Меч");
        System.out.println("2.Доспех");
        System.out.println("3.Зелье здоровья");
        System.out.println("4.ВЫйти из лавки");
        Scanner scanner=new Scanner(System.in);
        int q=scanner.nextInt();
        return q;

    }

    @Override
    public char Simbol() {
        return '$';
    }

}
