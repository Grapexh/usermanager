package com.itheima.usermanager.pojo;

import java.util.List;

/**
 * 订单表
 * 
 */
public class Order {

    private Integer id;

    private Long userId;

    private String orderNumber;

    private User user;
    
    private List<Orderdetail> detailList;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderdetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Orderdetail> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderNumber=" + orderNumber + ", user=" + user
				+ ", detailList=" + detailList + "]";
	}


}
