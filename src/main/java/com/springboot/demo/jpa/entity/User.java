package com.springboot.demo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "t_user", catalog = "demo")
public class User implements Serializable {

  /**
   * @Description: TODO(描述funcion功能) author yuting.li
   * @date 2017年4月30日 下午6:33:40
   * @version 1.0
   */
  private static final long serialVersionUID = -2830410130905084960L;

  private Integer id;

  private String username;

  private String realname;

  private String email;

  @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GMT+8")
  private Date cratedate;

  @JsonIgnore
  private String password;

  @JsonIgnore
  private Set<Role> roles = new HashSet<Role>(0);

  public User() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "username", length = 50)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name = "realname", length = 50)
  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  @Column(name = "email", length = 50)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "cratedate", length = 10)
  public Date getCratedate() {
    return cratedate;
  }

  public void setCratedate(Date cratedate) {
    this.cratedate = cratedate;
  }

  @Column(name = "password", length = 50)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", realname=" + realname + ", cratedate="
        + cratedate
        + ", password=" + password + ", roles=" + roles + "]";
  }


}
