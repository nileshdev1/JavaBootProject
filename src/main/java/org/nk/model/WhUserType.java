package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="whuser_tab")
public class WhUserType {

	@Id
	@GeneratedValue
	@Column(name="user_type_id_col")
	private Integer user_Type_Id;
	@Column(name="user_type_col")
	private String user_type;
	@Column(name="user_code_col")
	private String user_Code;
	@Column(name="user_for_col")
	private String user_For;
	@Column(name="user_email_col")
	private String user_Email;
	@Column(name="user_contact_col")
	private String user_Contact;
	@Column(name="user_id_col")
	private String user_id_type;
	@Column(name="user_other_col")
	private String other_id;
	@Column(name="user_id_number_col")
	private String id_Number;
	
}
