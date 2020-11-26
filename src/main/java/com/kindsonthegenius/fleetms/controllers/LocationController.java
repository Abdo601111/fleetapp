package com.kindsonthegenius.fleetms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetms.models.Country;
import com.kindsonthegenius.fleetms.models.Location;
import com.kindsonthegenius.fleetms.models.State;
import com.kindsonthegenius.fleetms.services.CountryService;
import com.kindsonthegenius.fleetms.services.LocationService;
import com.kindsonthegenius.fleetms.services.StateService;


@Controller

public class LocationController {
	
	
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private LocationService locationService;
	@GetMapping("locations")
	public String findAll(Model model){
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());

		return "location";
	}
	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		
		locationService.save(location);
		return "redirect:/locations";
		
	}
	
	@RequestMapping("/locations/findById")
	@ResponseBody
	public Optional<Location> getById(int id) {
		
		
		return locationService.findById(id);
		
	}
	
	@RequestMapping(value="/locations/update",method = {RequestMethod.PUT,RequestMethod.GET})
   public String update(Location location) {
		
		locationService.save(location);
		return "redirect:/locations";
		
	}
	
	@RequestMapping(value="/locations/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
	   public String delete(Integer id ) {
			
		locationService.deleteById(id);
			return "redirect:/locations";
			
		}
	
	
	
}