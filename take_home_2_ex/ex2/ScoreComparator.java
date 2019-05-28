import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y){
        return Integer.compare(y.getScore(), x.getScore());
    }
}