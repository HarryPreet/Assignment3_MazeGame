import java.util.*;

public class MyMaze {
    private MazeCell[][] MazeGrid;
    private int height;
    private int width;

    public MyMaze(int height, int width) {
        this.height = height;
        this.width = width;
        MazeGrid = new MazeCell[height][width];
    }

    //2D array to represent the maze
    public MazeCell[][] getMazeGrid() {
        return MazeGrid;
    }

    public void setMazeGrid(MazeCell[][] mazeGrid) {
        MazeGrid = mazeGrid;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //Making grid of maze

    public void makeGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //Setting walls
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    MazeCell newCell = new MazeCell(i, j, "#","#");
                    MazeGrid[i][j] = newCell;
                }
                //Setting cells on which mouse, cat and cheese can be placed
                else {
                    MazeCell newCell = new MazeCell(i,j,"#",".");
                    MazeGrid[i][j] = newCell;
                }
            }

        }
        }
    //Display the entire maze with what they hold
    public void displayRevealedGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(MazeGrid[i][j]);
            }
            System.out.println();
        }
    }
    //Setting neighbours of a particular cell
    public void setNeighbours(){
        for(int i = 1; i < height-1; i++){
            for(int j =1; j<width-1; j++){
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i-1][j]);
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i][j+1]);
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i+1][j]);
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i][j-1]);
            }
        }
    }

    //Generating maze using iterative dfs

    public void mazeGeneratorDepthFirstSearch(){
        Stack<MazeCell> dfsStack= new Stack<>();
        MazeCellManager explored = new MazeCellManager();

        MazeCell initialCell = MazeGrid[1][1];
        explored.add(initialCell);
        dfsStack.push(initialCell);

        while (!dfsStack.isEmpty()){
            MazeCell current = dfsStack.pop();
            MazeCellManager possibleMoves = new MazeCellManager();
            for(MazeCell c : current.getNeighbours()) {
                if (!explored.isFound(c) && c.getMaskSymbol() == ".") {
                    possibleMoves.add(c);
                }
            }
            Random rand = new Random();
            if(possibleMoves.getSize()!=0){
                dfsStack.push(current);
                int randomChoice = rand.nextInt(possibleMoves.getSize());
                MazeCell chosen = possibleMoves.get(randomChoice);
                current.setActualSymbol(" ");
                explored.add(chosen);
                dfsStack.push(chosen);
            }
        }
    }

    //Constraints

}
