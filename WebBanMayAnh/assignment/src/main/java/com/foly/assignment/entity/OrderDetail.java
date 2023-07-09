package com.foly.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orderdetails")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "price")
	private Float price;

	@Column(name = "quantity")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;

}
