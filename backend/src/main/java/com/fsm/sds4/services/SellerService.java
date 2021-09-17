package com.fsm.sds4.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.sds4.DTO.SellerDTO;
import com.fsm.sds4.entities.Seller;
import com.fsm.sds4.repositories.SellerRepository;



@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SellerDTO> findAll(PageRequest pageRequest) {
		Page<Seller> sellers = repository.findAll(pageRequest);
		return sellers.map(x -> new SellerDTO(x));
	}	
}