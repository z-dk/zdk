package zdk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zdk.bean.Message;
import zdk.bean.Msg;
import zdk.service.MsgService;

@Controller
public class MsgController {
	
	@Autowired
	MsgService msgService;

	@ResponseBody
	@RequestMapping(value="/commitmsg",method=RequestMethod.POST)
	public Msg addMessage(Message msg) {
		msgService.insertMsg(msg);
		return Msg.success();
	}
}
