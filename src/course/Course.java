package course;

import dao.Entity;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
public class Course extends Entity<Long>{
    private String name;
    private Turn turn;

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public Class<Long> getIdClass() {
        return Long.class;
    }

    @Override
    public String toString() {
        return name;
    }
}
