package com.dummy.networkapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	// @ManyToMany To UserGroup
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column(name="user_name")
	String userName;
	
	@Column
	String email;
	
	// What is infotext?
	@Column
	String selfIntroduction;
	
}
