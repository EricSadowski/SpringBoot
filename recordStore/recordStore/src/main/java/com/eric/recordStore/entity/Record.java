package com.eric.recordStore.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="record")
public class Record {

    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="artist")
    private String artist;

    @Column(name="img_path")
    private String img_path;


    @Column(name="price")
    private double price;


    // define constructors

    public Record() {

    }

    public Record(int id, String title, String artist, String img_path, double price) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.img_path = img_path;
        this.price = price;
    }


    public Record(String title, String artist, String img_path, double price) {
        this.title = title;
        this.artist = artist;
        this.img_path = img_path;
        this.price = price;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return img_path;
    }

    public void setImgPath(String img_path) {
        this.img_path = img_path;
    }

    // define tostring

    @Override
    public String toString() {
        return "Record [id=" + id + ", title=" + title + ", artist=" + artist + ", img_path=" + img_path + ", price=" + price + "]";
    }

}
