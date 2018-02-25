

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.DummyData;
import models.Event;
import spark.Request;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

public class Main {
    public static void main (String[] a){
        initExceptionHandler((e) -> System.out.println("Server initialization failed"));

        get("/", (req, res) -> rootHandler(req));


        get("/events", (req, res) -> {
            res.status(200);
            res.type("application/json");
            return getEvents(req);
        });

    }
    private static String rootHandler(Request req){
        return "thug life 33";
    }
    private static String getEvents(Request req){
        String page = req.queryParams("page");
        if (page == null) page = "1";
        int pageRequested = Integer.parseInt(page);
        List<Event> eventPage = DummyData.eventPages.get(pageRequested);
        return dataToJson(eventPage);
    }

    public static String dataToJson(Object data) {
        String ret = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            ret =  sw.toString();
        } catch (IOException e){
            System.err.println(e.toString());
        }
        return ret;
    }
}
