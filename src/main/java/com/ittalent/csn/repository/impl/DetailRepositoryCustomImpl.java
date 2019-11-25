package com.ittalent.csn.repository.impl;

import com.ittalent.csn.Model.Event;
import com.ittalent.csn.repository.DetailRepositoryCustom;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DetailRepositoryCustomImpl implements DetailRepositoryCustom {

    private MongoTemplate mongoTemplate;

    public DetailRepositoryCustomImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Event> findByDateCustom(LocalDate startTime, LocalDate endTime) {

        Query query = new Query(Criteria.where("eventDate")
                .gte(startTime)
                .lte(endTime)
        );
        return mongoTemplate.find(query, Event.class);
    }

    @Override
    public List<Event> findByMagnitudeCustom(Float minMagnitude, Float maxMagnitude) {

        Query query = new Query(Criteria.where("magnitude")
                .gte(minMagnitude)
                .lte(maxMagnitude)
        );
        return mongoTemplate.find(query, Event.class);
    }
}
