package com.pariuri.springboot.service;

import com.pariuri.springboot.model.Bet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BetService {
	List<Bet> getAllBets();
	void saveBet(Bet bet);
	Bet getBetById(long id);
	void deleteBetById(long id);
	Page<Bet> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
