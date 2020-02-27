//package GameLogic;//Class to represent a cell in the maze

public class MazeCell {
    private int x;
    private int y;
    private String actualSymbol;        //Variable to hold what exactly is in the cell
    private String maskSymbol;          //Variable to display masked cells
    private MazeCellManager neighbours = new MazeCellManager();      //List to hold neighbours of a given cell
    private MazeCellManager availableMoves = new MazeCellManager();  //Available Cell to Move to
    private GameElement cellElement;

    //constructor
    public MazeCell(int x, int y, String actualSymbol, String maskSymbol) {
        this.x = x;
        this.y = y;
        this.actualSymbol = actualSymbol;
        this.maskSymbol = maskSymbol;
    }

    //getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getActualSymbol() {
        return actualSymbol;
    }
    public String getMaskSymbol() {
        return maskSymbol;
    }
    public MazeCellManager getNeighbours() {
        return neighbours;
    }
    public MazeCellManager getAvailableMoves() {
        return availableMoves;
    }
    public GameElement getCellElement() {
        return cellElement;
    }


    //setters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setActualSymbol(String actualSymbol) {
        this.actualSymbol = actualSymbol;
    }
    public void setMaskSymbol(String maskSymbol) {
        this.maskSymbol = maskSymbol;
    }
    public void setNeighbours(MazeCellManager neighbours) {
        this.neighbours = neighbours;
    }
    public void setAvailableMoves(MazeCellManager availableMoves) {
        this.availableMoves = availableMoves;
    }
    public void setCellElement(GameElement cellElement) {
        this.cellElement = cellElement;
    }


    @Override
    public String toString() {
        return actualSymbol;
    }
}
