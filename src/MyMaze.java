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
                    MazeCell newCell = new MazeCell(i, j, "#", "#");
                    MazeGrid[i][j] = newCell;
                }
                //Setting cells on which mouse, cat and cheese can be placed
                else {
                    MazeCell newCell = new MazeCell(i, j, "#", ".");
                    MazeGrid[i][j] = newCell;
                }
            }

        }
    }

    //Display the entire maze with what they hold
    //Should remove this in final submission
    public void displayRevealedGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(MazeGrid[i][j]);
            }
            System.out.println();
        }
    }

    public void displayHiddenGrid(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(MazeGrid[i][j].getMaskSymbol());
            }
            System.out.println();
        }
    }

    //Setting neighbours of a particular cell
    public void setNeighbours() {
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i - 1][j]);
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i][j + 1]);
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i + 1][j]);
                MazeGrid[i][j].getNeighbours().add(MazeGrid[i][j - 1]);
            }
        }
    }

    //Generating maze using iterative dfs


    public void mazeGeneratorDepthFirstSearch() {
        Stack<MazeCell> dfsStack = new Stack<>();
        MazeCellManager explored = new MazeCellManager();

        MazeCell initialCell = MazeGrid[1][1];
        explored.add(initialCell);
        dfsStack.push(initialCell);
        while (!dfsStack.isEmpty()) {
            MazeCell current = dfsStack.pop();
            MazeCellManager possibleMoves = new MazeCellManager();
            for (MazeCell c : current.getNeighbours()) {
                if (!explored.isFound(c) && c.getMaskSymbol().equals(".")) {
                    possibleMoves.add(c);
                }
            }
            Random rand = new Random();
            if (possibleMoves.getSize() != 0) {
                dfsStack.push(current);
                int randomChoice = rand.nextInt(possibleMoves.getSize());
                MazeCell chosen = possibleMoves.get(randomChoice);
                current.setActualSymbol(" ");
                explored.add(chosen);
                dfsStack.push(chosen);
            }
        }
    }

    //Add Constraints

    //1. No walls at corners
    public void removeWallsAtCorners() {
        if (MazeGrid[1][1].getActualSymbol().equals("#")) {
            MazeGrid[1][1].setActualSymbol(" ");
        }
        if (MazeGrid[height - 2][1].getActualSymbol().equals("#")) {
            MazeGrid[height - 2][1].setActualSymbol(" ");
        }
        if (MazeGrid[1][width - 2].getActualSymbol().equals("#")) {
            MazeGrid[1][width - 2].setActualSymbol(" ");
        }
        if (MazeGrid[height - 2][width - 2].getActualSymbol().equals("#")) {
            MazeGrid[height - 2][width - 2].setActualSymbol(" ");
        }
    }

    //2*2 constraint check
    public boolean check2By2() {
        for (int i = 1; i < height - 2; i = i + 1) {
            for (int j = 1; j < width - 2; j = j + 1) {
                if (MazeGrid[i][j].getActualSymbol().equals("#") && MazeGrid[i][j + 1].getActualSymbol().equals("#") && MazeGrid[i + 1][j].getActualSymbol().equals("#") && MazeGrid[i + 1][j + 1].getActualSymbol().equals("#"))
                    return true;
                if (MazeGrid[i][j].getActualSymbol().equals(" ") && MazeGrid[i][j + 1].getActualSymbol().equals(" ") && MazeGrid[i + 1][j].getActualSymbol().equals(" ") && MazeGrid[i + 1][j + 1].getActualSymbol().equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add2By2Constraint() {
        for (int i = 1; i < height - 2; i = i + 1) {
            int j;
            for (j = 1; j < width - 2; j = j + 1) {
                if (MazeGrid[i][j].getActualSymbol().equals("#") && MazeGrid[i][j + 1].getActualSymbol().equals("#") && MazeGrid[i + 1][j].getActualSymbol().equals("#") && MazeGrid[i + 1][j + 1].getActualSymbol().equals("#")) {
                    MazeGrid[i][j].setActualSymbol(" ");
                }
                if (MazeGrid[i][j].getActualSymbol().equals(" ") && MazeGrid[i][j + 1].getActualSymbol().equals(" ") && MazeGrid[i + 1][j].getActualSymbol().equals(" ") && MazeGrid[i + 1][j + 1].getActualSymbol().equals(" ")) {
                    MazeGrid[i][j].setActualSymbol("#");
                }
            }
        }
    }

    public void removeWalls() {
        for (int i = 1; i < height - 1; ++i) {
            for (int j = 1; j < width - 1; j++) {
                if (MazeGrid[i][j].getActualSymbol().equals("#")) {
                    MazeGrid[i][j].setActualSymbol(" ");
                    if (check2By2()) {
                        MazeGrid[i][j].setActualSymbol("#");
                    }
                }
            }
        }
    }

    public void constraintCheck() {
        removeWallsAtCorners();
        while (check2By2()) {
            add2By2Constraint();
        }
        removeWalls();
    }

    public void setMoves(){
        for (int i = 1; i < height - 1; ++i) {
            for (int j = 1; j < width - 1; j++) {
               for(MazeCell c : MazeGrid[i][j].getNeighbours()){
                   if(c.getActualSymbol()==" "){
                       MazeGrid[i][j].getAvailableMoves().add(c);
                   }
               }

            }
        }
    }


}
