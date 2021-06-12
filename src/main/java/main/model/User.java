package main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    private String id; // id này sẽ lấy từ firebase


    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    
	public User() {
	}

	public User(String id, String name, String email, String address, String image) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
