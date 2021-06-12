package main.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String id_order;
	
	@Column(name = "user_id")
    private String userId;

    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "status")
    private String status;

    @Column(name = "total_price")
    private Long totalPrice;
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "id_order" ,referencedColumnName = "id_order")
	private List<OrderPet> listOrder = new ArrayList<>();

    
    @PrePersist
	void createActiveAndTime() {
		this.createAt = Instant.now();
	}
    
	public Order() {
		
	}

	public Order(String id_order, String userId, Instant createAt, String status, Long totalPrice,
			List<OrderPet> listOrder) {
		super();
		this.id_order = id_order;
		this.userId = userId;
		this.createAt = createAt;
		this.status = status;
		this.totalPrice = totalPrice;
		this.listOrder = listOrder;
	}

	public String getId_order() {
		return id_order;
	}

	public void setId_order(String id_order) {
		this.id_order = id_order;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Instant getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Instant createAt) {
		this.createAt = createAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderPet> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<OrderPet> listOrder) {
		this.listOrder = listOrder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
}
