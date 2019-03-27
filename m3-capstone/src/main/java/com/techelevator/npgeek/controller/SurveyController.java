package com.techelevator.npgeek.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;

@Controller
public class SurveyController {

	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET) 
	public String showSurvey(ModelMap map) {
		
		if (!map.containsKey("survey")) {
			map.addAttribute("survey", new Survey());
		}
		
		map.addAttribute("parks", parkDao.getAllParks());
		map.addAttribute("stateList", getStateMap());
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, ModelMap map, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			attr.addFlashAttribute("survey", survey);
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		
		surveyDao.insertSurvey(survey);
		
		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String showSurveyResults(ModelMap map) {
		map.addAttribute("results", surveyDao.getSurveyResults());
		return "surveyResults";
	}
	
	
	private Map<String, String> getStateMap() {
		Map<String, String> states = new LinkedHashMap<String, String>();
	    states.put("AK", "Alaska");
	    states.put("AL", "Alabama");
	    states.put("AR", "Arkansas");
	    states.put("AZ", "Arizona");
	    states.put("CA", "California");
	    states.put("CO", "Colorado");
	    states.put("CT", "Connecticut");
	    states.put("DC", "District of Columbia");
	    states.put("DE", "Delaware");
	    states.put("FL", "Florida");
	    states.put("GA", "Georgia");
	    states.put("HI", "Hawaii");
	    states.put("IA", "Iowa");
	    states.put("ID", "Idaho");
	    states.put("IL", "Illinois");
	    states.put("IN", "Indiana");
	    states.put("KS", "Kansas");
	    states.put("KY", "Kentucky");
	    states.put("LA", "Louisiana");
	    states.put("MA", "Massachusetts");
	    states.put("MD", "Maryland");
	    states.put("ME", "Maine");
	    states.put("MI", "Michigan");
	    states.put("MN", "Minnesota");
	    states.put("MO", "Missouri");
	    states.put("MS", "Mississippi");
	    states.put("MT", "Montana");
	    states.put("NC", "North Carolina");
	    states.put("ND", "North Dakota");
	    states.put("NE", "Nebraska");
	    states.put("NH", "New Hampshire");
	    states.put("NJ", "New Jersey");
	    states.put("NM", "New Mexico");
	    states.put("NV", "Nevada");
	    states.put("NY", "New York");
	    states.put("OH", "Ohio");
	    states.put("OK", "Oklahoma");
	    states.put("OR", "Oregon");
	    states.put("PA", "Pennsylvania");
	    states.put("RI", "Rhode Island");
	    states.put("SC", "South Carolina");
	    states.put("SD", "South Dakota");
	    states.put("TN", "Tennessee");
	    states.put("TX", "Texas");
	    states.put("UT", "Utah");
	    states.put("VA", "Virginia");
	    states.put("VT", "Vermont");
	    states.put("WA", "Washington");
	    states.put("WI", "Wisconsin");
	    states.put("WV", "West Virginia");
	    states.put("WY", "Wyoming");
	    states.put("GU", "Guam");
	    states.put("VI", "Virgin Islands");
	    states.put("PR", "Puerto Rico");
	    states.put("AE", "Armed forces - Europe");
	    states.put("AA", "Armed forces - America");
	    states.put("AP", "Armed forces - Pacific");
		return states;
	}
}
