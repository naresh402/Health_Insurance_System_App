package com.ashokit.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="HIS_MASTER")
@Data
public class HISEntity {
	
	
	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "uid_seq_gen", sequenceName = "USER_ACCOUNT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "uid_seq_gen", strategy = GenerationType.SEQUENCE)
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name = "ACC_STATUS")
	private String accStatus;
	
	@Column(name = "USER_PWD")
	private String userPwd;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;


}
