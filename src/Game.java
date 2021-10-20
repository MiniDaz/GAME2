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
        Boss boss=new Boss();
        Field field=new Field(Main.sizex,Main.sizey);
        field.fieldAdd();
       // field.setFildebel(knigth.getTochkaX(), knigth.getTochkaY(), knigth);
        field.setFildebel(monster.getTochkaX(), monster.getTochkaY(), monster);
        field.setFildebel(boss.getTochkaX(), boss.getTochkaY(), boss);
        field.setFildebel(goblin.getTochkaX(), storekeper.getTochkaY(), goblin);
        ArrayList<Object> bag=new ArrayList<>();







        while (gameIsOver!=false){
            if(knigth.getHp()<100){
                int hpInMoment= knigth.getHp();
                hpInMoment+=5;
                knigth.setHp(hpInMoment);
            }


            //BATTLE
            if(field.getFildebel(knigth.getTochkaX(), knigth.getTochkaY()) instanceof Boss){
                System.out.println("Ты нашел самое ужасное чудовище этого мира.Что же будешь делать?\n");
                System.out.println(knigth.getName()+": HP-"+ knigth.getHp()+ "  Damage-"+knigth.getDamage()+
                        "  Def-"+ knigth.getDef()+ "  Money-"+knigth.getMoney()+ " Банок здоровья-"+knigth.getAmountOfPotion());
                System.out.println(boss.getName()+": HP-"+ boss.getHp()+ "  Damage-"+boss.getDamage()+
                        "  Def-"+ boss.getDef()+ "  Money-"+boss.getMoney());
                System.out.println("\n 1.В атаку!\n" +
                        "2.Отступить");

                Scanner scanner=new Scanner(System.in);
                int q= scanner.nextInt();
                boolean battleOff=true;

                switch (q){
                    case 1:while (knigth.isLive()==true&&boss.isLive()==true&&battleOff==true){

                        System.out.println(" 1.Удар; 2.Применить зелье здоровья; 3. Отступить;");
                        int y=scanner.nextInt();

                        switch (y){

                            case 1:


                                int hpKnight= knigth.getHp()-(boss.getDamage()- knigth.getDef());
                            knigth.setHp(hpKnight);
                            int crit= random.nextInt(10);
                            int result;
                            if(crit>5){
                                result=2;
                                System.out.println("Ты нашел слабое место,следующий удар будет критичеким!");
                            }else {result=1;}

                            int hpBoss= boss.getHp()-(knigth.getDamage()*result - boss.getDef());
                            boss.setHp(hpBoss);
                                System.out.println(knigth.getName()+": HP-"+ knigth.getHp()+ "  Damage-"+knigth.getDamage()+
                                        "  Def-"+ knigth.getDef()+ "  Money-"+knigth.getMoney()+ " Банок здоровья-"+knigth.getAmountOfPotion());
                                System.out.println(boss.getName()+": HP-"+ boss.getHp()+ "  Damage-"+boss.getDamage()+
                                        "  Def-"+ boss.getDef()+ "  Money-"+boss.getMoney());
                                if (knigth.getHp()<=0||  boss.getHp()<=0){
                                    if (knigth.getHp()<=0){
                                        knigth.isDead();
                                        System.out.println("Вы умерли,попробуйте снова");
                                        break;
                                    }if(boss.getHp()<=0){
                                        boss.isDead();
                                        int moneyAfterBattle=knigth.getMoney()+boss.getMoney();
                                        knigth.setMoney(moneyAfterBattle);
                                        System.out.println("Поздравляю,вы выиграли!!!");
                                        gameIsOver=false;
                                        break;

                                    }

                                } break;
                            case 2: knigth.healsing();
                                System.out.println("HP увеличено на 40");break;

                            case 3:knigth.setTochkaX(knigth.getTochkaX());
                            battleOff=false; break;

                        }


                    }
                    case 2:knigth.setTochkaX(knigth.getTochkaX()+1);
                }
            }
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
                int x= random.nextInt(2,Main.sizex)-1;
                int y= random.nextInt(1,Main.sizey);

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
                int x= random.nextInt(2,Main.sizex)-1;
                int y= random.nextInt(1,Main.sizey);

                field.setFildebel(x, y,monster );
                monster.setIsLive();
                monster.setHp(40);

            }


            //BATTle over
            //Store
            if(field.getFildebel(knigth.getTochkaX(), knigth.getTochkaY()) instanceof Storekeper){
                int q=storekeper.sell();

                switch (q){
                    case 1:if(bag.contains(storekeper.sword)){
                        System.out.println(knigth.getName()+" , у тебя же есть меч,зачем тебе еще один?");

                    }else{
                        if(knigth.getMoney()>storekeper.sword.getCoats()){
                        int w= knigth.getDamage()+storekeper.sword.damagebel();
                        knigth.setDamage(w);
                        System.out.println("Damage увеличился на :"+storekeper.sword.damagebel()+"!");
                        int price= knigth.getMoney()-storekeper.sword.getCoats();
                        knigth.setMoney(price);

                        bag.add(storekeper.sword);}
                    else{
                            System.out.println("Поднакопи еще деньжат!");}
                    }break;
                    case 2: if(bag.contains(storekeper.guard)){
                        System.out.println(knigth.getName()+" , у тебя же есть броня,зачем тебе еще одна?");
                    }else {
                        if (knigth.getMoney() > storekeper.guard.getCoats()) {

                            int e = knigth.getDef() + storekeper.guard.defens();
                            knigth.setDef(e);
                            System.out.println("Def увеличился на :" + storekeper.guard.defens() + "!");
                            bag.add(storekeper.guard);
                            int price= knigth.getMoney()-storekeper.guard.getCoats();
                            knigth.setMoney(price);
                        }else {System.out.println("Поднакопи еще деньжат!");}
                    }break;
                    case 3: if(knigth.getMoney()>storekeper.potionOfHP.getCoast()){
                        int r= knigth.getAmountOfPotion()+1;

                        knigth.setAmountOfPotion(r);
                        int price= knigth.getMoney()-storekeper.potionOfHP.getCoast();
                        knigth.setMoney(price);
                    }break;
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
