/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bp.pai.dao;

/**
 *
 * @author wojta
 */




import com.bp.pai.entity.Alcohol;


import org.springframework.data.repository.CrudRepository;
public interface alcoholDao extends CrudRepository<Alcohol, Integer> {
    public Alcohol findByName(String name);
    public Iterable<Alcohol> findByUserid(int iduser);
    public Alcohol findByAlcoid(int alcoid);
    

}
