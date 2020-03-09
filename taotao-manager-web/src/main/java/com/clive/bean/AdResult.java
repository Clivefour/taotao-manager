package com.clive.bean;

public class AdResult {
	private String srcB;
	private Integer height;
	private String alt;
	private Integer width;
	private String src;
	private String href;
	private Integer widthB;
	private Integer heightB;
	
	public Integer getWidthB() {
		return widthB;
	}
	public void setWidthB(Integer widthB) {
		this.widthB = widthB;
	}
	public String getSrcB() {
		return srcB;
	}
	public void setSrcB(String srcB) {
		this.srcB = srcB;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getHeightB() {
		return heightB;
	}
	public void setHeightB(Integer heightB) {
		this.heightB = heightB;
	}
	@Override
	public String toString() {
		return "AdResult [srcB=" + srcB + ", height=" + height + ", alt=" + alt + ", width=" + width + ", src=" + src
				+ ", href=" + href + ", widthB=" + widthB + ", heightB=" + heightB + "]";
	}
	
	
}
