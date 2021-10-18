import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Options {
    Game game=new Game();
    public void showOptions() throws InterruptedException {
        System.out.println("Добро пожаловать "+Main.name+"\n Введите номер раздела куда вы хотите отправится.");
        System.out.println("1.Начать игру.\n" +
                "2.Информация об игрею\n" +
                "3.Информация о создании игры.");
        Scanner scaner=new Scanner(System.in);
        int q=scaner.nextInt();



        switch ( q){
            case 1 :game.startGame();break;
            case 2:
                System.out.println("\n \nУправление в игре осуществляется при помощи клавиш w,a,s,d-передвижение, " +
                        "z-лечение, t-завершить игру\n" +
                        "в игре используются следующие обозначения:\n" +
                        "&-игрок\n" +
                        "$-торговец\n" +
                        "?- монстры\n" +
                        "#-бос,которого нужно победить\n");showOptions();break;
            case 3:
                System.out.println("\n\nПривет это моя вторая игра,первую можно посмотреть по ссылке:\n");showOptions();break;

        }
    }
}
