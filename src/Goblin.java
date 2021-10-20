public class Goblin  implements Fieldebel{
    private int hp=100;
    private final int damage=10;
    private final int money=30;
    private final String name= "Goblin";
    private final int def=0;
    private int tochkaX=(int) (Main.sizex/2+Main.sizex/3);
    private int tochkaY=(int)(Main.sizey/2+Main.sizey/3);
    private boolean isLive=true;
    public void isDead(){
        isLive=false;
    }
    public boolean setIsLive(){
       isLive=true;
       return isLive;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getTochkaX() {
        return tochkaX;
    }

    public void setTochkaX(int tochkaX) {
        this.tochkaX = tochkaX;
    }

    public int getTochkaY() {
        return tochkaY;
    }

    public void setTochkaY(int tochkaY) {
        this.tochkaY = tochkaY;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public char Simbol() {
        return '*';
    }
}
