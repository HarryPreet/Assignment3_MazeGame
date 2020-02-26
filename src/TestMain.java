//package GameLogic;

import org.w3c.dom.ls.LSInput;

import java.util.Random;
import java.util.Scanner;

public class TestMain {
    private static int noOfCheeseCollected = 0;
    private static int totalCheeseToCollect = 5;
    private final static int height = 15;
    private final static int width = 20;

    public static void main(String[] args) {
        MyMaze MazeBoard = new MyMaze(height,width);
        MazeBoard.makeGrid();
        MazeBoard.setNeighbours();
        MazeBoard.mazeGeneratorDepthFirstSearch();
        MazeBoard.constraintCheck();
        MazeBoard.setMoves();

        Mouse user = new Mouse("Mouse", "@");

        MazeCell current = MazeBoard.getMazeGrid()[1][1];
        current.setCellElement(user);
        current.setActualSymbol(user.getSymbol());
        current.setMaskSymbol(user.getSymbol());
        user.setCurrentCell(current);

        Cat cat1 = new Cat("Cat","!");
        Cat cat2 = new Cat("Cat","!");
        Cat cat3 = new Cat("Cat","!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1].setCellElement(cat1);
        cat1.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);
        cat1.setPreviousCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);
        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth()-2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth()-2].setCellElement(cat2);
        cat2.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);
        cat2.setPreviousCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);
        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2].setCellElement(cat3);
        cat3.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2]);
        cat3.setPreviousCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2]);

        Random rand = new Random();
        int xPosition = rand.nextInt(width - 2) + 1;
        int yPosition = rand.nextInt(height - 2) + 1;
        MazeCell cheese = new MazeCell(xPosition,yPosition,"$", "$");
        //Cheese cheese  = new Cheese(xPosition,  yPosition);

        int randPosX = rand.nextInt(width-1);
        int randPosY = rand.nextInt(height-1);
        MazeBoard.getMazeGrid()[randPosX][randPosY].setActualSymbol("$");

        Scanner input = new Scanner(System.in);

        while(true) {
            MazeBoard.displayRevealedGrid();
            System.out.println("Cheese collected: " + noOfCheeseCollected + " of " + totalCheeseToCollect);
            System.out.println("Enter your move [WASD?]: ");
            String move = input.nextLine();
            move = move.toLowerCase();

            int x = current.getX();
            int y = current.getY();


            switch (move) {
                case "w":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x - 1][y])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x - 1][y];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                        /*cat1.setNextCell(cat1.getCurrentCell().getAvailableMoves().get(rand.nextInt(cat1.getCurrentCell().getAvailableMoves().getSize())));
                        cat1.getNextCell().getAvailableMoves().remove(cat1.getCurrentCell());
                        cat1.setCurrentCell(cat1.getNextCell());
                        MazeBoard.getMazeGrid()[cat1.getNextCell().getX()][cat1.getNextCell().getY()].setActualSymbol(cat1.getSymbol());*/

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

/*import org.w3c.dom.ls.LSInput;

import java.util.Random;
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
        MazeBoard.getMazeGrid()[1][1].setCellElement(user);
        MazeBoard.getMazeGrid()[1][1].setActualSymbol(user.getSymbol());
        MazeBoard.getMazeGrid()[1][1].setMaskSymbol(user.getSymbol());

        Cat cat1 = new Cat("Cat","!");
        Cat cat2 = new Cat("Cat","!");
        Cat cat3 = new Cat("Cat","!");

        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1].setCellElement(cat1);
        cat1.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);
        cat1.setPreviousCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);


        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth()-2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth()-2].setCellElement(cat2);
        cat2.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);
        cat2.setPreviousCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][1]);

        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2].setCellElement(cat3);
        cat3.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2]);
        cat3.setPreviousCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight()-2][MazeBoard.getWidth()-2]);

        Random rand = new Random();

        MazeCell current = MazeBoard.getMazeGrid()[1][1];
        user.setCurrentCell(current);

        Scanner input = new Scanner(System.in);
        while(true) {
            MazeBoard.displayRevealedGrid();
            String move = input.nextLine();
            move = move.toLowerCase();

            int x = current.getX();
            int y = current.getY();


            switch (move) {
                case "w":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x - 1][y])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x - 1][y];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);

                        cat1.setNextCell(cat1.getCurrentCell().getAvailableMoves().get(rand.nextInt(cat1.getCurrentCell().getAvailableMoves().getSize())));
                        cat1.getNextCell().getAvailableMoves().remove(cat1.getCurrentCell());
                        cat1.setCurrentCell(cat1.getNextCell());
                        MazeBoard.getMazeGrid()[cat1.getNextCell().getX()][cat1.getNextCell().getY()].setActualSymbol(cat1.getSymbol());

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
*/