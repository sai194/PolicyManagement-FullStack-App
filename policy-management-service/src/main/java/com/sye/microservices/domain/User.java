package com.sye.microservices.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

	@Entity
	@Table(name = "user")
	//@EqualFields(baseField = "password", matchField = "confirmPassword")
	public class User {

	    @Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", confirmPassword="
					+ confirmPassword + ", name=" + name + ", lastName=" + lastName + ", active=" + active + ", roles="
					+ roles + "]";
		}

		@Id
	    @GeneratedValue
	    @Column(name = "user_id")
	    private int id;
	    @Column(name = "user_name")
	    
	    private String userName;
	    @Column(name = "password")
	    
	    private String password;
	    @Transient
		private String confirmPassword;
	    @Column(name = "name")
	   
	    private String name;
	    @Column(name = "last_name")
	   
	    private String lastName;
	    @Column(name = "active")
	    private int active;
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		
		
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public User(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}
		public User(String userName, String password, String name, String lastName) {
			super();
			this.userName = userName;
			this.password = password;
			this.name = name;
			this.lastName = lastName;
		}
		
		public User() {
			super();
			
		}
	    
	    

}
