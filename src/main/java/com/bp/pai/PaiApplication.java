package com.bp.pai;

import com.bp.pai.dao.userDao;
import com.bp.pai.dao.alcoholDao;

import com.bp.pai.entity.User;
import com.bp.pai.entity.Alcohol;
import static java.lang.System.out;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PaiApplication {

    @Autowired
    private userDao dao;
    @Autowired
    private alcoholDao alcodao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(PaiApplication.class, args);
        
    }

    @PostConstruct
    public void init() {
       
         
    }
}
