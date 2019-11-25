package com.ittalent.csn.api;

import com.ittalent.csn.Model.Event;
import com.ittalent.csn.service.GetDetailService;
import com.ittalent.csn.service.SaveEventDetail;
import com.ittalent.csn.util.RequestValidator;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@Controller
@AllArgsConstructor
@Slf4j
@Api(value = "Events", description = "the seismic Events API")
@RequestMapping("/event")
public class DateApi {

    private RequestValidator requestValidator;

    private SaveEventDetail saveEventDetail;

    private GetDetailService getDetailService;

    @RequestMapping(value = "/1/date" , produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByDate (@Valid @RequestParam(value="startTime", required = true)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate startTime,
                                                  @Valid @RequestParam(value="endTime", required = true)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate endTime
    ) throws Exception{
        requestValidator.isValidDateRequest(startTime,endTime);
        List<Event> e = getDetailService.getByDate(startTime, endTime);
        return new ResponseEntity<>(e , HttpStatus.OK);

    }

    @RequestMapping(value = "/1/dateE" , produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByDateExtended (@Valid @RequestParam(value="startTimeA", required = true)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate startTimeA,
                                                  @Valid @RequestParam(value="endTimeA", required = true)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate endTimeA,
                                                  @Valid @RequestParam(value="startTimeB", required = true)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate startTimeB,
                                                  @Valid @RequestParam(value="endTimeB", required = true)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                  LocalDate endTimeB
    ) throws Exception{
        requestValidator.isValidDateRequest(startTimeA,endTimeA);
        requestValidator.isValidDateRequest(startTimeB,endTimeB);
        List<Event> e = getDetailService.getByDateExtended(startTimeA, endTimeA, startTimeB, endTimeB);
        return new ResponseEntity<>(e , HttpStatus.OK);

    }

    @ApiIgnore
    @RequestMapping(value = "/1/save" , method = RequestMethod.PUT)
    public ResponseEntity<Boolean> saveByDate (){
        saveEventDetail.saveEvent();
        return new ResponseEntity<>(Boolean.TRUE , HttpStatus.OK);

    }

    @RequestMapping(value = "/1/magnitude" , produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByMag (@Valid @RequestParam(value="minMagnitude", required = true)
                                                      Float minMagnitude,
                                              @Valid @RequestParam(value="maxMagnitude", required = true)
                                                      Float maxMagnitude
    )throws Exception{
        requestValidator.isValidMagnitudeRequest(minMagnitude, maxMagnitude);
        List<Event> e = getDetailService.getByMagnitude(minMagnitude, maxMagnitude);
        return new ResponseEntity<>(e , HttpStatus.OK);

    }

    @RequestMapping(value = "/1/country" , produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByCountry (@Valid @RequestParam(value="country", required = true)
                                                         String country
    ){
        List<Event> e = getDetailService.getByCountry(country);
        return new ResponseEntity<>(e , HttpStatus.OK);

    }

    @RequestMapping(value = "/1/countryE" , produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Integer> getByCountryAndDate (@Valid @RequestParam(value="countryA", required = true)
                                                            String countryA,
                                                            @Valid @RequestParam(value="countryB", required = true)
                                                            String countryB,
                                                            @Valid @RequestParam(value="startTime", required = true)
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            LocalDate startTime,
                                                            @Valid @RequestParam(value="endTime", required = true)
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            LocalDate endTime
    )throws Exception{
        requestValidator.notEqualCountries(countryA,countryB);
        requestValidator.isValidDateRequest(startTime,endTime);
        Integer e = getDetailService.countByCountryAndDate(countryA,countryB,startTime,endTime);
        return new ResponseEntity<>(e , HttpStatus.OK);

    }

}
