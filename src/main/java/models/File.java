package models;

import lombok.Data;

@Data
public class File {
    private int id;
    private String link;
    private int type;
    private FileType typeName;

    public File(int id, String link, int type, FileType typeName) {
        this.id = id;
        this.link = link;
        this.type = type;
        this.typeName = typeName;
    }
}
