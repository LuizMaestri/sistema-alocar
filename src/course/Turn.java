package course;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public enum Turn {
    MATUTINAL(1, 6),
    VESPERTINE(7, 11),
    NIGTLY(12, 16),
    INTEGRAL(1, 16),
    DAY_LONG(1, 11);

    private int start;
    private int finish;

    Turn(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public boolean isHour(int hour){
        return start <= hour && hour <= finish;
    }
}
