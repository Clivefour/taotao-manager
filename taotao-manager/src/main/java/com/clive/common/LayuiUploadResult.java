package com.clive.common;

public class LayuiUploadResult {
	private Integer code;
	private String msg;
	private Data data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "LayuiUploadResult [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
