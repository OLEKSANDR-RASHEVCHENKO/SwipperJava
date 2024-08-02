package sweeper;

public class Bomb {
    private Matrix bombMap;
    private int totalBombe;

    Bomb(int totalBombe) {
        this.totalBombe = totalBombe;
        fixBombsCount();
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
    int getTotalBombs(){
        return  totalBombe;
    }
    private void  fixBombsCount(){
        int maxBomb = Ranges.getSize().x * Ranges.getSize().y/2;
        if ( totalBombe > maxBomb)
            totalBombe = maxBomb;
    }
    private void  paceBomb(){
        while (true) {
            Coord coord = Ranges.getRandomCoord();
            if (Box.BOMB==bombMap.get(coord))
                continue;
            bombMap.set(coord, Box.BOMB);
            incNumbersAroundBomb(coord);
            break;
        }

    }

    private void incNumbersAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordsAround(coord))
            if (Box.BOMB!=bombMap.get(around))
            bombMap.set(around,bombMap.get(around).nextNumberBox());
    }
}
