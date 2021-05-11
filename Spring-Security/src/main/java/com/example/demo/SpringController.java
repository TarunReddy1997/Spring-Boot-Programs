package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/ojas")
public class SpringController {

	@GetMapping("/sayHello")
	@ResponseBody
	public String sayHello() {
		return "hello OJAS";
	}
}
