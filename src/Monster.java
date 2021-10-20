public class Monster implements Fieldebel{

    private int hp=40;
    private final int damage=5;
    private final int money=15;
    private final String name= "Монстр 1";
    private final int def=0;
    private int tochkaX= Main.sizex/2;
    private int tochkaY=Main.sizey/2;
    private boolean isLive=true;
    public boolean setIsLive(){
        return isLive=true;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }

    public void isDead(){
        isLive=false;
    }

    public int getDef() {
        return def;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
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

    public int getTochkaX() {
        return tochkaX;
    }

    public int getTochkaY() {
        return tochkaY;
    }

    @Override
    public char Simbol() {
        return '?';
    }

}
