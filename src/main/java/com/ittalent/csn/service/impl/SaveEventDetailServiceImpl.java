package com.ittalent.csn.service.impl;

import com.ittalent.csn.Model.Event;
import com.ittalent.csn.repository.DetailRepository;
import com.ittalent.csn.service.SaveEventDetail;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaveEventDetailServiceImpl implements SaveEventDetail {

    private DetailRepository detailRepository;

    public SaveEventDetailServiceImpl(DetailRepository detailRepository){
        this.detailRepository = detailRepository;
    }

    @Override
    public void saveEvent() {

        Event ev1 = Event.builder().country("CHILE")
                .id(1)
                .magnitude(new Float(7.5))
                .eventDate(LocalDate.parse("2019-10-13"))
                .build();
        Event ev2 = Event.builder().country("CHILE")
                .id(2)
                .magnitude(new Float(6.2))
                .eventDate(LocalDate.parse("2019-10-14"))
                .build();
        Event ev3 = Event.builder().country("CHILE")
                .id(3)
                .magnitude(new Float(6.9))
                .eventDate(LocalDate.parse("2019-10-14"))
                .build();
        Event ev4 = Event.builder().country("CHILE")
                .id(4)
                .magnitude(new Float(4.3))
                .eventDate(LocalDate.parse("2019-10-01"))
                .build();
        Event ev5 = Event.builder().country("CHILE")
                .id(5)
                .magnitude(new Float(5.9))
                .eventDate(LocalDate.parse("2019-10-02"))
                .build();
        Event ev6 = Event.builder().country("CHILE")
                .id(6)
                .magnitude(new Float(4.3))
                .eventDate(LocalDate.parse("2019-10-03"))
                .build();
        Event ev7 = Event.builder().country("CHILE")
                .id(7)
                .magnitude(new Float(3.3))
                .eventDate(LocalDate.parse("2019-10-03"))
                .build();
        Event ev8 = Event.builder().country("USA")
                .id(8)
                .magnitude(new Float(4.7))
                .eventDate(LocalDate.parse("2019-10-14"))
                .build();

        detailRepository.save(ev1);
        detailRepository.save(ev2);
        detailRepository.save(ev3);
        detailRepository.save(ev4);
        detailRepository.save(ev5);
        detailRepository.save(ev6);
        detailRepository.save(ev7);
        detailRepository.save(ev8);


    }
}
