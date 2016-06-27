package professor;

import classes.Classes;
import dao.Entity;
import utils.DayOfWeek;

import java.util.ArrayList;
import java.util.EnumMap;
import static utils.Constants.CREDITS_MIN;
import static utils.Constants.MAXIMUM_WORKLOAD;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Professor extends Entity<Long> {
    private int adm;
    private int research;
    private int extension;
    private int credits;
    private String name;
    private String password;
    private boolean admin;
    private EnumMap<DayOfWeek, ArrayList<Integer>> freeTime;

    public Professor() {
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

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
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

    public EnumMap<DayOfWeek, ArrayList<Integer>> getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(EnumMap<DayOfWeek, ArrayList<Integer>> freeTime) {
        this.freeTime = freeTime;
    }

    public boolean hasMax(){
        return (adm + research + extension + credits) == MAXIMUM_WORKLOAD;
    }

    public boolean hasMin(){
        return credits >= CREDITS_MIN;
    }

    public boolean checkFreeTime(Classes classes){
        return false;
    }

    public Class<Long> getIdClass() {
        return Long.class;
    }
}
