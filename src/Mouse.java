public class Mouse extends GameElement {
    private int x;
    private int y;
    private MazeCell currentCell;

    public MazeCell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Mouse(String name, String symbol) {
        super(name, symbol);
        x=1;
        y=1;
    }
    public void moveUp(){
        x = x-1;
    }
    public void moveDown(){
        x = x+1;
    }
    public void moveRight(){
        y = y+1;
    }
    public void moveLeft(){
        y = y-1;
    }

}
