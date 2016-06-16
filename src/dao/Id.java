package dao;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public class Id {
    private Object _id;

    public Id() {
    }

    public Object getId() {
        return _id;
    }

    public void setId(Object _id) {
        this._id = _id;
    }

    public Long asLong(){
        return (Long) _id;
    }

    @Override
    public String toString() {
        return _id.toString();
    }
}
