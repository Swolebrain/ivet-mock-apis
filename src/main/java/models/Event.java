package models;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class Event {
    private int id;
    private int zip;
    private String startDate;
    private File[] files;
    private Location location;
    private String state;
    private String eventTitle;
    private String address1;
    private String address2;
    private String endDate;
    private String listingId;
    private String endTime;
    private String url;
    private String city;
    private String startTime;
    private boolean isActive;
    private String creationDate;
    private String phoneNumber;
    private String email;
    private String description;
    private String registrationUrl;
    private Listing listing;

    public Event(int pageNum){
        Random r = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat sdfHour = new SimpleDateFormat("h:mm a");
        long pageNumOffset = 1000*60*60*24*pageNum*10; //offset the date of the event by 5*pageNum. So events on page 2 are all 5 days from now

        this.id = r.nextInt();
        this.zip = r.nextInt(8999 + 1000);
        long start =  System.currentTimeMillis() + pageNumOffset + 1000*60*60*r.nextInt(96);
        this.startDate = sdf.format(new Date(start));
        this.state = "FL";
        this.eventTitle = "Mock event title "+r.nextInt();
        this.address1 = "123 thug rd";
        this.address2 = null;
        long endDate = start + 1000*60*60*3;
        if (Math.random() > 0.5){
            endDate = start + 1000*60*60*36;
        }
        this.endDate = sdf.format(new Date(endDate));
        this.listingId = null;
        this.endTime = sdfHour.format(new Date(endDate));
        this.url = "http://www.youtube.com";
        this.city = "Miami";
        this.startTime = sdfHour.format(new Date(start));
        this.isActive = true;
        this.creationDate = "na";
        this.phoneNumber = "954" + r.nextInt(8999999)+ 1000000;
        this.email = "thug@thug.co";
        this.description = "This is the event description for " + this.eventTitle + ". It's gonna be a really cool event. You can have lots of fun and rock out with Snoop Dogg and Arnold Schwarzenegger making really liberal political videos that go viral.";
        this.registrationUrl = "http://www.titanhack.com";
        this.location = new Location(new Geography(4326, "POINT (-80.1665 25.98326)"));
        this.files = new File[]{
                new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/70835ef8-f9c6-4808-9945-61e469d588e3.jpg", 0, FileType.BackgroundImg),
                new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/70835ef8-f9c6-4808-9945-61e469d588e3.jpg", 1, FileType.Logo)
        };
        if (Math.random() < 0.5){
            this.files = new File[0];
        }
        this.listing = new Listing();
    }

    public Event(int id, int zip, String startDate, String state, String eventTitle, String address1, String address2, String endDate, String listingId, String endTime, String url, String city, String startTime, boolean isActive, String creationDate, String phoneNumber, String email, String description, String registrationUrl) {
        this.id = id;
        this.zip = zip;
        this.startDate = startDate;
        this.state = state;
        this.eventTitle = eventTitle;
        this.address1 = address1;
        this.address2 = address2;
        this.endDate = endDate;
        this.listingId = listingId;
        this.endTime = endTime;
        this.url = url;
        this.city = city;
        this.startTime = startTime;
        this.isActive = isActive;
        this.creationDate = creationDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.registrationUrl = registrationUrl;
        this.location = new Location(new Geography(4326, "POINT (-80.1665 25.98326)"));
        this.files = new File[]{
            new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/70835ef8-f9c6-4808-9945-61e469d588e3.jpg", 0, FileType.BackgroundImg),
            new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/70835ef8-f9c6-4808-9945-61e469d588e3.jpg", 1, FileType.Logo)
        };
    }

    public void setLocation(Location loc) {
        this.location = loc;
    }

    public void setListing(Listing lst){
        this.listing = lst;
    }

    public void addFile(File f){
        List<File> files = new ArrayList<>(Arrays.asList(this.files));
        files.add(f);
        this.files = (File[]) files.toArray();
    }

}