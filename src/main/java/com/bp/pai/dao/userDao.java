/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bp.pai.dao;

/**
 *
 * @author wojto
 */
import com.bp.pai.entity.User;
import org.springframework.data.repository.CrudRepository;
public interface userDao extends CrudRepository<User, Integer> {
 public User findByLogin(String login);

 public User findByEmail(String email);


 public User findByUserid(int id);
}
