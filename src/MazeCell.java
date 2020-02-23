
//Class to represent a cell in the maze


public class MazeCell {
    private int x;
    private int y;
    //Variable to hold what exactly is in the cell
    private String actualSymbol;
    //Variable to display masked cells
    private String maskSymbol;
    //List to hold neighbours of a given cell
    private MazeCellManager neighbours = new MazeCellManager();
    //Available Moves
    private MazeCellManager availableMoves = new MazeCellManager();

    private GameElement cellElement;

    public GameElement getCellElement() {
        return cellElement;
    }

    public void setCellElement(GameElement cellElement) {
        this.cellElement = cellElement;
    }

    public MazeCellManager getAvailableMoves() {
        return availableMoves;
    }

    public void setAvailableMoves(MazeCellManager availableMoves) {
        this.availableMoves = availableMoves;
    }



    public String getMaskSymbol() {
        return maskSymbol;
    }

    public void setMaskSymbol(String maskSymbol) {
        this.maskSymbol = maskSymbol;
    }

    public MazeCellManager getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(MazeCellManager neighbours) {
        this.neighbours = neighbours;
    }


    public MazeCell(int x, int y, String actualSymbol, String maskSymbol) {
        this.x = x;
        this.y = y;
        this.actualSymbol = actualSymbol;
        this.maskSymbol = maskSymbol;
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

    public String getActualSymbol() {
        return actualSymbol;
    }

    public void setActualSymbol(String actualSymbol) {
        this.actualSymbol = actualSymbol;
    }

    @Override
    public String toString() {
        return actualSymbol;
    }
}
