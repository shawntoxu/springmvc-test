<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=basePath%>resources/jquery-1.11.3.min.js"></script>
<style type="text/css">
a {
	border: 1px solid rgb(73, 58, 58);
	background-color: rgb(133, 133, 133);
	height: 50px;
	line-height: 50px;
	color: white;
	text-decoration: none;
	font-weight: bold;
	padding: 5px;
	margin: 5px;
}
</style>
<script type="text/javascript">

function Tajax(){
    var sdata = {"name":"test","tel":"13245678","pwd":"pwd"} ;
    var url = "http://localhost:8080/springrestful/user/register";
     $.ajax({
            url: url, 
            type:"POST",
            dataType:"json",
            data:JSON.stringify(sdata),
            contentType:"application/json",
            //data:sdata,

            //async:true,
            success: function(res){
                console.info(res);
               /**$.each(data.items,function(i,item){

                console.info(item.name);

                       if(item.spec.containers != undefined &&  item.spec.containers[0].ports != undefined ){
                            $.each(item.spec.containers,function(j,item){
                                 $.each(item.ports,function(k,item){
                                        cachePort(item.hostPort);
                                });

                            });

                        }

                });**/

            },
            error:function(){
                console.info("get some error!") ; 
            }
        });
}
Tajax() ;

</script>
</head>

<body>
	
</body>
</html>
