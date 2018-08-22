package zdk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zdk.bean.Message;
import zdk.dao.MessageMapper;

@Service
public class MsgService {
	
	@Autowired
	MessageMapper messageMapper;

	public void insertMsg(Message msg) {
		Date time = new Date();
		msg.setDateTime(time);
		messageMapper.insertSelective(msg);
	}

	public List<Message> getallmsg() {
		List<Message> msgs = messageMapper.selectByExample(null);
		return msgs;
	}

}
