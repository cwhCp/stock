package com.cth.stock.domain;

import java.util.Date;

public class StockNode {
	// �Լ���id
	private Integer id;
	// �������id
	private Integer pid;
	// �۸�
	private Float price;
	// ����
	private Integer num;
	// ״̬ 1���� 0����
	private Integer state;
	// ���׵�����
	private String date;
	// ���׵�ԭ������
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
		return state == 0?"��":"��";
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
