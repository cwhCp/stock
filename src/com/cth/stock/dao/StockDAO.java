package com.cth.stock.dao;

import java.util.ArrayList;
import java.util.List;

import com.cth.stock.domain.StockNode;
import com.cth.stock.domain.StockTable;
import com.cth.stock.utils.Utils;

public class StockDAO {
	
	public List<StockTable> getStockList(){
		//∂¡»°nodeTable
		List<StockTable> stockTables = Utils.parserStockTable("stockTables.xml");
		for (StockTable stockTable : stockTables) {
			List<StockNode> stockNodes = Utils.parserStockNode(stockTable.getNodeXml());
			stockTable.setNodes(stockNodes);
		}
		return stockTables;
	}
}
