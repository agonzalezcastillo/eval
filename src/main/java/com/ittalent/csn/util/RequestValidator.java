package com.ittalent.csn.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class RequestValidator {

    public Boolean isValidDateRequest(LocalDate startTime, LocalDate endTime) throws Exception{
        if(!endTime.isAfter(startTime)) {
            log.error("endTime can not be before startTime");
            throw new IllegalArgumentException("bad request");
        }
        return true;

    }

    public Boolean notEqualCountries(String countryA, String countryB) throws Exception{
        if(countryA.toUpperCase().equals(countryB.toUpperCase())){
            log.error("country a equals country b");
            throw new IllegalArgumentException("bad request");
        }
        return true;
    }

}
