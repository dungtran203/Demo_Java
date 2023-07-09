package com.foly.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable{
	@Id
	@NotBlank
	@Column(name = "username")
	String username;

	@NotBlank
	@Column(name = "password")
	String password;

	@Column(name = "fullname")
	String fullname;

	@Column(name = "email")
	String email;

	@Column(name = "photo")
	String photo;

	@Column(name = "active")
	boolean active;

	@Column(name = "admin")
	boolean admin;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
