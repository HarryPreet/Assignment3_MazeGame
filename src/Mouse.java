//package GameLogic;

public class Mouse extends GameElement {
    private MazeCell currentCell;
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Mouse(String name, String symbol) {
        super(name, symbol);
    }

    public MazeCell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }

    public void moveMouse(MyMaze m, MazeCell current, Direction direction){
        current.setActualSymbol(" ");
        current.setMaskSymbol(" ");
        if(direction == Direction.UP) {
            current = m.getMazeGrid()[current.getX() - 1][current.getY()];
            current.setActualSymbol(this.getSymbol());
            current.setMaskSymbol(this.getSymbol());
            this.setCurrentCell(current);
        }
        else if (direction == Direction.DOWN){
            current = m.getMazeGrid()[current.getX() + 1][current.getY()];
            current.setActualSymbol(this.getSymbol());
            current.setMaskSymbol(this.getSymbol());
            this.setCurrentCell(current);
        }
        else if (direction == Direction.RIGHT){
            current = m.getMazeGrid()[current.getX()][current.getY() + 1];
            current.setActualSymbol(this.getSymbol());
            current.setMaskSymbol(this.getSymbol());
            this.setCurrentCell(current);
        }
        else if(direction == direction.LEFT){
            current = m.getMazeGrid()[current.getX()][current.getY()-1];
            current.setActualSymbol(this.getSymbol());
            current.setMaskSymbol(this.getSymbol());
            this.setCurrentCell(current);
        }

    }
}
