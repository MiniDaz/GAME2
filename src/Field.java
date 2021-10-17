public class Field {
    public  int sizeX;
    public int sizeY;

    private Fieldebel[][] field;
    Empti empti=new Empti();

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Fieldebel[][] getField() {
        return field;
    }



    public Field(int sizeX, int sizeY){
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        field =new Fieldebel[sizeX][sizeY];
    }



    public void fieldAdd(){
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                field[i][j]=empti;

            }

        }

    }
    public void setFildebel(int x,int y,Fieldebel object){
        field[x][y]=object;
    }
    public Fieldebel getFildebel(int x,int y){
        return field[x][y];
    }



    public void ShowField(){
        for (int i = 0; i <sizeX; i++) {
            for (int j = 0; j <sizeY ; j++) {
                System.out.print(field[i][j].Simbol());
            }
            System.out.println();
        }
    }
}
