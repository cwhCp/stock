<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />
<title>股票交易数据</title>

</head>

<body class="text-center">
	<div style="width:80%;margin:0px auto">
		<s:iterator value="#session.stockTableList" var="stockTable">
			<h2 style="color: blue">
				股票名称:
				<s:property value="#stockTable.name" />
			</h2>
			<s:if test="#stockTable.isWin == 1">
				<h3 style="color: red">
					当前价格:<s:property value="#stockTable.price"/>|<s:property value="#stockTable.bunko" />
				</h3>
			</s:if>
			<s:else>
				<h3 style="color: green">
					当前价格:<s:property value="#stockTable.price"/>|<s:property value="#stockTable.bunko" />
				</h3>
			</s:else>
			<table class="table table-condensed table-bordered">
				<tr>
					<th class="text-center">价格</th>
					<th class="text-center">股数</th>
					<th class="text-center">买卖状态</th>
					<th class="text-center">日期</th>
					<th class="text-center">原因描述</th>
				</tr>
				<s:iterator value="#stockTable.nodes" var="stockNode">
					<tr>
						<td><s:property value="#stockNode.price" /></td>
						<td><s:property value="#stockNode.num" /></td>
						<td><s:property value="#stockNode.state" /></td>
						<td><s:property value="#stockNode.date" /></td>
						<td><s:property value="#stockNode.desc" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:iterator>
	</div>
</body>
</html>
