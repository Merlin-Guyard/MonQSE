package org.merlin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Board {

    @Id
    private String id;
    private String name;
    private String datastring;
    private int dataint;

    public Board(String id, String name, String datastring, int dataint) {
        this.id = id;
        this.name = name;
        this.datastring = datastring;
        this.dataint = dataint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatastring() {
        return datastring;
    }

    public void setDatastring(String datastring) {
        this.datastring = datastring;
    }

    public int getDataint() {
        return dataint;
    }

    public void setDataint(int dataint) {
        this.dataint = dataint;
    }
}
