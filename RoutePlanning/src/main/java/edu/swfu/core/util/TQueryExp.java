package edu.swfu.core.util;

public class TQueryExp {
	private String key;
	private String op;
	private Object val;

	public TQueryExp() {
		//无参的构造函数
	}
	
	public TQueryExp(String key,String op,Object val){
		this.key=key;
		this.op=op;
		this.val=val;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Object getVal() {
		return val;
	}
	public void setVal(Object val) {
		this.val = val;
	}
}