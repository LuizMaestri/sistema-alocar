package gpda;

import dao.Entity;
import discipline.Discipline;
import professor.Professor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 10/06/16
 */
public class GPDA extends Entity<Long> {
    private Professor coordinator;
    private List<Discipline> disciplines;
    private ArrayList<Professor> professors;

    public GPDA() {
    }

    public Professor getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Professor coordinator) {
        this.coordinator = coordinator;
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

    public Class<Long> getIdClass() {
        return Long.class;
    }

    public void updateProfessor(Professor professor) {
        if (coordinator.getId().equals(professor.getId()))
            coordinator = professor;
        for (int index = 0; index < professors.size(); index++){
            if (professors.get(index).getId().equals(professor.getId())){
                professors.set(index, professor);
                break;
            }
        }
    }
}
