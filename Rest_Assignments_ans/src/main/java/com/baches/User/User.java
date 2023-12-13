package com.baches.User;



import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	
	private String first_name;
	private String last_name;
	private String street;
	private  String address;
	private String City;
	private String state;
	
	private String email;
	private String phone;
	
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", street="
				+ street + ", address=" + address + ", City=" + City + ", state=" + state + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	
	
	

}
