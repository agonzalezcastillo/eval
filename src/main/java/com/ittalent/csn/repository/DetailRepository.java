package com.ittalent.csn.repository;

import com.ittalent.csn.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DetailRepository extends MongoRepository<Event, Long> {

    List<Event> findAllByCountry(String country);
    List<Event> findAllByEventDateGreaterThanEqual(LocalDate startTime);
    List<Event> findAllByEventDateLessThanEqual(LocalDate endTime);
    List<Event> findAllByEventDateAfterAndEventDateBefore(LocalDate startTime, LocalDate endTime);
    List<Event> findAllByMagnitudeBetween(Float minMagnitude, Float maxMagnitude);

}
