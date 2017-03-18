package com.cyberha4;

import com.cyberha4.models.oldclasses.Model;

import java.sql.SQLException;

/**
 * Created by admin on 21.02.2017.
 */
public class ClearDb {
    public static void main(String[] args) throws SQLException, InterruptedException {
        clearAllTables();
    }

    public static void clearAllTables(){

        try {
            Model.getStatement().execute("ALTER TABLE tasks DROP FOREIGN KEY TasksToUser");
            Model.getStatement().execute("TRUNCATE TABLE `users`");
            Model.getStatement().execute("TRUNCATE TABLE `tasks`");
            Model.getStatement().execute("TRUNCATE TABLE `types`");
            Model.getStatement().execute("TRUNCATE TABLE `statuses`");
            String sql = "ALTER TABLE `tasks` ADD CONSTRAINT `TasksToUser` FOREIGN KEY (`user_id`)"
                    +" REFERENCES `todoList`.`users`(`id`) ON DELETE CASCADE ON UPDATE RESTRICT";
            Model.getStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
