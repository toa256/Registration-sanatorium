package com.kolia.TEST.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Patients
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, surname,middle_name,history,blood_type,medical_policy;
    private int born_data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public int getBorn_data() {
        return born_data;
    }

    public void setBorn_data(int born_data) {
        this.born_data = born_data;
    }

    public Patients() {
    }

    public Patients(String name, String surname, String middle_name, String history, String tel, int born_data) {
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.history = history;
        this.tel = tel;
        this.born_data = born_data;
    }
}
