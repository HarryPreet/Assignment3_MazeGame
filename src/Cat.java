

import java.util.Random;

public class Cat extends GameElement {

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

    //setters
    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }

    public MazeCell getNextCell() {
        return nextCell;
    }

    public void setNextCell(MazeCell nextCell) {
        this.nextCell = nextCell;
    }

    public int firstMove() {
        Random rand = new Random();
        return rand.nextInt(currentCell.getAvailableMoves().getSize());

    }

    public void moveCat(MyMaze m) {

        Random rand = new Random();
        if ("$!".equals(m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].getActualSymbol())) {
            m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setActualSymbol("$");
            m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setMaskSymbol(".");
        } else {
            m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setActualSymbol(" ");
            m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setMaskSymbol(".");
        }
        if (m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].getActualSymbol().equals("$")) {
            m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setActualSymbol("$!");

        } else m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setActualSymbol(this.getSymbol());
        m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setCellElement(this);
        if (this.getNextCell().getAvailableMoves().getSize() == 1) {
            this.setCurrentCell(this.getNextCell());
            this.setNextCell(this.getNextCell().getAvailableMoves().get(0));
            m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setActualSymbol("!");
            m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setMaskSymbol("!");
        } else {
            int nextRandomMove = rand.nextInt(this.getNextCell().getAvailableMoves().getSize());
            if (this.getNextCell().getAvailableMoves().get(nextRandomMove).getX() == this.getCurrentCell().getX() && this.getNextCell().getAvailableMoves().get(nextRandomMove).getY() == this.getCurrentCell().getY()) {
                for (MazeCell cell : this.getNextCell().getAvailableMoves()) {
                    if (cell.getX() != this.getCurrentCell().getX() || cell.getY() != this.getCurrentCell().getY()) {
                        this.setCurrentCell(this.getNextCell());
                        this.setNextCell(cell);
                        m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setActualSymbol("!");
                        m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setMaskSymbol("!");
                        return;

                    }
                }
            }
            this.setCurrentCell(this.getNextCell());
            this.setNextCell(this.getNextCell().getAvailableMoves().get(nextRandomMove));
            m.getMazeGrid()[this.getNextCell().getX()][this.getNextCell().getY()].setActualSymbol("!");
            m.getMazeGrid()[this.getCurrentCell().getX()][this.getCurrentCell().getY()].setMaskSymbol("!");
        }
    }

}
