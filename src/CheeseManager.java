import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheeseManager implements Iterable<Cheese> {
    List<Cheese> cheeseList = new ArrayList<>();
    int size;

    public CheeseManager(int size) {
        this.size = size;
    }

    public void add(Cheese c){
        cheeseList.add(c);
    }
    public void remove(int position){
        cheeseList.remove(position);
        size--;
    }
    @Override
    public Iterator<Cheese> iterator() {
        return cheeseList.iterator();
    }
}
