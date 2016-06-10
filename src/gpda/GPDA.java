package gpda;

import discipline.Discipline;
import professor.Professor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 10/06/16
 */
public class GPDA {
    private Long _id;
    private Professor coordenator;
    private List<Discipline> disciplines;
    private ArrayList<Professor> professors;

    public GPDA() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Professor getCoordenator() {
        return coordenator;
    }

    public void setCoordenator(Professor coordenator) {
        this.coordenator = coordenator;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public boolean hasDiscipline(Discipline discipline){
        for (Discipline disc : disciplines)
            if (disc.equals(discipline)) return true;
        return false;
    }
}
