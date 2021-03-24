package com.screenspace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import java.util.Arrays;
import java.util.Base64;

@Entity
public class imageModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int imageId;
	private String base64Image;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	private String name;
	private long size;
	private String contentType;
	
	
	
	public imageModel() {
		super();
	}
	public imageModel(byte[] image, String uname, long size, String contentType, String name) {
		super();
		this.image = image;
		this.name = name;
		this.size = size;
		this.contentType = contentType;
		this.uname = uname;
	}
	private String uname;
	
	public imageModel(byte[] image, String uname) {
		super();
		this.image = image;
		this.uname = uname;
		
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
		
	}
	@Override
	public String toString() {
		return "size=" + size + ", contentType=" + contentType;
	}
	

	

}
