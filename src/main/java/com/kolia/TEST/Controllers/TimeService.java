package com.kolia.TEST.Controllers;

import java.util.List;


import com.kolia.TEST.Models.Time;

import com.kolia.TEST.repos.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService
{
    @Autowired
    private TimeRepository repo;

    public List<Time> listAlll()
    {

        return (List<Time>) repo.findAll();
    }



    public Time get(Long id) {
        return repo.findById(id).get();
    }


}