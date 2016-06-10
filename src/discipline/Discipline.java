package discipline;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Discipline {
    private String _id;
    private String name;

    public Discipline() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
