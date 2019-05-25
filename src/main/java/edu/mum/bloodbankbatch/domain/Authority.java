package edu.mum.bloodbankbatch.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Authority {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	private String username;
	@Column(nullable = false)
	private String authority;

	public Authority(){}

	public Authority(String username, String authority){
		this.username = username;
		this.authority = authority;
	}



}

