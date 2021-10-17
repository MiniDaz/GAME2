import java.util.Scanner;

public class Game {
    private boolean gameIsOver=true;
    public  void startGame() throws InterruptedException {
        Knigth knigth=new Knigth(Main.name);
        Monster monster=new Monster();
        Storekeper storekeper=new Storekeper();
        Field field=new Field(Main.sizex,Main.sizey);
        field.fieldAdd();
       // field.setFildebel(knigth.getTochkaX(), knigth.getTochkaY(), knigth);
        field.setFildebel(monster.getTochkaX(), monster.getTochkaY(), monster);






        while (gameIsOver!=false){
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


            }
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
                    "  Def-"+ knigth.getDef()+ "  Money-"+knigth.getMoney());
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
            }
        }





    }

}
