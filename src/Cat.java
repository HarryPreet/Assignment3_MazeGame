//package GameLogic;

import java.util.Random;

public class Cat extends GameElement{

    private MazeCell currentCell;
    private MazeCell nextCell;

    //constructor
    public Cat(String name, String symbol) {
        super(name, symbol);
    }


    //getters
    public MazeCell getCurrentCell() {
        return currentCell;
    }
    public MazeCell getNextCell() {
        return nextCell;
    }


    //setters
    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }
    public void setNextCell(MazeCell nextCell) {
        this.nextCell = nextCell;
    }

    public int firstMove(){
        Random rand = new Random();
        return rand.nextInt(currentCell.getAvailableMoves().getSize());

    }

    public void moveCat(MyMaze m){
        Random rand = new Random();
        m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setActualSymbol(" ");
        m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setMaskSymbol(".");
        m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setActualSymbol(this.getSymbol());
        m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setCellElement(this);
        if(this.getNextCell().getAvailableMoves().getSize()==1){
            this.setCurrentCell(this.getNextCell());
            this.setNextCell(this.getNextCell().getAvailableMoves().get(0));
        }
        else {
            int nextRandomMove = rand.nextInt(this.getNextCell().getAvailableMoves().getSize());
            while (this.getNextCell().getAvailableMoves().get(nextRandomMove).getX() == this.getCurrentCell().getX() && this.getNextCell().getAvailableMoves().get(nextRandomMove).getY() == this.getCurrentCell().getY()) {
                nextRandomMove = rand.nextInt(this.getNextCell().getAvailableMoves().getSize());
            }
            this.setCurrentCell(this.getNextCell());
            this.setNextCell(this.getNextCell().getAvailableMoves().get(nextRandomMove));
        }
    }
}
