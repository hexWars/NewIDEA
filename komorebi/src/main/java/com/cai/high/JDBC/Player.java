package com.cai.high.JDBC;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author: Cai
 * @date: 2020/11/18 17:05
 * @description:
 */

public class Player {
    private String name;
    private ImageView imageView;
    private String id;
    private String teacher;
    private Image image;

    public ImageView getImage() {
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        return imageView;
    }

    public Player(String name, Image image, String id, String teacher) {
        this.name = name;
        this.image = image;
        this.id = id;
        this.teacher = teacher;
        this.imageView = new ImageView(image);
    }

    public Player(String name, ImageView imageView, String id, String teacher) {
        this.name = name;
        this.imageView = imageView;
        this.id = id;
        this.teacher = teacher;
        this.image = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImageTrue() {
        return new Image("");
    }
}


