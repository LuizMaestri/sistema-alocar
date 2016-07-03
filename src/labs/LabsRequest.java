package labs;

import classes.Classes;
import dao.Entity;
import room.Room;
import utils.DayOfWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public class LabsRequest extends Entity<Long> {

    private Classes classes;
    private ArrayList<String> date;
    private Room labs;
    private List<DayOfWeek> days;
    private boolean fixed;
    private boolean approved;
    private boolean deleted;

    public LabsRequest() {
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }

    public Room getLabs() {
        return labs;
    }

    public void setLabs(Room labs) {
        this.labs = labs;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Class<Long> getIdClass() {
        return Long.class;
    }

    @Override
    public String toString() {
        return "Pedido nº: " + _id;
    }
}
