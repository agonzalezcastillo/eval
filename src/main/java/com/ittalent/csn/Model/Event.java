package com.ittalent.csn.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "events")
@Getter
@Setter
@Builder
public class Event {

    @Id
    private long id;

    private String country;

    private LocalDate eventDate;

    private Float magnitude;

}
