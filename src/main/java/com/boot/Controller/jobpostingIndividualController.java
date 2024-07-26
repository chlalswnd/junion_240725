package com.boot.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.DTO.Criteria3;
import com.boot.DTO.PageDTO2;
import com.boot.DTO.jobpostingIndividualDTO;
import com.boot.Service.jobpostingIndividualService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class jobpostingIndividualController {

	@Autowired
	private jobpostingIndividualService jobpostingIndividualService;
	
    // 인재풀 리스트
	/*
    @RequestMapping("/jobpostingIndividualSupport")
    public String jobpostingIndividualSupport(Model model, HttpServletRequest request) 
    {
    	log.info("@# jobpostingIndividualSupport");
    	log.info("@# request=>"+request);
    	
    	// 세션에 이메일 담아서 쓰는 법
    	HttpSession session = request.getSession();		
		String login_email = (String)session.getAttribute("login_email");
		char login_usertype = (char)session.getAttribute("login_usertype");
    	String notice_num = (String)session.getAttribute("notice_num"); 
    	log.info("@# login_email=>"+login_email);
    	log.info("@# login_usertype_str=>"+login_usertype);
//    	log.info("@# notice_num=>"+notice_num);
    	
//    	model.addAttribute("login_email",login_email);
    	model.addAttribute("login_usertype",login_usertype);
    	
    	ArrayList<jobpostingIndividualDTO> jobpostingIndividualSupport = jobpostingIndividualService.jobpostingIndividualSupport(null, notice_num);  // 전체로 공개하기때문에 이메일값 null
    	model.addAttribute("jobpostingIndividualSupport",jobpostingIndividualSupport);
    	
    	ArrayList<String> jobList = jobpostingIndividualService.getJobList();
    	model.addAttribute("jobList",jobList);

    	ArrayList<String> locationList = jobpostingIndividualService.getLocationList();
    	model.addAttribute("locationList",locationList);

    	return "jobpostingIndividualSupport";
    }
    */
    
    
    // 인재풀 리스트
    @RequestMapping("/jobpostingIndividualSupport")
    public String jobpostingIndividualSupport(Criteria3 cri, Model model, HttpServletRequest request) 
    {
    	log.info("@# jobpostingIndividualSupport");
    	log.info("@# request=>"+request);
    	
    	// 세션에 유저 정보 담아옴
    	HttpSession session = request.getSession();		
    	String login_email = (String)session.getAttribute("login_email");
    	char login_usertype = (char)session.getAttribute("login_usertype");
//    	String notice_num = (String)session.getAttribute("notice_num");
    	log.info("@# login_email=>"+login_email);
    	log.info("@# login_usertype_str=>"+login_usertype);
//    	log.info("@# notice_num=>"+notice_num);
    	
//    	model.addAttribute("login_email",login_email);
    	model.addAttribute("login_usertype",login_usertype);
    	
    	// 직군/직무 리스트
    	ArrayList<String> stackList = jobpostingIndividualService.getStackList();
    	model.addAttribute("stackList", stackList);
    	
    	// 지역 리스트
    	ArrayList<String> locationList = jobpostingIndividualService.getLocationList();
    	model.addAttribute("locationList",locationList);
    	
    	ArrayList<jobpostingIndividualDTO> jobpostingIndividualSupport = jobpostingIndividualService.jobpostingIndividualSupport(cri);  // 전체로 공개하기때문에 이메일값 null
    	int total = jobpostingIndividualService.getTotalCount();
    	model.addAttribute("jobpostingIndividualSupport",jobpostingIndividualSupport);
    	model.addAttribute("pageMaker", new PageDTO2(total, cri));

    	return "jobpostingIndividualSupport";
    }
    
    
    // =============================  jobpostingIndividual 끝  ==========================
}
