package in.rdsit.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.rdsit.binding.DashboardResponse;
import in.rdsit.binding.EnquiryForm;
import in.rdsit.binding.EnquirySearchCriteria;
import in.rdsit.entity.StudentEnqEntity;
import in.rdsit.service.EnquiryServiceImpl;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	

	@Autowired
	private EnquiryServiceImpl enqService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		Integer userId=(Integer)session.getAttribute("userId");
		DashboardResponse dashboardData=enqService.getDashboardData(userId);
		model.addAttribute("dashboardData", dashboardData);
		return "dashboard";
	}

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {
		
		//getCourse from database
		List<String> courseName=enqService.getCourses();
		//getCourseMode from databse
		List<String> enqStatus=enqService.getEnqStatuses();
		//creating Binding class Object
		EnquiryForm formObj=new EnquiryForm();
		//set data in model object
		model.addAttribute("formObj",formObj);
		model.addAttribute("courseName",courseName);
		model.addAttribute("enqStatus",enqStatus);
		return "add-enquiry";
	}
	
	@PostMapping("/addEnq")
	public String addEnquiry(@ModelAttribute("fromObj") EnquiryForm form,Model model) {
		boolean status =enqService.saveEnquiry(form);
		
		if(status) {
			model.addAttribute("sucMsg", "Enquiry Added succesfully");
		}
		else {
			model.addAttribute("errMsg", "Problem Occured");
		}
		return "add-enquiry";
	}
	
	public void initModel(Model model) {
		
		EnquiryForm formObj=new EnquiryForm();
		List<String> courses=enqService.getCourses();
		List<String> enqstatus=enqService.getEnqStatuses();
		
		model.addAttribute("courseName", courses);
		model.addAttribute("statusName", enqstatus);
		model.addAttribute("formObj", formObj);
	}
	
	@GetMapping("/enquiries")
	public String viewEnquiriesPage(Model model) {
		initModel(model);
		model.addAttribute("searchForm",new EnquirySearchCriteria());
		List<StudentEnqEntity> enquiries=enqService.getEnquiries();
		model.addAttribute("enquiries",enquiries);
		return "view-Enquiries";
	}
	
	@GetMapping("/filter-enquiries")
	public String filterEnquiries(@RequestParam String cname,@RequestParam String status,@RequestParam String mode,Model model) {
		EnquirySearchCriteria criteria =new EnquirySearchCriteria();
		criteria.setCourseName(cname);
		criteria.setClassMode(mode);
		criteria.setEnqStatus(status);
		
		Integer userId=(Integer)session.getAttribute("userId");
		List<StudentEnqEntity> enquiries=enqService.getFilteredEnqs(criteria, userId);
		model.addAttribute("filteredenquiries", enquiries);
		return "filter-enquiries-page";	
	}
}
