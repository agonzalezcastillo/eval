package com.ittalent.csn.service.impl;

import com.ittalent.csn.Model.Event;
import com.ittalent.csn.repository.DetailRepository;
import com.ittalent.csn.repository.DetailRepositoryCustom;
import com.ittalent.csn.service.GetDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class getDetailServiceImpl implements GetDetailService {

    private DetailRepository detailRepository;

    private DetailRepositoryCustom detailRepositoryCustom;

    public getDetailServiceImpl(DetailRepository detailRepository, DetailRepositoryCustom detailRepositoryCustom){
        this.detailRepository = detailRepository;
        this.detailRepositoryCustom = detailRepositoryCustom;
    }

    @Override
    public List<Event> getByDate(LocalDate startTime, LocalDate endTime) {
        return detailRepositoryCustom.findByDateCustom(startTime, endTime);
    }

    @Override
    public List<Event> getByDateExtended(LocalDate startTimeA, LocalDate endTimeA,
                                         LocalDate startTimeB, LocalDate endTimeB) {

        List<Event> eventList1 = detailRepositoryCustom.findByDateCustom(startTimeA,endTimeA);
        List<Event> eventList2 = detailRepositoryCustom.findByDateCustom(startTimeB,endTimeB);

        List<Event> allEvents = new ArrayList<>();
        allEvents.addAll(eventList1);
        allEvents.addAll(eventList2);

        return allEvents.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Event> getByMagnitude(Float minMagnitude, Float maxMagnitude) {
        return  detailRepositoryCustom.findByMagnitudeCustom(minMagnitude, maxMagnitude);
    }

    @Override
    public List<Event> getByCountry(String country) {
        return detailRepository.findAllByCountry(country.toUpperCase());
    }

    @Override
    public Integer countByCountryAndDate(String countryA,String countryB, LocalDate startTime, LocalDate endTime) {
            List<Event> eventList1 = detailRepositoryCustom.findByDateCustom(startTime, endTime);
            List<Event> allEvents = eventList1.stream().filter(c -> c.getCountry().equalsIgnoreCase(countryA.toUpperCase()))
                    .collect(Collectors.toList());
            allEvents.addAll(eventList1.stream().filter(c -> c.getCountry().equalsIgnoreCase(countryB.toUpperCase()))
                    .collect(Collectors.toList()));
            allEvents.stream().distinct().collect(Collectors.toList());
            return allEvents.size();
    }
}
