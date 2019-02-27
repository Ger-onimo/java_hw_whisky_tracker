package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year/{year}")
    public List<Whisky> getWhiskiesFromYear(@PathVariable int year) {
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "/name/{age}/{id}")
    public List<Whisky> findWhiskyByAgeAndDistillery(@PathVariable int age, @PathVariable Long id) {
        return whiskyRepository.findWhiskyByAgeAndDistillery(age, id);
    }

    @GetMapping(value = "/region/name/{region}")
    List<Whisky> findWhiskyByRegion(@PathVariable String region) {
        return whiskyRepository.findWhiskyByRegion(region);
    }
}