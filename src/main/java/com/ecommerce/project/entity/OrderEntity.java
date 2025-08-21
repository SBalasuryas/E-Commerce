package com.ecommerce.project.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_ORDER")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "TOTAL_AMOUNT")
	private float totalAmount;
	
	
//	customer (reference to Customer)
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	private CustomerEntity customer;
	
	
//	products (list of Products)
//
//	
//	deliveryAddress (reference to Address)
	@OneToOne
	@JoinColumn(name = "DELIVERY_ADDRESS_ID", referencedColumnName = "ID")
	private AddressEntity address;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}


	public AddressEntity getAddress() {
		return address;
	}


	public void setAddress(AddressEntity address) {
		this.address = address;
	}



	

}
