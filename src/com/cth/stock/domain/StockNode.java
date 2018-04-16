package com.cth.stock.domain;

import java.util.Date;

public class StockNode {
	// 自己的id
	private Integer id;
	// 所属表的id
	private Integer pid;
	// 价格
	private Float price;
	// 数量
	private Integer num;
	// 状态 1是买 0是卖
	private Integer state;
	// 交易的日期
	private String date;
	// 交易的原因描述
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getState() {
		return state == 0?"卖":"买";
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "StockNode [id=" + id + ", pid=" + pid + ", price=" + price + ", num=" + num + ", state=" + state
				+ ", date=" + date + ", desc=" + desc + "]";
	}
}
