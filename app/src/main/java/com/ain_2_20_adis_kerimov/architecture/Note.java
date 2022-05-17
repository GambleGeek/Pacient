package com.ain_2_20_adis_kerimov.architecture;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String tel;

    private String email;

    private String spec;

    public Note(String name, String tel, String email, String spec) {
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.spec = spec;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getSpec() {
        return spec;
    }
}
