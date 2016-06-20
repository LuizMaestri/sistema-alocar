package service;

import java.util.HashMap;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public abstract class Service<T, N> {
    protected HashMap<N, Integer> indexes;
    protected List<T> list;

    public Service() {
        indexes = new HashMap<N, Integer>();
        fetch();
    }

    public List<T> getList() {
        return list;
    }

    public abstract void fetch();
    public T get(N id){
        Integer index = indexes.get(id);
        return index != null? list.get(index) : null;
    }
    public abstract boolean save(T entity);
    public abstract boolean saveAll(List<T> entities);
    public abstract void delete(N id);
}
