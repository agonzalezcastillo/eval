package com.ittalent.csn.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class RequestValidator {

    public void isValidDateRequest(LocalDate startTime, LocalDate endTime) throws Exception{
        if(!endTime.isAfter(startTime)) {
            log.error("endTime can not be before startTime");
            throw new IllegalArgumentException("endTime can not be before startTime");
        }
    }

    public void isValidMagnitudeRequest(Float minMagnitude, Float maxMagnitude) throws Exception{
        if(minMagnitude >= maxMagnitude) {
            log.error("minMagnitud less than maxMagnitude");
            throw new IllegalArgumentException("minMagnitude cannot be greater than maxMagnitude");
        }
    }

    public void notEqualCountries(String countryA, String countryB) throws Exception{
        if(countryA.toUpperCase().equals(countryB.toUpperCase())){
            log.error("country a equals country b");
            throw new IllegalArgumentException("Countries cannot be equal");
        }
    }

}
