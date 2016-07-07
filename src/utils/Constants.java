package utils;

import controller.UserController;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
public class Constants {

    public static final String DB_NAME = "ALOCAR";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;
    public static final int CREDITS_MIN = 8;
    public static final int MAXIMUM_WORKLOAD = 40;
    public static final UserController CONTROLLER = new UserController();
    public static final String[] HOURS = {
            "07:30 - 08:20", "08:20 - 09:10", "09:10 - 10:00", "10:10 - 11:00", "11:00 - 11:50",
            "13:30 - 14:20", "14:20 - 15:10", "15:10 - 16:00", "16:20 - 17:10", "17:10 - 18:00",
            "18:30 - 19:20", "19:20 - 20:10", "20:20 - 21:10", "21:10 - 22:00"
    };
}
