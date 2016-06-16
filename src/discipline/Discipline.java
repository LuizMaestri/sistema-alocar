package discipline;

import dao.Entity;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Discipline extends Entity<String>{
    private String name;

    public Discipline() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Discipline) {
            Discipline discipline = (Discipline) obj;
            return discipline.getId().equals(_id) && discipline.getName().equals(name);
        }
        return false;
    }

    public Class<String> getIdClass() {
        return String.class;
    }
}
