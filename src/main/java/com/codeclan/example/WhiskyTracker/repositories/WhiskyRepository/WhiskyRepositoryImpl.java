package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    // TODO: find a list of whiskies with a certain age from a specific distillery
    // Have: int age and Distillery distillery
    // Want: List<Whisky>
    @Transactional
    public List<Whisky> findWhiskyByAgeAndDistillery(int age, Long id) {

        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.add(Restrictions.eq("age", age));
        cr.add(Restrictions.eq("distillery.id", id));

        results = cr.list();

        return results;
    }

    // TODO: find a list of whiskies from a particular region
    // Have: Distillery distillery region. String region
    // Want: List<Whisky>
    @Transactional
    public List<Whisky> findWhiskyByRegion(String region){

        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.add(Restrictions.eq("distillery.region", region));

        results = cr.list();

        return results;
    }

}
