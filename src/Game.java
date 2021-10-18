import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private boolean gameIsOver=true;
    public  void startGame() throws InterruptedException {
         Random random=new Random();
        Knigth knigth=new Knigth(Main.name);
        Monster monster=new Monster();
        Goblin goblin=new Goblin();
        Storekeper storekeper=new Storekeper();
        Field field=new Field(Main.sizex,Main.sizey);
        field.fieldAdd();
       // field.setFildebel(knigth.getTochkaX(), knigth.getTochkaY(), knigth);
        field.setFildebel(monster.getTochkaX(), monster.getTochkaY(), monster);
        field.setFildebel(2, 5, goblin);







        while (gameIsOver!=false){


            //BATTLE
            if(field.getFildebel(knigth.getTochkaX(), knigth.getTochkaY()) instanceof Goblin){
                while (knigth.isLive()==true&& goblin.isLive()==true){
                    Thread.sleep(1000);
                    System.out.println("----------------------------------------");
                    System.out.println(knigth.getName()+": HP-"+ knigth.getHp()+ "  Damage-"+knigth.getDamage()+
                            "  Def-"+ knigth.getDef()+ "  Money-"+knigth.getMoney());
                    System.out.println(goblin.getName()+": HP-"+ goblin.getHp()+ "  Damage-"+monster.getDamage()+
                            "  Def-"+ goblin.getDef()+ "  Money-"+goblin.getMoney());
                    int knightHp= knigth.getHp();
                    knightHp=knightHp- monster.getDamage()+knigth.getDef();
                    knigth.setHp(knightHp);
                    int monsterHp= goblin.getHp();
                    monsterHp=monsterHp-knigth.getDamage()+goblin.getDef();
                    goblin.setHp(monsterHp);
                    if (knigth.getHp()<=0||  goblin.getHp()<=0){
                        if (knigth.getHp()<=0){
                            knigth.isDead();
                        }else {
                            goblin.isDead();
                            int moneyAfterBattle=knigth.getMoney()+goblin.getMoney();
                            knigth.setMoney(moneyAfterBattle);

                        }

                    }

                }
                int x= random.nextInt(1,Main.sizex)-1;
                int y= random.nextInt(Main.sizey);
                field.setFildebel(x, y,goblin );
                goblin.setIsLive();
                goblin.setHp(100);

            }

            if(field.getFildebel(knigth.getTochkaX(), knigth.getTochkaY()) instanceof Monster){
                while (knigth.isLive()==true&& monster.isLive()==true){
                    Thread.sleep(1000);
                    System.out.println("----------------------------------------");
                System.out.println(knigth.getName()+": HP-"+ knigth.getHp()+ "  Damage-"+knigth.getDamage()+
                        "  Def-"+ knigth.getDef()+ "  Money-"+knigth.getMoney());
                System.out.println(monster.getName()+": HP-"+ monster.getHp()+ "  Damage-"+monster.getDamage()+
                        "  Def-"+ monster.getDef()+ "  Money-"+monster.getMoney());
                int knightHp= knigth.getHp();
                knightHp=knightHp- monster.getDamage()+knigth.getDef();
                knigth.setHp(knightHp);
                int monsterHp= monster.getHp();
                monsterHp=monsterHp-knigth.getDamage()+monster.getDef();
                monster.setHp(monsterHp);
                if (knigth.getHp()<=0||  monster.getHp()<=0){
                    if (knigth.getHp()<=0){
                        knigth.isDead();
                    }else {
                        monster.isDead();
                        int moneyAfterBattle=knigth.getMoney()+monster.getMoney();
                        knigth.setMoney(moneyAfterBattle);

                    }

                }

                }
                int x= random.nextInt(1,Main.sizex)-1;
                int y= random.nextInt(Main.sizey);
                field.setFildebel(x, y,monster );
                monster.setIsLive();
                monster.setHp(40);

            }


            //BATTle over
            //Store
            if(field.getFildebel(knigth.getTochkaX(), knigth.getTochkaY()) instanceof Storekeper){
                int q=storekeper.sell();

                switch (q){
                    case 1:int w= knigth.getDamage()+storekeper.sword.damagebel();
                        knigth.setDamage(w);
                        System.out.println("Damage увеличился на :"+storekeper.sword.damagebel()+"!");break;
                    case 2: int e= knigth.getDef()+ storekeper.guard.defens();
                                knigth.setDef(e);System.out.println("Def увеличился на :"+storekeper.guard.defens()+"!");break;
                    case 3: int r= knigth.getAmountOfPotion()+1;
                        knigth.setAmountOfPotion(r);break;
                    case 4:break;
                }
                knigth.setTochkaX(knigth.getTochkaX()-1);


            }
            field.setFildebel(knigth.getTochkaX(), knigth.getTochkaY(), knigth);
            field.setFildebel(storekeper.getTochkaX(), storekeper.getTochkaY(), storekeper);
            System.out.println();
            System.out.println();
            System.out.println(knigth.getName()+": HP-"+ knigth.getHp()+ "  Damage-"+knigth.getDamage()+
                    "  Def-"+ knigth.getDef()+ "  Money-"+knigth.getMoney()+" Банок здоровья"+knigth.getAmountOfPotion());
            field.ShowField();
            field.setFildebel(knigth.getTochkaX(), knigth.getTochkaY(), field.empti);
            Scanner sc=new Scanner(System.in);
            String in =sc.nextLine();
            switch (in){
                case "w":
                    knigth.goUp();
                    break;
                case "s": knigth.goDown();
                    break;
                case "d":knigth.goRight();
                    break;
                case "a":knigth.goLeft();
                    break;
                case "t": gameIsOver=false;
                case "z":knigth.healsing();
            }
        }





    }

}
