public class Boss implements Fieldebel{

    @Override
    public char Simbol() {
        return '#';
    }
    private int hp=100;
    private final int damage=5;
    private final int money=999999999;
    private final String name= "BOSS";
    private final int def=5;
    private int tochkaX=0;
    private int tochkaY=Main.sizey-1;
    private boolean isLive=true;

    public int getTochkaX() {
        return tochkaX;
    }

    public int getTochkaY() {
        return tochkaY;
    }

    public void isDead(){
        isLive=false;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
