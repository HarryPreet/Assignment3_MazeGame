public class Cat extends GameElement{

    private MazeCell previousCell;
    private MazeCell currentCell;

    public MazeCell getNextCell() {
        return nextCell;
    }

    public void setNextCell(MazeCell nextCell) {
        this.nextCell = nextCell;
    }

    private MazeCell nextCell;

    public MazeCell getPreviousCell() {
        return previousCell;
    }

    public void setPreviousCell(MazeCell previousCell) {
        this.previousCell = previousCell;
    }


    public MazeCell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }
    public Cat(String name, String symbol) {
        super(name, symbol);
    }

}
