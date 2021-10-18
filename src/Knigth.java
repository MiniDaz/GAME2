public class Knigth implements Fieldebel {
    private int hp=100;
    private int damage=10;
    private int money=0;
    private String name;
    private int def=0;
    private int tochkaX= 1;
    private int tochkaY=1;
    private boolean isLive=true;
    private int amountOfPotion=1;
    public void healsing(){
        if(amountOfPotion>0){
            hp+=40;
            amountOfPotion-=1;
            if(hp>100){
                hp=100;
            }
        }
    }

    public void setAmountOfPotion(int amountOfPotion) {
        this.amountOfPotion = amountOfPotion;
    }

    public int getAmountOfPotion() {
        return amountOfPotion;
    }

    public void isDead(){
        isLive=false;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setTochkaX(int tochkaX) {
        this.tochkaX = tochkaX;
    }

    public void setTochkaY(int tochkaY) {
        this.tochkaY = tochkaY;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isLive() {
        return isLive;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getDef() {
        return def;
    }



    public Knigth(String name) {
        this.name = name;
    }



    @Override
    public char Simbol() {
        return '&';
    }

    public int getTochkaX() {
        return tochkaX;
    }

    public int getTochkaY() {
        return tochkaY;
    }
    public  void goUp(){
        if(tochkaX==0){
            tochkaX+=Main.sizex-1;
        }else{
        tochkaX-=1;}
    }
    public  void goDown(){
        if(tochkaX==Main.sizex-1){
            tochkaX-=Main.sizex-1;

        }else{
            tochkaX+=1;
        }

    }
    public  void goLeft(){
        if(tochkaY==0){
            tochkaY+=Main.sizey-1;


        }else{
            tochkaY-=1;
        }

    }
    public  void goRight(){
        if(tochkaY==Main.sizey-1){
            tochkaY-=Main.sizey-1;
        }else {
            tochkaY+=1;
        }

    }
}
