package models;

/**
 * Created by admin on 19.02.2017.
 */
public class User {
    private int id;
    private String name;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void findUserById(int id){

    }
}
