<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户信息</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="user_%{id==null?'add':'edit'}">
        <s:hidden name="id"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">所属部门</td>
                        <td>
                        <s:select cssClass="SelectStyle" name="departmentId"
                        list="#departments" listKey="id" listValue="name"
                        headerKey="" headerValue="==请选择部门=="
                        />
<%--                         <select name="departmentId" class="SelectStyle">
                                <option value="0" selected="selected">请选择部门</option>
                                <option value="7">┠总经理室</option>
                                <option value="1">┠市场部</option>
                                <option value="2">　┠咨询部</option>
                                <option value="3">　┠招生部</option>
                                <option value="4">┠教学部</option>
                                <option value="5">┠后勤部</option>
                            </select> 
 --%>                        
                        </td>
                    </tr>
                    <tr><td>登录名</td>
                        <td><s:textfield type="text" name="username" class="InputStyle"/> *
							（登录名要唯一）
						</td>
                    </tr>
                    <tr><td>姓名</td>
                        <td><s:textfield type="text" name="nickname" class="InputStyle"/> *</td>
                    </tr>
					<tr><td>性别</td>
                        <td>
							<%-- <s:radio list="%{#{'男':'男','女':'女'} }" name="gender"></s:radio>
							<s:radio list="#{'男':'男','女':'女'}" name="gender"></s:radio> --%>
							<s:radio list="{'男','女'}" name="gender"></s:radio>
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><s:textfield type="text" name="phoneNumber" class="InputStyle"/></td>
                    </tr>
                    <tr><td>E-mail</td>
                        <td><s:textfield type="text" name="email" class="InputStyle"/></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><s:textarea name="description" class="TextareaStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td>
                        <%-- <select name="roleIdList" multiple="true" size="10" class="SelectStyle">
                                <option value="1">程序员</option>
                                <option value="2">行政秘书</option>
                                <option value="3">出纳</option>
                                <option value="4">总经理</option>
                                <option value="5">测试员</option>
                            </select> --%>
                            <s:select cssClass="SelectStyle" name="roleIds" multiple="true"
                        list="#roles" listKey="id" listValue="name"
                        />
                            按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>

</body>

</html>