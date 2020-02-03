package edu.swfu.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TQueryPara {
	private List<TQueryExp> exps;

	/**
	 * 特殊指定查询条件表达式
	 */
	private List<TQueryExp> specExps;

	private Map<String, Object> specVal;

	public TQueryPara() {
		this.exps = new ArrayList<>();
		this.specExps = new ArrayList<>();
		this.specVal = new HashMap<>();
	}

	public List<TQueryExp> getExps() {
		return exps;
	}

	public void setExps(List<TQueryExp> exps) {
		this.exps = exps;
	}

	public List<TQueryExp> getSpecExps() {
		return specExps;
	}

	public void setSpecExps(List<TQueryExp> specExps) {
		this.specExps = specExps;
	}

	public void addExp(String cond, Object value) {
		if (cond.endsWith("_lessThan")) {
			this.exps.add(new TQueryExp(cond.replaceFirst("_lessThan", ""),
					" <= ", value));
		} else if (cond.endsWith("_moreThan")) {
			this.exps.add(new TQueryExp(cond.replaceFirst("_moreThan", ""),
					" >= ", value));
		} else if (cond.endsWith("_unequalTo")) {
			this.exps.add(new TQueryExp(cond.replaceFirst("_unequalTo", ""),
					"!=", value));
		} else if (cond.endsWith("_like")) {
			if (value.toString().indexOf("%") < 0) {
				String pValue = "%" + value + "%";
				this.exps.add(new TQueryExp(cond.replaceFirst("_like", ""),
						" like ", pValue));
			} else {
				this.exps.add(new TQueryExp(cond.replaceFirst("_like", ""),
						" like ", value));
			}
		} else if (cond.endsWith("_in")) {
			this.exps.add(new TQueryExp(cond.replaceFirst("_in", ""), "in",
					value.toString().split(",")));
		} else {
			this.exps.add(new TQueryExp(cond, " = ", value));
		}
	}

	public void moveToSpecExps(String key) {
		for (TQueryExp exp : exps) {
			if (key != null && key.equals(exp.getKey())) {
				this.specExps.add(exp);
				this.exps.remove(exp);
				break;
			}
		}
	}

	public void addSpecVal(String key, Object val) {
		this.specVal.put(key, val);
	}

}
