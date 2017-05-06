package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_user database table.
 * 
 */
@Entity
@Table(name="t_user")
@NamedQuery(name="TUser.findAll", query="SELECT t FROM TUser t")
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date cratedate;

	private String email;

	private String password;

	private String realname;

	private String username;

	public TUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCratedate() {
		return this.cratedate;
	}

	public void setCratedate(Date cratedate) {
		this.cratedate = cratedate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}