<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ page import="com.usr.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��ʾ��Ϣ</title>
	</head>

	<body>
		<div align="center">
		  	<div class="div1">
		  		<div class="top">��ʾ��Ϣ</div>
		  		<div class="bottom">
					<div class="div2">
				  		<ul>
				  			<li><a href="reg.jsp">�û�ע��</a></li>
				  			<li><a href="login.jsp">�û���¼</a></li>
				  			<li><a href="message.jsp">��ǰ�û�</a></li>
				  		</ul>
				  	</div>
				  	 <div class="div3">
					    <%
					    	// ��ȡ��ʾ��Ϣ
							String info = (String)request.getAttribute("info");
					    	// �����ʾ��Ϣ��Ϊ�գ��������ʾ��Ϣ
							if(info != null){
								out.println(info);
							}
					    	// ��ȡ��¼���û���Ϣ
							User user = (User)session.getAttribute("user");
					    	// �ж��û��Ƿ��¼
							if(user != null){
						%>
						<table align="center" width="350" border="1" height="200" bordercolor="#E8F4CC">
							<tr>
					    		<td align="center" colspan="2">
					    			<span style="font-weight: bold;font-size: 18px;"><%=user.getUsername() %></span>
					    			��¼�ɹ���
					    		</td>
					    	</tr>
						</table>
						<%
							}else{
								out.println("<br>�Բ�������û�е�¼��");
							}
						%>
				  	 </div>
				</div>
		  	</div>
	  </div>
	</body>
</html>
