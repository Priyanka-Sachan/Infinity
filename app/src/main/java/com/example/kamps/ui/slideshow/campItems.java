package com.example.kamps.ui.slideshow;

public class campItems {

    private String camp_head;
    private String camp_desc;
    private String camp_image;


    //Constructor
    public campItems() {

    }

    public campItems(String camp_head, String camp_desc, String camp_image) {
        this.camp_head = camp_head;
        this.camp_desc = camp_desc;
        this.camp_image = camp_image;
    }


    //Getters and setters.
    public String getCamp_head() {
        return camp_head;
    }


    public void setCamp_head(String camp_head) {
        this.camp_head = camp_head;
    }

    public String getCamp_desc() {
        return camp_desc;
    }

    public void setCamp_desc(String camp_desc) {
        this.camp_desc = camp_desc;
    }

    public String getCamp_image() {
        return camp_image;
    }

    public void setCamp_image(String camp_image) {
        this.camp_image = camp_image;
    }
}