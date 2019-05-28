import java.util.*;

public class Student {
    private static int x = 0;
    private String _name;
    private int _score;
    private int _rank;
    private int _order;

    public Student(String name, int score) {
        _name = name;
        _score = score;
        _order = x;
        x++;
    }

    public int getScore() {
        return _score;
    }

    public int getOrder() {
        return _order;
    }

    public int getRank() {
        return _rank;
    }

    public void setRank(int rank) {
        _rank = rank;
    }

    @Override
    public String toString() {
        return _name + " " + _rank;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Student) {
            Student b = (Student) other;
            return this._name.equals(b._name) && 
                this._score == b._score;
        }
        else 
            return false;
    }
}