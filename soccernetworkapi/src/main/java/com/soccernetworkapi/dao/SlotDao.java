package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.Slot;

public interface SlotDao {
	ArrayList<Slot> getAllSlots();
	Slot getSlotById(int matchId, int userId);
	ArrayList<Slot> getSlotByMatchId(int matchId);
	int createSlot(Slot slot);
	int updateSlot(Slot slot);
	int deleteSlot(int matchId, int userId);
}
