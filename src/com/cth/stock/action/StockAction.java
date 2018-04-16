package com.cth.stock.action;

import java.util.List;
import java.util.Map;

import com.cth.stock.domain.StockTable;
import com.cth.stock.service.StockService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StockAction  extends ActionSupport{
	private StockService service = new StockService();
	
	public String execute() throws Exception {
		List<StockTable> stockTableList = service.getStockList();
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("stockTableList", stockTableList);
		return SUCCESS;
	}
}
