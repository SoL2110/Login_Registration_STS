package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.service.EmailService;
import com.webapp.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService ;
	
	@Autowired
	private EmailService emailService;
	
	//Handler Method
	//http://localhost:8080/view-registration
	
	@RequestMapping("/view-registration")
	public String viewRegistrationPage() {
		return "New_Registration"; //request dispatcher
	}
	
//	@RequestMapping("/saveReg")
//	public String saveRegistration(RegistrationDto registrationDto,ModelMap model) {
//		Registration reg = new Registration();
//		reg.setFirstName(registrationDto.getFirstName());
//		reg.setLastName(registrationDto.getLastName());
//		reg.setEmail(registrationDto.getEmail());
//		reg.setMobile(registrationDto.getMobile());
//		
//		registrationService.createRegistration(reg);
//		model.addAttribute("msg","Record is saved");
//		return "New_Registration";
//	}
	
	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute Registration registration,ModelMap model) {
		registrationService.createRegistration(registration);
		emailService.sendEmail(registration.getEmail(),"Test", "Hi There");
		model.addAttribute("msg","Record is saved");
		return "New_Registration";	
	}
	
	//http://localhost:8080/all-registrations
	@RequestMapping("/all-registrations")
	public String getAllResgistrations(Model model) {
		List<Registration> reg = registrationService.getRegistrations();
		model.addAttribute("registrations", reg);
		return "all_registrations";	
		
	}
	
	//http://localhost:8080/delete-registrations?id=1 
	@RequestMapping("/delete-registration")
	public String deleteRegistration(@RequestParam long id, Model model) {
		registrationService.deleteRegistration(id);
		List<Registration> reg = registrationService.getRegistrations();
		model.addAttribute("registrations", reg);
		return "all_registrations";
	}
	
	//http://localhost:8080/update-registrations
	@RequestMapping("/update-registration")
	public String updateRegistration(@RequestParam long id, Model model) {
		Registration registration = registrationService.getRegistrationById(id);
		model.addAttribute("registration", registration);
		return "update_registration";
	}
	
	
	@RequestMapping("/updateRegRecord")
	public String updateRegRecord(RegistrationDto dto, Model model) {
		
		Registration registration = new Registration();		
		registration.setId(dto.getId());
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		
		registrationService.updateRegRecord(registration);
		
		List<Registration> reg = registrationService.getRegistrations();
		model.addAttribute("registrations", reg);
		return "all_registrations";
	}
	
}
