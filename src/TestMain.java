//package GameLogic;

import java.util.Random;
import java.util.Scanner;

public class TestMain {
    private static int noOfCheeseCollected = 0;
    private static int totalCheeseToCollect = 5;
    private final static int height = 15;
    private final static int width = 20;


    public static void main(String[] args) {
        MyMaze MazeBoard = new MyMaze(height, width);
        MazeBoard.makeGrid();
        MazeBoard.setNeighbours();
        MazeBoard.mazeGeneratorDepthFirstSearch();
        MazeBoard.constraintCheck();
        MazeBoard.setMoves();
        Random rand = new Random();
        int randomMove1;
        CheeseManager cheeses = new CheeseManager(5);

        Mouse user = new Mouse("Mouse", "@");

        MazeCell current = MazeBoard.getMazeGrid()[1][1];
        current.setCellElement(user);
        current.setActualSymbol(user.getSymbol());
        current.setMaskSymbol(user.getSymbol());
        user.setCurrentCell(current);

        Cat cat1 = new Cat("Cat", "!");
        Cat cat2 = new Cat("Cat", "!");
        Cat cat3 = new Cat("Cat", "!");


        //Setting positions of Cats
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][1].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][1].setCellElement(cat1);
        cat1.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][1]);
        randomMove1 = cat1.firstMove();
        cat1.setNextCell(cat1.getCurrentCell().getAvailableMoves().get(randomMove1));

        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2].setCellElement(cat2);
        cat2.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2]);
        int randomMove2 = cat2.firstMove();
        cat2.setNextCell(cat2.getCurrentCell().getAvailableMoves().get(randomMove2));

        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth() - 2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth() - 2].setCellElement(cat3);
        cat3.setCurrentCell(MazeBoard.getMazeGrid()[1][MazeBoard.getWidth() - 2]);
        int randomMove3 = cat3.firstMove();
        cat3.setNextCell(cat3.getCurrentCell().getAvailableMoves().get(randomMove3));


        for (int i = 0; i < 5; i++) {
            Cheese cheese = new Cheese("Cheese", "$");
            cheese.placeCheese(MazeBoard);
            cheeses.add(cheese);
        }
        MazeBoard.setMoves();


        Scanner input = new Scanner(System.in);

        while (true) {
            MazeBoard.displayRevealedGrid();
            System.out.println("Cheese collected: " + noOfCheeseCollected + " of " + totalCheeseToCollect);
            System.out.println("Enter your move [WASD?]: ");
            String move = input.nextLine();
            move = move.toLowerCase();

            int x = current.getX();
            int y = current.getY();


            switch (move) {
                case "w":
                    System.out.println("Case w");
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x - 1][y])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x - 1][y];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                        for (Cheese c : cheeses) {
                            if (MazeBoard.cheeseCheck(user, c)) {
                                noOfCheeseCollected++;
                            }
                        }
                        if (noOfCheeseCollected == 5) {
                            MazeBoard.displayRevealedGrid();
                            System.out.println("Game Won");
                        }

                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);

                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;

                case "s":
                    System.out.println("Case s");
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x + 1][y])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x + 1][y];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                        for (Cheese c : cheeses) {
                            if (MazeBoard.cheeseCheck(user, c)) {
                                noOfCheeseCollected++;
                            }
                        }
                        if (noOfCheeseCollected == 5) {
                            MazeBoard.displayRevealedGrid();
                            System.out.println("Game Won");
                        }

                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;

                case "d":
                    System.out.println("Case d");
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x][y + 1])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x][y + 1];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                        for (Cheese c : cheeses) {
                            if (MazeBoard.cheeseCheck(user, c)) {
                                noOfCheeseCollected++;
                            }
                        }
                        if (noOfCheeseCollected == 5) {
                            MazeBoard.displayRevealedGrid();
                            System.out.println("Game Won");
                            return;
                        }

                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;
                case "a":
                    System.out.println("Case a");
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x][y - 1])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x][y - 1];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                        for (Cheese c : cheeses) {
                            if (MazeBoard.cheeseCheck(user, c)) {
                                noOfCheeseCollected++;
                            }
                        }
                        if (noOfCheeseCollected == 5) {
                            MazeBoard.displayRevealedGrid();
                            System.out.println("Game Won");
                        }
                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
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


