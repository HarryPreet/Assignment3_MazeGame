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
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][1].setMaskSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][1].setCellElement(cat1);
        cat1.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][1]);
        randomMove1 = cat1.firstMove();
        cat1.setNextCell(cat1.getCurrentCell().getAvailableMoves().get(randomMove1));

        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2].setMaskSymbol("!");
        MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2].setCellElement(cat2);
        cat2.setCurrentCell(MazeBoard.getMazeGrid()[MazeBoard.getHeight() - 2][MazeBoard.getWidth() - 2]);
        int randomMove2 = cat2.firstMove();
        cat2.setNextCell(cat2.getCurrentCell().getAvailableMoves().get(randomMove2));

        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth() - 2].setActualSymbol("!");
        MazeBoard.getMazeGrid()[1][MazeBoard.getWidth() - 2].setMaskSymbol("!");
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
            displayHiddenGrid(current, MazeBoard);
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
                        for (int i = 0; i < cheeses.getCheeseList().size(); ++i) {
                            if (MazeBoard.cheeseCheck(user, cheeses.getCheeseList().get(i))) {
                                cheeses.getCheeseList().remove(i);
                                noOfCheeseCollected++;
                                break;
                            }
                        }
                        if (noOfCheeseCollected == totalCheeseToCollect) {
                            displayRevealedGrid(MazeBoard);
                            System.out.println("Game Won");
                            return;
                        }

                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
                        if (MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1)) {
                            System.out.println("You Lose! Game Over!");
                            return;
                        }

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
                        for (int i = 0; i < cheeses.getCheeseList().size(); ++i) {
                            if (MazeBoard.cheeseCheck(user, cheeses.getCheeseList().get(i))) {
                                cheeses.getCheeseList().remove(i);
                                noOfCheeseCollected++;
                                break;
                            }
                        }
                        if (noOfCheeseCollected == totalCheeseToCollect) {
                            displayRevealedGrid(MazeBoard);
                            System.out.println("Game Won");
                            return;
                        }

                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
                        if (MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1)) {
                            System.out.println("You Lose! Game Over!");
                            displayRevealedGrid(MazeBoard);
                            return;
                        }
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
                        for (int i = 0; i < cheeses.getCheeseList().size(); ++i) {
                            if (MazeBoard.cheeseCheck(user, cheeses.getCheeseList().get(i))) {
                                cheeses.getCheeseList().remove(i);
                                noOfCheeseCollected++;
                                break;
                            }
                        }
                        if (noOfCheeseCollected == totalCheeseToCollect) {
                            displayRevealedGrid(MazeBoard);
                            System.out.println("Game Won");
                            return;
                        }

                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
                        if (MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1)) {
                            System.out.println("You Lose! Game Over!");
                            displayRevealedGrid(MazeBoard);
                            return;
                        }
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;
                case "a":
                    if (current.getAvailableMoves().isFound(MazeBoard.getMazeGrid()[x][y - 1])) {
                        current.setActualSymbol(" ");
                        current.setMaskSymbol(" ");
                        current = MazeBoard.getMazeGrid()[x][y - 1];
                        current.setActualSymbol(user.getSymbol());
                        current.setMaskSymbol(user.getSymbol());
                        user.setCurrentCell(current);
                        for (int i = 0; i < cheeses.getCheeseList().size(); ++i) {
                            if (MazeBoard.cheeseCheck(user, cheeses.getCheeseList().get(i))) {
                                cheeses.getCheeseList().remove(i);
                                noOfCheeseCollected++;
                                break;
                            }
                        }
                        if (noOfCheeseCollected == totalCheeseToCollect) {
                            displayRevealedGrid(MazeBoard);
                            System.out.println("Game Won");
                            return;
                        }
                        cat1.moveCat(MazeBoard);
                        cat2.moveCat(MazeBoard);
                        cat3.moveCat(MazeBoard);
                        if (MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1) && MazeBoard.lossCheck(user, cat1)) {
                            System.out.println("You Lose! Game Over!");
                            displayRevealedGrid(MazeBoard);
                            return;
                        }
                    } else {
                        System.out.println("Illegal Move!");
                    }
                    break;


                default:
                    System.out.println("Error");

            }
        }
    }

    public static void displayHiddenGrid(MazeCell Current, MyMaze MazeBoard) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == Current.getX() - 1 && j == Current.getY() - 1) || (i == Current.getX() - 1 && j == Current.getY()) || (i == Current.getX() - 1 && j == Current.getY() + 1) || (i == Current.getX() && j == Current.getY() - 1) || (i == Current.getX() && j == Current.getY()) || (i == Current.getX() && j == Current.getY() + 1) || (i == Current.getX() + 1 && j == Current.getY() - 1) || (i == Current.getX() + 1 && j == Current.getY()) || (i == Current.getX() + 1 && j == Current.getY() + 1)) {
                    MazeBoard.getMazeGrid()[i][j].setMaskSymbol(MazeBoard.getMazeGrid()[i][j].getActualSymbol());
                }
                System.out.print(MazeBoard.getMazeGrid()[i][j].getMaskSymbol());
            }
            System.out.println();
        }
    }

    public static void displayRevealedGrid(MyMaze MazeBoard) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(MazeBoard.getMazeGrid()[i][j].getMaskSymbol());
            }
            System.out.println();
        }
    }
}



