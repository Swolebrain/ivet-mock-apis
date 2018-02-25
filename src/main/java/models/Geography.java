package models;

import lombok.Data;

@Data
public class Geography {
    private final int coordinateSystemId;
    private final String wellKnownText;

    public Geography(int coordinateSystemId, String wellKnownText) {
        this.coordinateSystemId = coordinateSystemId;
        this.wellKnownText = wellKnownText;
    }
}
