package dao;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public abstract class Entity<T> {
    protected T _id;

    public T getId() {
        return _id;
    }

    public void setId(T _id) {
        this._id = _id;
    }

    public abstract Class<T> getIdClass();
}
