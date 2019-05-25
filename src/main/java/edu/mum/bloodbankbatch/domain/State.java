package edu.mum.bloodbankbatch.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 2, min = 2)
	private String code;
	private String name;

	public State() {}
	public State(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

}
