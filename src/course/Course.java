package course;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
public class Course {
    private Long _id;
    private String name;
    private Turn turn;

    public Course() {
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
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
}
