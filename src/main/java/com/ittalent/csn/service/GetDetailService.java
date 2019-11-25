package com.ittalent.csn.service;

import com.ittalent.csn.Model.Event;

import java.time.LocalDate;
import java.util.List;

public interface GetDetailService {

    List<Event> getByDate (LocalDate startTime, LocalDate endTime);
    List<Event> getByDateExtended (LocalDate startTimeA, LocalDate endTimeA, LocalDate startTimeB, LocalDate endTimeB);
    List<Event> getByMagnitude(Float minMagnitude, Float maxMagnitude);
    List<Event> getByCountry (String country);
    Integer countByCountryAndDate(String countryA,String countryB, LocalDate startTime, LocalDate endTime);

}
