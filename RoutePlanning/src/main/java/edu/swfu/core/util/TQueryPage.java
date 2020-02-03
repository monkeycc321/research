package edu.swfu.core.util;

import java.util.List;
import java.util.Map;

public class TQueryPage {
	private int page;
	private int size;

	private List<Map<String,Object>> datas;
	private long total;
	
	public TQueryPage() {
		
	}
	
	public TQueryPage(List<Map<String,Object>> datas, long total, int page, int size) {
		this.datas=datas;
		this.total=total;
		this.page=page;
		this.size=size;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Map<String, Object>> getDatas() {
		return datas;
	}
	public void setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

}
