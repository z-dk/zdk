package zdk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zdk.bean.Message;
import zdk.service.MsgService;

@Controller
public class IndexController {
	
	@Autowired
	MsgService msgService;
	
	@RequestMapping("/tomessage")
	public ModelAndView tomessage() {
		ModelAndView mv = new ModelAndView();
		List<Message> msgs = msgService.getallmsg();
		mv.addObject("msgs", msgs);
		mv.setViewName("message");
		return mv;
	}

	@RequestMapping("/learning")
	public ModelAndView learning() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("learning");
		return mv;
		
	}
}
