package utils;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public enum DayOfWeek {
    MONDAY("Segunda-feira"),
    TUESDAY("Ter�a-feira"),
    WEDNESDAY("Quarta-feira"),
    THURSDAY("Quinta-feira"),
    FRIDAY("Sexta-feira"),
    SATURDAY("S�bado");

    private String ptName;

    DayOfWeek(String ptName){
        this.ptName = ptName;
    }

    public boolean isSaturday(){
        return this.equals(SATURDAY);
    }

    public String toString(){
        return ptName;
    }
}
