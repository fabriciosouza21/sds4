package com.fsm.sds4.DTO;

import java.io.Serializable;
import java.util.List;

import com.fsm.sds4.entities.Sale;
import com.fsm.sds4.entities.Seller;

public class SellerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
		
	public SellerDTO() {}

	public SellerDTO(Long id, String name, List<Sale> sales) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public SellerDTO(Seller entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
