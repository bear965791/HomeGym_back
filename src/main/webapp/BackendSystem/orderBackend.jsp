<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

  


  <section class="member_Backend">
      <div class="container-fluid">
          <div class="row vh-100">
              <!-- 側邊欄 -->
               <jsp:include page="/BackendSystem/sideBar.jsp" />


              <div class="col-10 p-0">
                <!-- 導覽列 -->
                <jsp:include page="/BackendSystem/navBar.jsp" />

                <!-- 次導覽列 -->
                <nav class="nav_second mb-4 mt-3"> 
                  <div class="nav d-flex align-items-center border-bottom mb-4">
                      <div class="nav-link text-dark">
                          <i class="bx bx-video"></i>
                          <span>訂單管理</span>
                      </div>
                      <i class="fa fa-angle-right" aria-hidden="true"></i>
                      <span class="ms-3 fw-bold">訂單詳情</span>
                  </div>
                </nav>

                <!-- 查詢列 -->
                <FORM class="col-12" action="<c:url value='/Order/SearchMemberNameAndOrderIdPageServlet' />" method="GET"> 
	                 <div class="row ps-5 pe-5">
	                     <div class="col-4">
	                        <div class="d-flex">
	                          <div class="col-auto">
	                            <label for="inputOrderId" class="col-form-label me-2">訂單查詢</label>
	                          </div>
	                          <input class="form-control me-2" id="inputOrderId" type="text" 
	                          		placeholder="請搜尋訂單編號或會員名稱" aria-label="Search" name="inputValue" value="${param.inputValue }">
	                          <button class="btn btn-outline-primary col-auto" type="submit">查詢</button>
	                        </div>
	                     </div>
	                 </div>
                 </FORM>
                  <!-- 表格 -->
                  
                  <table class="table table-striped align-middle mt-4 text-center" >
                      <thead>
                        <tr>
                          <th scope="col">訂單編號 <i class="fa fa-sort-amount-desc" aria-hidden="true"></i>
                          </th>
                          <th scope="col">會員名稱 <i class="fa fa-sort-amount-desc" aria-hidden="true"></i></th>
                          <th scope="col">訂單狀態 <i class="fa fa-sort-amount-asc" aria-hidden="true"></i></th>
                          <th scope="col">訂單時間 <i class="fa fa-sort-amount-desc" aria-hidden="true"></i></th>
                          <th scope="col">訂單詳情 </th>
                        </tr>
                      </thead>
                      <tbody>
                        <!-- 訂單項目 -->
		                  <c:forEach var="entry"  items="${pageBean.orderBean}" > 
	                        <tr>
	                          <td>${entry.orderId}</td>
	                          <td>${entry.member.memberName}</td>
	                          
	                          <c:choose>
	                          	<c:when test="${entry.orderStatus =='付款成功'}">
	                          		<td>交易成功</td>
	                          	</c:when>
	                          	<c:otherwise>
	                          		<td>交易失敗</td>
	                          	</c:otherwise>
	                          </c:choose>
	                          
	                          <td>${entry.orderTime}</td>
	                          <td><div class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#orderContent${entry.orderId}">訂單內容</div></td>
	                        </tr>
                          </c:forEach>
                        
                        
                      </tbody>
                    </table>
                    <!-- 分頁 -->
                    		<!-- 左側 -->
                    		<nav class="d-flex justify-content-center mt-3 mb-3">
                          <ul class="pagination">
                           <li class="page-item">
						        <c:if test="${pageBean.currentPage > 1}">
						        <c:choose>
						        	<c:when  test="${!empty param.inputValue}">
							          <a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${pageBean.currentPage-1}' />" 
							          aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							          </a>
						          </c:when>
						        	<c:otherwise>
							          <a class="page-link" href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage-1}' />" 
							          	aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							          </a>
						          	</c:otherwise>
						        </c:choose> 
						        
						         </c:if>
						         </li>
						         <!-- 中間值 -->
						       	<c:if test="${pageBean.totalPage > 1}">
						       		<c:forEach var="page"  begin="1" end="${pageBean.totalPage}" 
						       		step="1" >  
						       		<!-- 當前頁數反藍 -->
						       		<c:if test="${ pageBean.currentPage == page}">
										<li class="page-item active">
						        		<c:choose>
						        			<c:when  test="${!empty param.inputValue}">
						    
						        				<a class="page-link" 
						        					href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${page}'/>">${page}</a>
						
						        			</c:when>
						        			<c:otherwise>
						        				<a class="page-link"
														href="<c:url value='${servletPath}?pageNo=${page}'/>">${page}</a>
						        			</c:otherwise>
						        		</c:choose> 
						        		</li></c:if>
						        		<c:if test="${ pageBean.currentPage != page}">
										<li class="page-item">
											<c:choose>
						        			<c:when  test="${!empty param.inputValue}">
						    
						        				<a class="page-link" 
						        					href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${page}'/>">${page}</a>
						
						        			</c:when>
						        			<c:otherwise>
						        				<a class="page-link"
														href="<c:url value='${servletPath}?pageNo=${page}'/>">${page}</a>
						        			</c:otherwise>
						        		</c:choose> 
										</li></c:if>
										
										
						        	</c:forEach>
						     	</c:if>
						
						        <li class="page-item">
						         	<c:if test="${pageBean.currentPage != pageBean.totalPage && pageBean.totalPage != 0}">
						         	<c:choose>
						          		<c:when  test="${!empty param.inputValue}">
						         			<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&checked=${param.checked}&pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
						         			<span aria-hidden="true">&raquo;</span>
						          			</a>
						          		</c:when>
						        		<c:otherwise>
						          			<a class="page-link" href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
						         			<span aria-hidden="true">&raquo;</span>
						          			</a>
						          		</c:otherwise>
						          		
						        	</c:choose> 
						        	
						         	</c:if>
						        </li>
						        <!-- 反藍的部分 -->
						        
								
						        
                          </ul>
                    </nav>
              </div>
          </div>
      </div>
  </section>

  <!-- 彈跳視窗內容 -->
   <c:forEach var="page"  items="${pageBean.orderBean}" >
	  <div class="modal fade" id="orderContent${page.orderId}" tabindex="-1" aria-labelledby="orderContentLabel" aria-hidden="true">
	    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h5 class="modal-title" id="orderContentLabel">訂單編號</h5>
	          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	        </div>
	        <div class="modal-body">
	       
	          <h5 class="text-center">購買課程內容</h5>
	          <ul class="list-group">
	            <!-- 課程購買細項項目 -->
	            
	            <c:forEach var="course" items="${page.course}"> 
		            <li class="list-group-item">
		              <div class="row align-items-center">
		                <div class="col-4">
		                  <img class="w-100" src="${course.videoImage} " alt="">
		                </div>
		                <div class="col-8">
		                  <p class="m-0">${course.name}</p>
		                  <p class="m-0 badge bg-primary">課程編號：${course.videoId}</p>
		                </div>
		              </div>
		            </li>
		         </c:forEach>
	            
	            
	          </ul>
	        </div>
	        <div class="modal-footer">
	          <h5 class="modal-title" id="orderContentLabel">總金額：${page.totalAmt } </h5>
	        </div>
	      </div>
	    </div>
	  </div>
   </c:forEach>





</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>