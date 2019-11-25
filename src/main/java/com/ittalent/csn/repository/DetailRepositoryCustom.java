package com.ittalent.csn.repository;

import com.ittalent.csn.Model.Event;

import java.time.LocalDate;
import java.util.List;

public interface DetailRepositoryCustom {

    List<Event> findByDateCustom(LocalDate startTime, LocalDate endTime);
    List<Event> findByMagnitudeCustom(Float minMagnitude, Float maxMagnitude);

}
