package com.brillio.Recommendation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recommended")
public class Recommended {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mbid;
	private String name;
	private String url;
	private int listeners;
	private int playcount;
	private String userEmail;

	public Recommended() {

	}

	public Recommended(int id, String mbid, String name, String url, int listeners, int playcount, String userEmail) {
		super();
		this.id = id;
		this.mbid = mbid;
		this.name = name;
		this.url = url;
		this.listeners = listeners;
		this.playcount = playcount;
		this.userEmail = userEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getListeners() {
		return listeners;
	}

	public void setListeners(int listeners) {
		this.listeners = listeners;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Recommended [id=" + id + ", mbid=" + mbid + ", name=" + name + ", url=" + url + ", listeners="
				+ listeners + ", playcount=" + playcount + ", userEmail=" + userEmail + "]";
	}

}