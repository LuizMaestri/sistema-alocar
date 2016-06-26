package service;

import dao.Dao;
import dao.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public abstract class Service<T extends Entity<N>, N> {
    protected HashMap<N, Integer> indexes;
    protected ArrayList<T> list;

    public Service() {
        indexes = new HashMap<>();
        fetch();
    }

    public ArrayList<T> getList() {
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
        boolean save = getDao().put(entity);
        if (save) updateList(entity);
        return save;
    }

    public boolean saveAll(List<T> entities){
        boolean save = getDao().putAll(entities);
        if (save) entities.forEach(this::updateList);
        return save;
    }

    public void delete(N id){
        getDao().delete(id);
    }

    private void updateList(T entity) {
        N id = entity.getId();
        for (int index = 0; index < list.size(); index++) {
            if (id.equals(list.get(index).getId())) {
                list.set(index, entity);
                indexes.put(id, index);
            }
        }
    }

    protected abstract Dao<T> getDao();
}
