package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    //TODO: find whisky by given year.
    // Have: Whiskies
    // Want: Year

    List<Whisky> findWhiskyByYear(int year);
    List<Whisky> findWhiskyByAgeAndDistillery(int age, Long id);
    List<Whisky> findWhiskyByRegion(String region);
}
