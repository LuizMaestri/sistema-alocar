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

    public List<T> getList() {
        return list;
    }

    public abstract void fetch();
    public T get(N id){
        int index = indexes.get(id);
        return list.get(index);
    }
    public abstract boolean save(T entity);
    public abstract boolean saveAll(List<T> entities);
    public abstract void delete(N id);
}
