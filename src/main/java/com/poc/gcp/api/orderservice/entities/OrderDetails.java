package com.poc.gcp.api.orderservice.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.cloud.gcp.data.firestore.Document;

import com.google.cloud.firestore.annotation.DocumentId;

@Document(collectionName = "orderDetails")
public class OrderDetails {

	@DocumentId
	private String documentId;
	private Long orderId;
	private List<String> items;
	private String orderNotes;
	private Long orderNo;
	private String orderComplete;
	private String tentativeDeliveryDate;
	private UserInformation userInformation;

	public OrderDetails() {
		items = new ArrayList<String>();
	}

	public Long getOrderId() {
		return orderId;
	}

	public OrderDetails(String documentId, Long orderId, List<String> items, String orderNotes, Long orderNo,
			String orderComplete, String tentativeDeliveryDate) {
		super();
		this.documentId = documentId;
		this.orderId = orderId;
		this.items = items;
		this.orderNotes = orderNotes;
		this.orderNo = orderNo;
		this.orderComplete = orderComplete;
		this.tentativeDeliveryDate = tentativeDeliveryDate;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderComplete() {
		return orderComplete;
	}

	public void setOrderComplete(String orderComplete) {
		this.orderComplete = orderComplete;
	}

	public String getTentativeDeliveryDate() {
		return tentativeDeliveryDate;
	}

	public void setTentativeDeliveryDate(String tentativeDeliveryDate) {
		this.tentativeDeliveryDate = tentativeDeliveryDate;
	}

	
	  public UserInformation getUserInformation() { return userInformation; }
	  
	  public void setUserInformation(UserInformation userInformation) {
	  this.userInformation = userInformation; }
	 

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", items=" + items + ", orderNotes=" + orderNotes + ", orderNo="
				+ orderNo + ", orderComplete=" + orderComplete + ", tentativeDeliveryDate=" + tentativeDeliveryDate
				+  ", userInformation=" + userInformation +  "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentId, items, orderComplete, orderId, orderNo, orderNotes, tentativeDeliveryDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return Objects.equals(documentId, other.documentId) && Objects.equals(items, other.items)
				&& Objects.equals(orderComplete, other.orderComplete) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(orderNo, other.orderNo) && Objects.equals(orderNotes, other.orderNotes)
				&& Objects.equals(tentativeDeliveryDate, other.tentativeDeliveryDate);
	}

}
