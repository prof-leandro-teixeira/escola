package com.crudescola.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Pagecontroller {
	
	@Controller
	public class PageController {

	    @GetMapping("/page")
	    public String index() {
	        return "index.html";
	    }

	}

}
