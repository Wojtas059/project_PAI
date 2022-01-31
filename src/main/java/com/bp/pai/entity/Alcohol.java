/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bp.pai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author wojta
 */
@Entity
@Table(name = "Alcohol")
public class Alcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer alcoid;
    
    @NotNull
    @Pattern(regexp = "[^*]{2,30}",
            message = "Podaj poprawnie nazwę alkoholu")
    private String name;
    
    @NotNull
    private String type;
    
    @NotNull
    @Pattern(regexp = "[^*]{1,30}",
            message = "Podaj wiek leżakowania ALKOHOLU w beczkach")
    private String yo_old;
    
    
    @NotNull
    @Pattern(regexp = "[^*]{100,512}",
            message = "Podaj opis/recenzję pitego alkoholu")
    private String description;
    
    @NotNull
    @Pattern(regexp = "[^*]{10,100}",
            message = "Podaj finish sożytego alkoholu")
    private String finish;
    
    
    @NotNull
    @Pattern(regexp = "[^*]{2,255}",
            message = "Podaj link zdjecia alkoholu")
    private String link_url_photo;
    
    
    
    private Integer like_;
    private Integer userid;
    public Alcohol()
    {}

    public Alcohol( String name, String type, String yo_old, String description, String finish, String link_url_photo, Integer like_, Integer userid) {
        this.name = name;
        this.type = type;
        this.yo_old = yo_old;
        this.description = description;
        this.finish = finish;
        this.link_url_photo = link_url_photo;
        this.like_ = like_;
        this.userid = userid;
    }

    public Integer getAlcoid() {
        return alcoid;
    }

    public void setAlcoid(Integer alcoid) {
        this.alcoid = alcoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYo_old() {
        return yo_old;
    }

    public void setYo_old(String yo_old) {
        this.yo_old = yo_old;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getLink_url_photo() {
        return link_url_photo;
    }

    public void setLink_url_photo(String link_url_photo) {
        this.link_url_photo = link_url_photo;
    }

    public Integer getLike_() {
        return like_;
    }

    public void setLike_(Integer like_) {
        this.like_ = like_;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    
    
}   
