//package GameLogic;

public class Mouse extends GameElement {
    private MazeCell currentCell;

    public Mouse(String name, String symbol) {
        super(name, symbol);
    }

    public MazeCell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }
}
