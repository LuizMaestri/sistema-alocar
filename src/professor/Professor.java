package professor;

import classes.Classes;
import utils.DayOfWeek;

import java.util.EnumMap;
import static utils.Constants.CREDITS_MIN;
import static utils.Constants.MAXIMUM_WORKLOAD;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Professor {
    private long _id;
    private int adm;
    private int research;
    private int estension;
    private int credits;
    private String name;
    private String password;
    private boolean admin;
    private EnumMap<DayOfWeek, long[]> freeTime;

    public Professor() {
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public int getAdm() {
        return adm;
    }

    public void setAdm(int adm) {
        this.adm = adm;
    }

    public int getResearch() {
        return research;
    }

    public void setResearch(int research) {
        this.research = research;
    }

    public int getEstension() {
        return estension;
    }

    public void setEstension(int estension) {
        this.estension = estension;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public EnumMap<DayOfWeek, long[]> getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(EnumMap<DayOfWeek, long[]> freeTime) {
        this.freeTime = freeTime;
    }

    public boolean hasMax(){
        return (adm + research + estension + credits) == MAXIMUM_WORKLOAD;
    }

    public boolean hasMin(){
        return credits >= CREDITS_MIN;
    }

    public boolean checkFreeTime(Classes classes){
        return false;
    }
}
