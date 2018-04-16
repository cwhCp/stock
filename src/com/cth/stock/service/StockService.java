package com.cth.stock.service;

import java.util.List;

import com.cth.stock.dao.StockDAO;
import com.cth.stock.domain.StockNode;
import com.cth.stock.domain.StockTable;

public class StockService {
	private StockDAO dao = new StockDAO();

	public List<StockTable> getStockList(){
		List<StockTable> list = dao.getStockList();
		for (StockTable stockTable : list) {
			 //入的钱
			float mIn = 0.0f;
			Integer nIn = 0;
			//出的钱
			float mOut = 0.0f; 
			Integer nOut = 0;
			for (StockNode node : stockTable.getNodes()) {
				if(node.getState() =="卖"){
					mIn += node.getPrice() * node.getNum();
					nOut += node.getNum();
				}else{
					mOut += node.getPrice() * node.getNum();
					nIn += node.getNum();
				}
			}
			Float mGet = mIn - mOut;
			int sum = nIn - nOut;
			//买入的数量大于卖出的数量需要当前价格计算
			if(sum > 0){
				//当前还持有多少市值
				Float mCurrent = sum * stockTable.getPrice();
				if((mCurrent + mIn - mOut) >0){
					stockTable.setBunko("盈利:" + (mCurrent + mIn - mOut)*100);
					stockTable.setIsWin(1);
				}else{
					stockTable.setBunko("亏损:" + (mOut - mCurrent - mIn)*100);
					stockTable.setIsWin(0);
				}
			}else if(nIn == nOut){
				//买入的数量等于卖出的数量买卖已经完结了直接计算收入				
				if(mGet > 0){
					stockTable.setBunko("盈利:" + (mIn - mOut)*100);
					stockTable.setIsWin(1);
				}else{
					stockTable.setBunko("亏损:" + (mOut - mIn)*100);
					stockTable.setIsWin(0);
				}
			}
			System.out.println(stockTable.getName() + stockTable.getBunko());
		}
		return list;
	}
}
