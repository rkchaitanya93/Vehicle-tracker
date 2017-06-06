package io.krishna.controller;

import io.krishna.entity.Readings;
import io.krishna.entity.Vehicle;
import io.krishna.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Krishna on 6/5/2017.
 */

@RestController
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.PUT, value="vehicles",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicle){
        for(int i=0; i<vehicle.size();i++){
            Vehicle newVehicle = vehicle.get(i);
            String vin = newVehicle.getVin();
            service.update(vin,newVehicle);
        }
        return vehicle;
    }

    @RequestMapping(method = RequestMethod.POST, value="readings",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings update(@RequestBody Readings reading){
        System.out.println("start");
        service.addReading(reading);
        return reading;
    }

}
