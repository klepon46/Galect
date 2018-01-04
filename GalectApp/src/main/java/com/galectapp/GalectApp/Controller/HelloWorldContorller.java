package com.galectapp.GalectApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.galectapp.model.Deanship;

@Controller("/helloWorld")
public class HelloWorldContorller {

	public String index() {
		return "index";
	}

	@RequestMapping("/deanship")
	public ModelAndView deanship() {
		Deanship deanship = new Deanship();
		ModelAndView mav = new ModelAndView("deanship", "command", deanship);

		return mav;
	}
}
