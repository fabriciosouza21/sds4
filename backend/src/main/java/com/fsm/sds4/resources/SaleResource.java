package com.fsm.sds4.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.sds4.DTO.SaleDTO;
import com.fsm.sds4.DTO.SaleSucessDTO;
import com.fsm.sds4.DTO.SaleSumDTO;
import com.fsm.sds4.services.SaleService;
@RestController
@RequestMapping(value = "/sales")
public class SaleResource {

	@Autowired
	private SaleService service;


	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "date") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction
			) {
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction), orderBy);
		Page<SaleDTO> list = service.findAll(pageRequest);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> salesSum = service.amountGroupedBySeller();
		return ResponseEntity.ok(salesSum);
	}
	
	@GetMapping(value = "/sucess-by-seller")
	public ResponseEntity<List<SaleSucessDTO>> sucessGroupedBySeller() {
		List<SaleSucessDTO> salesSum = service.sucessGroupedBySeller();
		return ResponseEntity.ok(salesSum);
	}
	
}