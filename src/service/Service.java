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
    private HashMap<N, Integer> indexes;
    protected ArrayList<T> list;

    public Service() {
        indexes = new HashMap<>();
        fetch();
    }

    public ArrayList<T> getList() {
        return list;
    }

    private void fetch() {
        list = getDao().listAll();
        createIndexes();
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
        boolean delete = getDao().delete(id);
        if (delete){
            int deleted = indexes.get(id);
            list.remove(deleted);
            indexes.remove(id);
            createIndexes();
        }
    }

    private void createIndexes(){
        for (int index=0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    public void updateList(T entity) {
        N id = entity.getId();
        boolean put = false;
        for (int index = 0; index < list.size(); index++) {
            if (id.equals(list.get(index).getId())) {
                list.set(index, entity);
                put = true;
            }
        }
        if (!put){
            list.add(entity);
            indexes.put(id, list.size() -1);
        }
    }

    protected abstract Dao<T> getDao();
}
