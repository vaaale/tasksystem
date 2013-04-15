package org.inmeta.tasksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}

    /*
	@RequestMapping(value="/index.html")
	public ModelAndView index(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}
	*/

    @RequestMapping(value="/{page}.html")
   	public ModelAndView rootPages(@PathVariable("page") final String page) throws IOException{
   		return new ModelAndView(page);
   	}

    @RequestMapping(value="/wizard/{page}.html")
   	public ModelAndView wizardPages(@PathVariable("page") final String page) throws IOException{
   		return new ModelAndView("wizard/" + page);
   	}

	@RequestMapping(value="/partials/{page}.html")
	public ModelAndView partial(@PathVariable("page") final String page) throws IOException{
		return new ModelAndView("partials/" + page);
	}

	@RequestMapping(value="/wizard/partials/{page}.html")
	public ModelAndView wizardPartial(@PathVariable("page") final String page) throws IOException{
		return new ModelAndView("wizard/partials/" + page);
	}
}
