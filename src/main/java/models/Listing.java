package models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class Listing {
    private int id;
    private String name;
    private File[] files;
    private String aboutUs, description, services, address1, address2, city, state, email, url, businessHours, freeDescription, discountDescription, phoneNumber;
    private int zipcode;
    private boolean free, discount, active;
    private Location location;

    public Listing(){
        Random r = new Random();
        this.id = r.nextInt();
        this.name = "This is listing xxxx with id" + this.id;
        this.aboutUs = "This is the about us at the listing level, yay!";
        this.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        this.services = "Listings highlight test "+ this.id;
        this.address1 = "234 thug rd";
        this.address2 = "Suite 44";
        this.city = "Hialeah";
        this.state = "FL";
        this.email = "lionking@simba.com";
        this.url = "https://www.disney.com";
        this.businessHours = "Open 24/7";
        this.free = Math.random() > 0.5 ? true : false;
        this.freeDescription = this.free ? "Everything is free!!" : null;
        this.discount = Math.random() > 0.5 ? true : false;;
        this.discountDescription = this.discount ? "Veterans get their heads shaved free" : null;
        this.zipcode = r.nextInt(8999 + 1000);;
        this.phoneNumber = "305" + r.nextInt(8999999)+ 1000000;;
        this.active = true;
        this.location = new Location(new Geography(4326, "POINT (-80.1665 25.98326)"));
        this.files = new File[]{
                new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/09c5bc8b-ca77-44ee-826f-01800a0cd12d.png", 0, FileType.BackgroundImg),
                new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/09c5bc8b-ca77-44ee-826f-01800a0cd12d.png", 1, FileType.Logo)
        };
    }

    public Listing(int id, String name, String aboutUs, String description, String services, String address1, String address2, String city, String state, String email, String url, String businessHours, String freeDescription, String discountDescription, int zipcode, String phoneNumber, boolean free, boolean discount, boolean active) {
        this.id = id;
        this.name = name;
        this.aboutUs = aboutUs;
        this.description = description;
        this.services = services;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.email = email;
        this.url = url;
        this.businessHours = businessHours;
        this.freeDescription = freeDescription;
        this.discountDescription = discountDescription;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.free = free;
        this.discount = discount;
        this.active = active;
        this.location = new Location(new Geography(4326, "POINT (-80.1665 25.98326)"));
        this.files = new File[]{
                new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/09c5bc8b-ca77-44ee-826f-01800a0cd12d.png", 0, FileType.BackgroundImg),
                new File(new Random().nextInt(), "https://daveseepersad02.blob.core.windows.net/iveteran-dev/09c5bc8b-ca77-44ee-826f-01800a0cd12d.png", 1, FileType.Logo)
        };
    }
    public void setLocation(Location loc) {
        this.location = loc;
    }

    public void addFile(File f){
        List<File> files = new ArrayList<>(Arrays.asList(this.files));
        files.add(f);
        this.files = (File[]) files.toArray();
    }
}
