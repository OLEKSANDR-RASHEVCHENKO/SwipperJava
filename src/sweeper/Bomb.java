package sweeper;

public class Bomb {
    private Matrix bombMap;
    private int totalBombe;

    Bomb(int totalBombe) {
        this.totalBombe = totalBombe;
    }
    public void start(){
        bombMap = new Matrix(Box.ZERO);
        for (int j = 0;j<totalBombe;j++){
            paceBomb();
        }
        paceBomb();


    }
    Box get (Coord coord){
        return bombMap.get(coord);
    }
    private void  paceBomb(){
        bombMap.set(Ranges.getRandomCoord(),Box.BOMB);

    }
}
