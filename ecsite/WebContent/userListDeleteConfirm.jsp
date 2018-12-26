<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>UserList</title>
<style type="text/css">

body {
margin:0;
padding:0;
line-height:1.6;
letter-spacing:1px;
font-family:Verdana, Helvetica, sans-serif;
font-size:12px;
color:#333;
background:#fff;
}

table {
text-align:center;
margin:0 auto;
mergin-left:30px;
}

#top {
width:780px;
margin:30px auto;
border:1px solid #333;
}

#header {
width: 100%;
height: 80px;
background-color: black;
}

#main {
width: 100%;
height: 500px;
text-align: center;
}

#footer {
width: 100%;
height: 80px;
background-color: black;
clear:both;
}

#text-center {
display: inline-block;
text-align: center;
}
</style>
</head>


<body>
  <div id = "header">
    <div id = "pr">
    </div>
  </div>

  <div id = "main">
    <div id = "top">
      <p>UserDeleteConfirm</p>
    </div>
    <h2>以下の内容を削除しますか？</h2>
    <table border = "1">
      <tbody>
        <tr>
          <th>ログインID</th>
          <th>ログインPASS</th>
          <th>名前</th>
          <th>登録日</th>
        </tr>

        <s:iterator value = "#session.userInfoDTOList">
          <tr>
            <td><s:property value = "loginId"/></td>
            <td><s:property value = "loginPassword"/></td>
            <td><s:property value = "userName"/></td>
            <td><s:property value = "insertDate"/></td>
          </tr>
        </s:iterator>
      </tbody>
    </table>

    <s:form action = "UserListDeleteCompleteAction">
      <s:submit value = "削除"/>
    </s:form>

    <span>前画面にもどる場合は</span>
    <a href = "userList.jsp">こちら</a>

  </div>

  <div id = "footer">
    <div id = "pr">
    </div>
  </div>

</body>
</html>