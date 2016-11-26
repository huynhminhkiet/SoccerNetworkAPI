package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.Slot;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.SlotDaoImpl;
import com.soccernetworkapi.service.SlotService;

@RestController
public class SlotServiceImpl implements SlotService{

	SlotDaoImpl slotDaoImpl = new SlotDaoImpl(MyDataSource.getInstance().getDataSource());
	
	@Override
	@RequestMapping(value = "/slots", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Slot> getAllSlots() {
		ArrayList<Slot> slots = slotDaoImpl.getAllSlots();
		return slots;
	}

	@Override
	@RequestMapping(value = "/slots/{matchId}/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Slot getSlotById(@PathVariable int matchId, @PathVariable int userId) {
		return slotDaoImpl.getSlotById(matchId, userId);
	}

	@Override
	@RequestMapping(value = "/slots", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createSlot(@RequestBody Slot slot) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (slotDaoImpl.createSlot(slot) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/slots", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StatusRespone updateSlot(@RequestBody Slot slot) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (slotDaoImpl.updateSlot(slot) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/slots/{matchId}/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteSlot(@PathVariable int matchId, @PathVariable int userId) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (slotDaoImpl.deleteSlot(matchId, userId) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/slots/{matchId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Slot> getSlotsByMatchId(@PathVariable int matchId) {
		return slotDaoImpl.getSlotByMatchId(matchId);
	}

}
