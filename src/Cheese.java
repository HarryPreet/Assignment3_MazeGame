import java.util.Random;

public class Cheese extends GameElement{
    public MazeCell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(MazeCell currentCell) {
        this.currentCell = currentCell;
    }

    private MazeCell currentCell;

    public Cheese(String name, String symbol) {
        super(name, symbol);
    }

    public void placeCheese(MyMaze m){

        Random rand  = new Random();
        int xPosition = rand.nextInt(m.getHeight()-2)+1;
        int yPosition = rand.nextInt(m.getWidth()-2)+1;

        while((xPosition==1 && yPosition==1) || (xPosition==1 && yPosition == m.getWidth()-2) || (xPosition == m.getHeight()-2 && yPosition == m.getWidth()-2) || (xPosition == 1 && yPosition ==m.getWidth()-2) || m.getMazeGrid()[xPosition][yPosition].getActualSymbol()==" " ||m.getMazeGrid()[xPosition][yPosition].getActualSymbol()=="$") {
            xPosition = rand.nextInt(m.getHeight() - 2) + 1;
            yPosition = rand.nextInt(m.getWidth() - 2) + 1;
        }
        currentCell = m.getMazeGrid()[xPosition][yPosition];
        m.getMazeGrid()[xPosition][yPosition].setActualSymbol(this.getSymbol());
        m.getMazeGrid()[xPosition][yPosition].setMaskSymbol(this.getSymbol());
    }

}