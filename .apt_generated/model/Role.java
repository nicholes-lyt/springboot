package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_role database table.
 * 
 */
@Entity
@Table(name="t_role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private int uid;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}