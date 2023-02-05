package com.pariuri.springboot.service;

import com.pariuri.springboot.model.Bet;
import com.pariuri.springboot.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetServiceImpl implements BetService {

	@Autowired
	private BetRepository betRepository;

	@Override
	public List<Bet> getAllBets() {
		return betRepository.findAll();
	}

	@Override
	public void saveBet(Bet bet) {
		this.betRepository.save(bet);
	}



	@Override
	public Bet getBetById(long id) {
		Optional<Bet> optional = betRepository.findById(id);
		Bet bet = null;
		if (optional.isPresent()) {
			bet = optional.get();
		} else {
			throw new RuntimeException(" bet not found for id :: " + id);
		}
		return bet;
	}

	@Override
	public void deleteBetById(long id) {
		this.betRepository.deleteById(id);
	}

	@Override
	public Page<Bet> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.betRepository.findAll(pageable);
	}
}
