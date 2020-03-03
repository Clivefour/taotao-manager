package com.clive.common;

import java.util.List;

public class ItemCatResult {
	private List<?> data;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ItemCatResult [data=" + data + "]";
	}
	
}
