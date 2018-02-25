package models;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static List<ArrayList<Event>> eventPages = new ArrayList<>();
    static {
        for (int i = 1; i < 100; i++){
            ArrayList<Event> newPage = new ArrayList<>();
            for (int j = 0; j < (i == 1 ? 20 : 4); j++){
                newPage.add(new Event(i));
            }
            eventPages.add(newPage);
        }
    }

}
