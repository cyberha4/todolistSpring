import models.Model;

import java.sql.SQLException;

/**
 * Created by admin on 21.02.2017.
 */
public class ClearDb {
    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println(Model.getStatement().execute("ALTER TABLE tasks DROP FOREIGN KEY tasksusers"));
        System.out.println(Model.getStatement().execute("TRUNCATE TABLE `users`"));
        System.out.println(Model.getStatement().execute("TRUNCATE TABLE `tasks`"));
        System.out.println(Model.getStatement().execute("TRUNCATE TABLE `types`"));
        System.out.println(Model.getStatement().execute("TRUNCATE TABLE `statuses`"));

    }
}
