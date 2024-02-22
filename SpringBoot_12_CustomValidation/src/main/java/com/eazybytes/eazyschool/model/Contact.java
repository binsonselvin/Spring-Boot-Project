package com.eazybytes.eazyschool.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
@Data annotation is provided by Lombok library which generates getter, setter,
equals(), hashCode(), toString() methods & Constructor at compile time.
This makes our code short and clean.
* */
@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_msg_seq")
	@SequenceGenerator(sequenceName = "contact_msg_seq",initialValue = 1,allocationSize = 1,  name = "contact_msg_seq")
	private int contactId;
	
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, message="Name must be atleast 3 characters long")
    private String name;
	
	@NotBlank(message="Mobile Number cannot be blank")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNum;
	
	@NotBlank(message="Email cannot be blank")
	@Email(message = "Please provide a valid email address")
    private String email;
	
	@NotBlank(message="Subject cannot be blank")
	@Size(min=5 , message="Subject must be atleast 5 characters long")
    private String subject;
	
	@NotBlank(message="Message cannot be blank")
	@Size(min=10 , message="Message must be atleast 10 characters long")
    private String message;
	
	private String status;
}
