//package GameLogic;

public class Cat extends GameElement{

    private MazeCell previousCell;
    private MazeCell currentCell;
    private MazeCell nextCell;

    //constructor
    public Cat(String name, String symbol) {
        super(name, symbol);
    }


    //getters
    public MazeCell getPreviousCell() {
        return previousCell;
    }
    public MazeCell getCurrentCell() {
        return currentCell;
    }
    public MazeCell getNextCell() {
        return nextCell;
    }


    //setters
    public void setPreviousCell(MazeCell previousCell) {
        this.previousCell = previousCell;
    }
    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }
    public void setNextCell(MazeCell nextCell) {
        this.nextCell = nextCell;
    }
}
