package com.cth.stock.domain;

import java.util.List;

public class StockTable {
	private Integer id;
	private String name;
	private String nodeXml;
	private List<StockNode> nodes;
	private String bunko;
	private Integer isWin;
	private Float price;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getIsWin() {
		return isWin;
	}

	public void setIsWin(Integer isWin) {
		this.isWin = isWin;
	}

	public String getBunko() {
		return bunko;
	}

	public void setBunko(String bunko) {
		this.bunko = bunko;
	}

	public List<StockNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<StockNode> nodes) {
		this.nodes = nodes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNodeXml() {
		return nodeXml;
	}

	public void setNodeXml(String nodeXml) {
		this.nodeXml = nodeXml;
	}
	
	@Override
	public String toString() {
		return "StockTable [id=" + id + ", name=" + name + ", nodeXml=" + nodeXml + ", nodes=" + nodes + "]";
	}
}
