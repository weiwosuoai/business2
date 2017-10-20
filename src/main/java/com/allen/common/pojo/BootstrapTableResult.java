package com.allen.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * bootstrap table 返回值
 * Created by Allen on 2017/9/15.
 */
public class BootstrapTableResult<T> implements Serializable {

	/** 记录总数 */
	private Long total;

	/** 需要显示的数据 */
	private List<T> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
