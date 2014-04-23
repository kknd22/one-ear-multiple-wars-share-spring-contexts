package com.interface21.sample.multiplecontexts.web1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.interface21.sample.multiplecontexts.service.SampleService;


@Controller
public class SampleController1 {
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping("home")
	public String loadHomePage(Model m) {
		System.out.println ("++++++++++       1111111111  in SampleController1.............");
		m.addAttribute("name", sampleService.getSimpleProp());
		return "home";
	}
}
