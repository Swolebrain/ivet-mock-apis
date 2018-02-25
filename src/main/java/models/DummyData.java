package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DummyData {
    public static List<Event> events = new ArrayList<>();
    public static List<ArrayList<Event>> eventPages = new ArrayList<>();
    static {
        eventPages.add(new ArrayList<>());
        for (int i = 0; i < 416; i++){
            events.add(new Event(i));
        }
        Collections.sort(events);
        Iterator<Event> it = events.iterator();
        for (int i = 1; i < 100; i++){
            ArrayList<Event> newPage = new ArrayList<>();
            int maxJ = (i == 1 ? 20 : 4);
            for (int j = 0; j < maxJ; j++){
                if (it.hasNext())
                    newPage.add(it.next());
            }
            eventPages.add(newPage);
        }
    }

}
