package models;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static List<ArrayList<Event>> eventPages = new ArrayList<>();
    static {
        eventPages.add(new ArrayList<>());
        for (int i = 1; i < 100; i++){
            ArrayList<Event> newPage = new ArrayList<>();
            int maxJ = (i == 1 ? 20 : 4);
            for (int j = 0; j < maxJ; j++){
                newPage.add(new Event(i));
            }
            eventPages.add(newPage);
        }
    }

}
