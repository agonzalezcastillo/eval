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

        Event ev = Event.builder().country("CHILE")
                .id(1)
                .magnitude(new Float(7.5))
                .eventDate(LocalDate.parse("2019-10-13"))
                .build();

        detailRepository.save(ev);

    }
}
