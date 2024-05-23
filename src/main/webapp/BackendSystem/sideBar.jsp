<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<div class="col-2 p-0">
	<div class="sidebar bg-dark h-100 d-flex flex-column">
	  <div class="list-group-item border-dark mb-3 p-4 border-0 border-end border-5 text-center">
	    <figure class="text-center">
	      <blockquote class="blockquote">
	        <p>${LoginOK.staffName} 您好</p>
	      </blockquote>
	      <figcaption class="blockquote-footer">
	        職位：${LoginOK.staffPosition}
	      </figcaption>
	    </figure>                      
	  </div>
	  <div class="list-group rounded-0 p-4">
	  	<!-- 新人權限 -->
	    <a href="<c:url value='/Order/OrdersListPageServlet' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">訂單管理</a>
	    <a href="<c:url value='/Course/checkedCoursePage' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">課程管理</a>
		<a href="<c:url value='/Visitor/VisitorProblemServlet' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">訪客訊息</a>
		

	    <!-- 主管權限 -->
	    <c:if test="${LoginOK.staffPosition == '主管'}">
    	    <a href="<c:url value='/Member/MemberListPageServlet' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">會員管理</a>
	    </c:if>
	    
		<!-- 經理權限 -->
   	    <c:if test="${LoginOK.staffPosition == '經理'}">
    	    <a href="<c:url value='/Member/MemberListPageServlet' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">會員管理</a>
		    <a href="<c:url value='/Staff/queryStaff' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">後台權限管理</a>
   	    </c:if>
	    
	    
	    
	  </div>
	  <a href="<c:url value='/BackendSystem/logout.jsp' />" class="rounded-0 list-group-item list-group-item-action mb-3 fs-5 text-center mt-auto border-end-0 mb-5">登出</a>
	</div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>