package service;

import dao.Dao;
import dao.Entity;

import java.util.HashMap;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public abstract class Service<T extends Entity<N>, N> {
    protected HashMap<N, Integer> indexes;
    protected List<T> list;

    public Service() {
        indexes = new HashMap<>();
        fetch();
    }

    public List<T> getList() {
        return list;
    }

    public void fetch() {
        list = getDao().listAll();
        for (int index=0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    public T get(N id){
        Integer index = indexes.get(id);
        return index != null? list.get(index) : null;
    }
    public boolean save(T entity){
        return getDao().put(entity);
    }
    public boolean saveAll(List<T> entities){
        return getDao().putAll(entities);
    }

    public void delete(N id){
        getDao().delete(id);
    }

    protected abstract Dao<T> getDao();
}
