public class TestMain {
    public static void main(String args[]) {
        MyMaze list = new MyMaze(15, 20);
        list.makeGrid();
        list.setNeighbours();
        list.mazeGeneratorDepthFirstSearch();
        list.constraintCheck();
        list.displayRevealedGrid();
    }
}
