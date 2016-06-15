package labs;

import classes.Classes;
import room.Room;

import java.util.Date;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public class LabsRequest {

    private Long _id;
    private Classes classes;
    private String date;
    private Room labs;
    private boolean fixed;

    public LabsRequest() {
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Room getLabs() {
        return labs;
    }

    public void setLabs(Room labs) {
        this.labs = labs;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
