package com.karandodeja.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@ManyToOne
	private User user;
	private String imge;
	private String desc;
	private boolean bagetarin;
	private LocalDateTime createdAt;
	private List<Long> Linked = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImge() {
		return imge;
	}
	public void setImge(String imge) {
		this.imge = imge;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isBagetarin() {
		return bagetarin;
	}
	public void setBagetarin(boolean bagetarin) {
		this.bagetarin = bagetarin;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<Long> getLinked() {
		return Linked;
	}
	public void setLinked(List<Long> linked) {
		Linked = linked;
	}
	
	
}
