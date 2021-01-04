package com.cai.high.JDBC.oldWork;


import javafx.scene.image.ImageView;

/**
 * @author: Cai
 * @date: 2020/11/9 11:03
 * @description:
 */
public class Player {
    private String name;
    private ImageView image;
    private String id;
    private String teacher;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getTeacher() {
        return teacher;
    }

    public ImageView getImage() {
        image.setFitHeight(30);
        image.setFitWidth(30);
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Player(String name, String id, String teacher, ImageView image) {
        this.name = name;
        this.id = id;
        this.teacher = teacher;
        this.image = image;
    }
    public Player(String name, String id, String teacher) {
        this.name = name;
        this.id = id;
        this.teacher = teacher;
    }
}
