package com.example.kamps.Retrofit;

public class post {

private String camp_name;
private  String camp_desc;
private  String camp_body;
private String camp_image;

    public post(String camp_name, String camp_desc, String camp_body, String camp_image) {
        this.camp_name = camp_name;
        this.camp_desc = camp_desc;
        this.camp_body = camp_body;
        this.camp_image = camp_image;
    }


    public String getCamp_name() {
        return camp_name;
    }

    public void setCamp_name(String camp_name) {
        this.camp_name = camp_name;
    }

    public String getCamp_desc() {
        return camp_desc;
    }

    public void setCamp_desc(String camp_desc) {
        this.camp_desc = camp_desc;
    }

    public String getCamp_body() {
        return camp_body;
    }

    public void setCamp_body(String camp_body) {
        this.camp_body = camp_body;
    }

    public String getCamp_image() {
        return camp_image;
    }

    public void setCamp_image(String camp_image) {
        this.camp_image = camp_image;
    }
}
