import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class TestMain {
    public static void main(String args[]) {
        MyMaze MazeBoard = new MyMaze(15, 20);
        MazeBoard.makeGrid();
        MazeBoard.setNeighbours();
        MazeBoard.mazeGeneratorDepthFirstSearch();
        MazeBoard.constraintCheck();
        MazeBoard.setMoves();
        Mouse user = new Mouse("Mouse", "@");
        user.setX(1);
        user.setY(1);
        MazeBoard.getMazeGrid()[1][1].setCellElement(user);
        MazeBoard.getMazeGrid()[1][1].setActualSymbol(user.getSymbol());
        MazeBoard.getMazeGrid()[1][1].setMaskSymbol(user.getSymbol());

        MazeCell current = MazeBoard.getMazeGrid()[1][1];
        user.setCurrentCell(current);


        Scanner input = new Scanner(System.in);
        while(true) {
            MazeBoard.displayRevealedGrid();
            String move = input.nextLine();
            move = move.toLowerCase();

            int x = current.getX();
            int y = current.getY();

            for(MazeCell c : current.getAvailableMoves()){
                System.out.println(c.getX() + ","+c.getY());
            }

            switch (move) {
                case "w":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x - 1][y])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x - 1][y];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;

                case "s":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x + 1][y])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x + 1][y];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;

                case "d":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x][y + 1])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x][y + 1];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;
                case "a":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x][y - 1])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x][y-1];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;
                default:
                    System.out.println("Error");


            }
        }
    }
}
