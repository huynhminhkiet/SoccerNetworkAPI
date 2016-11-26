package com.soccernetworkapi.service;

import java.util.ArrayList;

import com.soccernetworkapi.bean.Slot;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface SlotService {
	ArrayList<Slot> getAllSlots();
	ArrayList<Slot> getSlotsByMatchId(int matchId);
	Slot getSlotById(int matchId, int userId);
	StatusRespone createSlot(Slot slot);
	StatusRespone updateSlot(Slot slot);
	StatusRespone deleteSlot(int matchId, int userId);
}
