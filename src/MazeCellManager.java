import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List Implementation of MazeCells

public class MazeCellManager implements Iterable<MazeCell> {


    List<MazeCell> MazeList = new ArrayList<>();
    int size;

    public MazeCellManager() {
        size=0;
    }


    public List<MazeCell> getMazeList() {
        return MazeList;
    }

    public void setMazeList(List<MazeCell> mazeList) {
        MazeList = mazeList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(MazeCell cell){
        MazeList.add(cell);
        size++;
    }
    public void remove(MazeCell cell){
        MazeList.remove(cell);
    }
    public MazeCell get(int position){
        return MazeList.get(position);
    }
    public boolean isFound(MazeCell cell){
        return MazeList.contains(cell);
    }
    public boolean isEmpty(){
        return MazeList.isEmpty();
    }
    @Override
    public Iterator<MazeCell> iterator() {
        return MazeList.iterator();
    }
}
