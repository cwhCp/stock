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
			 //���Ǯ
			float mIn = 0.0f;
			Integer nIn = 0;
			//����Ǯ
			float mOut = 0.0f; 
			Integer nOut = 0;
			for (StockNode node : stockTable.getNodes()) {
				if(node.getState() =="��"){
					mIn += node.getPrice() * node.getNum();
					nOut += node.getNum();
				}else{
					mOut += node.getPrice() * node.getNum();
					nIn += node.getNum();
				}
			}
			Float mGet = mIn - mOut;
			int sum = nIn - nOut;
			//�������������������������Ҫ��ǰ�۸����
			if(sum > 0){
				//��ǰ�����ж�����ֵ
				Float mCurrent = sum * stockTable.getPrice();
				if((mCurrent + mIn - mOut) >0){
					stockTable.setBunko("ӯ��:" + (mCurrent + mIn - mOut)*100);
					stockTable.setIsWin(1);
				}else{
					stockTable.setBunko("����:" + (mOut - mCurrent - mIn)*100);
					stockTable.setIsWin(0);
				}
			}else if(nIn == nOut){
				//����������������������������Ѿ������ֱ�Ӽ�������				
				if(mGet > 0){
					stockTable.setBunko("ӯ��:" + (mIn - mOut)*100);
					stockTable.setIsWin(1);
				}else{
					stockTable.setBunko("����:" + (mOut - mIn)*100);
					stockTable.setIsWin(0);
				}
			}
			System.out.println(stockTable.getName() + stockTable.getBunko());
		}
		return list;
	}
}
