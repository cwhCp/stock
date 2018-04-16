package com.cth.stock.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.SAXParser;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cth.stock.domain.StockNode;
import com.cth.stock.domain.StockTable;

public class Utils<T> {

	/**
	 * �ݹ�������и��ڵ㡢�ӽڵ�
	 * 
	 * @param ele
	 */
	public static void _parserNode(Element ele) {

		System.out.println(ele.getName() + ":" + ele.getText().trim());
		// ��Users���ڵ㿪ʼ������������=ֵ������ʽ��Ϊһ��Attribute����洢��List������
		List<Attribute> attrList = ele.attributes();
		for (Attribute attr : attrList) {
			// ÿѭ��һ�Σ������˽ڵ��һ��������=ֵ����û���������
			String name = attr.getName();
			String value = attr.getValue();
			System.out.println(name + "=" + value);
		}
		List<Element> eleList = ele.elements();
		// �ݹ�������ڵ��µ������ӽڵ�
		for (Element e : eleList) {
			_parserNode(e);
		}
	}

	/*
	<?xml version="1.0" encoding="UTF-8"?>
		<RESULT>
			<VALUE>
				<NO>A1234</NO>
				<ADDR>�Ĵ�ʡXX��XX��XX·X��XX��</ADDR>
			</VALUE>
			<VALUE>
				<NO>B1234</NO>
				<ADDR>�Ĵ�ʡXX��XX��XX��XX��</ADDR>
			</VALUE>
		</RESULT>
	public static void parserNode(String path) {
		try {
			File file = new File(path);
			SAXReader reader = new SAXReader();
			// ��ȡxml�ļ���Document��
			Document doc = reader.read(file);
			// ��ȡxml�ļ��ĸ��ڵ�
			Element rootElement = doc.getRootElement();
			// ����һ��Element���ڱ���
			Element fooElement;
			// �����������С�VALUE���Ľڵ�
			for (Iterator i = rootElement.elementIterator("VALUE"); i.hasNext();) {
				fooElement = (Element) i.next();
				System.out.println("���ƺţ�" + fooElement.elementText("NO"));
				System.out.println("������" + fooElement.elementText("ADDR"));
			}
			System.out.println(rootElement.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	 */
	public static List<StockTable> parserStockTable(String path) {
		path = Thread.currentThread().getContextClassLoader().getResource(".").getPath() + path;
		List<StockTable> stockTables= new ArrayList<StockTable>();
		try {
			File file = new File(path);
			SAXReader reader = new SAXReader();
			// ��ȡxml�ļ���Document��
			Document doc = reader.read(file);
			// ��ȡxml�ļ��ĸ��ڵ�
			Element rootElement = doc.getRootElement();
			// ����һ��Element���ڱ���
			Element fooElement;
			// �����������С�VALUE���Ľڵ�
			for (Iterator i = rootElement.elementIterator("table"); i.hasNext();) {
				StockTable stockTable = new StockTable();
				fooElement = (Element) i.next();
				
				String sId = fooElement.attributeValue("id");
				String sName =  fooElement.elementText("name");
				String sPrice =  fooElement.elementText("price");
				String sNodeXml =  fooElement.elementText("nodeXml");
				
				stockTable.setId(Integer.valueOf(sId));
				stockTable.setName(sName);
				stockTable.setPrice(Float.valueOf(sPrice));
				stockTable.setNodeXml(sNodeXml);
				stockTables.add(stockTable);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stockTables;
	}
	
	public static List<StockNode> parserStockNode(String path) {
		List<StockNode> stockTables= new ArrayList<StockNode>();
		try {
			path = Thread.currentThread().getContextClassLoader().getResource("/").getPath() + path;
			File file = new File(path);
			SAXReader reader = new SAXReader();
			// ��ȡxml�ļ���Document��
			Document doc = reader.read(file);
			// ��ȡxml�ļ��ĸ��ڵ�
			Element rootElement = doc.getRootElement();
			// ����һ��Element���ڱ���
			Element fooElement;
			// �����������С�VALUE���Ľڵ�
			for (Iterator i = rootElement.elementIterator("stock"); i.hasNext();) {
				StockNode stockNode = new StockNode();
				fooElement = (Element) i.next();
				
				String sId = fooElement.attributeValue("id");
				String sPid =  fooElement.elementText("pid");
				String sPrice =  fooElement.elementText("price");
				String sNum =  fooElement.elementText("num");
				String sState =  fooElement.elementText("state");
				String sDate =  fooElement.elementText("date");
				String sDesc =  fooElement.elementText("desc");
				
				stockNode.setId(Integer.valueOf(sId));
				stockNode.setPid(Integer.valueOf(sPid));
				stockNode.setPrice(Float.valueOf(sPrice));
				stockNode.setNum(Integer.valueOf(sNum));
				stockNode.setState(Integer.valueOf(sState));
				stockNode.setDate(sDate);
				stockNode.setDesc(sDesc);
				
				stockTables.add(stockNode);
				System.out.println(stockNode);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stockTables;
	}
}