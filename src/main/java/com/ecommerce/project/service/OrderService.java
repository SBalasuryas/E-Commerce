package com.ecommerce.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.project.entity.AddressEntity;
import com.ecommerce.project.entity.CustomerEntity;
import com.ecommerce.project.entity.OrderAndProductEntity;
import com.ecommerce.project.entity.OrderEntity;
import com.ecommerce.project.entity.ProductEntity;
import com.ecommerce.project.exception.DataNotFound;
import com.ecommerce.project.repository.AddressRepo;
import com.ecommerce.project.repository.CustomerRepo;
import com.ecommerce.project.repository.OrderAndProductRepo;
import com.ecommerce.project.repository.OrderRepo;
import com.ecommerce.project.repository.ProductRepo;
import com.ecommerce.project.request.OrderAndProductRequest;
import com.ecommerce.project.request.OrderRequest;
import com.ecommerce.project.response.OrderResponse;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());


	private static final String THERE_IS_NO_SUCH_PRODUCT_EXISTS = "There is no such product exists ";

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private OrderAndProductRepo orderProductRepo;

	public List<OrderResponse> findAllOrder() {
		
		logger.info("Finding all the orders");
		
        //warning
       //severe
        
		List<OrderEntity> orders = orderRepo.findAll();
		List<OrderResponse> response = new ArrayList<>();

		for (OrderEntity entity : orders) {
			OrderResponse res = new OrderResponse();
			res.setId(entity.getId());
			res.setCustomer(entity.getCustomer());
			res.setOrderdate(entity.getOrderDate());
			res.setAddress(entity.getAddress());
			res.setTotalprice(entity.getTotalAmount());
			response.add(res);

		}
		logger.info("Finded all the orders");
		return response;

	}

	public OrderResponse findOrderById(int id) {
		Optional<OrderEntity> order = orderRepo.findById(id);
		OrderResponse res = new OrderResponse();

		if (order.isPresent()) {
			OrderEntity orderDetails = order.get();

			res.setId(orderDetails.getId());
			res.setCustomer(orderDetails.getCustomer());
			res.setOrderdate(orderDetails.getOrderDate());
			res.setTotalprice(orderDetails.getTotalAmount());

			logger.info("Finding order by id");
			return res;
		}
		return res;
	}

	@Transactional
	public String addOrder(OrderRequest req) {

		CustomerEntity customer = customerRepo.findById(req.getCustomerId())
				.orElseThrow(() -> new DataNotFound("Customer not found for the id : " + req.getCustomerId()));

		AddressEntity address = addressRepo.findById(req.getAddressId())
				.orElseThrow(() -> new DataNotFound("Address not Found " + req.getAddressId()));

		OrderEntity order = new OrderEntity();
		order.setOrderDate(req.getOrderdate());
		order.setCustomer(customer);
		order.setAddress(address);
		orderRepo.save(order);

		createProducts(req, order);
		float amount = totalPrice(order.getId());
		logger.info("Order is Placed Successfully");
		logger.info("The Total Amount is : "+amount);
		return "Order as Placed And the toatl is " + amount;
	}

	
	private void createProducts(OrderRequest req, OrderEntity order) {

		for (OrderAndProductRequest productQuantity : req.getOrderandproduct()) {
			ProductEntity product = productRepo.findById(productQuantity.getProductId())
					.orElseThrow(() -> new DataNotFound(THERE_IS_NO_SUCH_PRODUCT_EXISTS + productRepo.findById(productQuantity.getProductId())));

			OrderAndProductEntity orderProducts = new OrderAndProductEntity();

			orderProducts.setOrder(order);
			orderProducts.setProduct(product);
			orderProducts.setquantity(productQuantity.getQuantity());
			orderProductRepo.save(orderProducts);

		}
	}

	public float totalPrice(Integer orderId) {

		List<OrderAndProductEntity> orderedProduct = orderProductRepo.findByOrderId(orderId);

		OrderEntity order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException());

		float totalAmount = 0.0f;

		for (OrderAndProductEntity orderedItem : orderedProduct) {
			ProductEntity product = orderedItem.getProduct();
			totalAmount += product.getPrice() * orderedItem.getquantity();
		}

		order.setTotalAmount(totalAmount);
		orderRepo.save(order);
		return totalAmount;

	}

	public Page<OrderResponse> orderPagable(int pageNo, int noOfContent) {
		
		PageRequest page = PageRequest.of(pageNo, noOfContent);
		
		Page<OrderEntity> orders = orderRepo.findAll(page);
		List<OrderResponse> response = new ArrayList<>();
		
		

		for (OrderEntity entity : orders) {
			OrderResponse res = new OrderResponse();
			res.setId(entity.getId());
			res.setCustomer(entity.getCustomer());
			res.setOrderdate(entity.getOrderDate());
			res.setAddress(entity.getAddress());
			res.setTotalprice(entity.getTotalAmount());
			response.add(res);

		}  
		logger.info("Displayed the page : "+pageNo);
		return new PageImpl<>(response, page, orders.getTotalElements());
	}



}





