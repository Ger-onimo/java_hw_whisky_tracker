package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    // TODO: find a list of distilleries of whiskies of 12 years of age
    // Have: Whiskey ages. int age
    // Want: List<Distillery>


    @Transactional
    public List<Distillery> findDistilleryByAge(int age) {

        List<Distillery> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);
        cr.createAlias("whisky", "whiskyAlias");
        cr.add(Restrictions.gt("whiskyAlias.age", age));

        results = cr.list();

        return results;
    }
}