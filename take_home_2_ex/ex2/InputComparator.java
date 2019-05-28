import java.util.Comparator;

public class InputComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y){
        return Integer.compare(x.getOrder(), y.getOrder());
    }
}