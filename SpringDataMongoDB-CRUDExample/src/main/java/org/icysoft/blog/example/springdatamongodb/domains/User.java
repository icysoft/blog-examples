/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.icysoft.blog.example.springdatamongodb.domains;

import java.util.Date;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author cmillauriaux
 */
@Document(collection = "user")
public class User {

    @Id
    private UUID idAnecdote;
    
    private String lastName;
    
    private String surName;
    
    private Date birthday;
    
    private Date subscribeDate;

    public User() {
    }

    public User(String lastName, String surName, Date birthday) {
        this.lastName = lastName;
        this.surName = surName;
        this.birthday = birthday;
        this.idAnecdote = UUID.randomUUID();
        this.subscribeDate = new Date();
    }

    public UUID getIdAnecdote() {
        return idAnecdote;
    }

    public void setIdAnecdote(UUID idAnecdote) {
        this.idAnecdote = idAnecdote;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }
}
