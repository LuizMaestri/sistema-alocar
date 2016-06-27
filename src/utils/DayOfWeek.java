package utils;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public boolean isSaturday(){
        return this.equals(SATURDAY);
    }
}
