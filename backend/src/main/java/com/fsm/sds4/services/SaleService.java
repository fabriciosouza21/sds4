package com.fsm.sds4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.sds4.DTO.SaleDTO;
import com.fsm.sds4.DTO.SaleSucessDTO;
import com.fsm.sds4.DTO.SaleSumDTO;
import com.fsm.sds4.entities.Sale;
import com.fsm.sds4.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	SaleRepository repository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(PageRequest pageRequest) {
		Page<Sale> sales = repository.findAll(pageRequest);
		return sales.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller (){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupedBySeller (){
		return repository.sucessGroupedBySeller();
	}
}

	

