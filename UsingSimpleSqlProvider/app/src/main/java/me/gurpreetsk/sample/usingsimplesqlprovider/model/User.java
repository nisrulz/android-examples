package me.gurpreetsk.sample.usingsimplesqlprovider.model;

import ckm.simple.sql_provider.annotation.SimpleSQLColumn;
import ckm.simple.sql_provider.annotation.SimpleSQLTable;

/**
 * Created by Gurpreet on 04/09/17.
 */

@SimpleSQLTable(table = "user", provider = "MyProvider")
public class User {

    @SimpleSQLColumn("name")
    private String name;
    @SimpleSQLColumn("_id")
    private int id;

    public User() {
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
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
}
