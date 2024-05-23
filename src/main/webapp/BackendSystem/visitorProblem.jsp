<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="overfliw-x:hidden;">

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
                            <span>訊息管理</span>
                        </div>
                        <div class="nav-link text-dark">
                          <i class="fa fa-angle-right" aria-hidden="true"></i>
                          <span class="ms-3 fw-bold">訊息內容</span>
                        </div>
                        
                    </div>
                  </nav>

                  <div class="container-fluid p-0">
                    <div class="mb-5">
                        
                        <!-- 查詢列 -->
                        <div class="row flex-row-reverse row-cols-2 border-0 py-3 ps-4 pe-4">
                                <FORM class="col-5" action="<c:url value='/Visitor/SearchMessagePageServlet' />" method="GET">
                            <div class="col mb-4">
                                <div class="d-flex">                 
                                  <div class="col-auto">
                                    <label for="inputMemberId" class="col-form-label me-2">關鍵字查詢</label>
                                  </div>
                                  <input class="form-control me-2" id="inputMemberPhone" type="text" 
                                  placeholder="訊息內容的關鍵字" name="inputValue"  value="${param.inputValue}" aria-label="Search" >        
                                  <div class="col-auto">
                                    <button class="btn btn-outline-primary" type="submit" name='checked' value='2'>查詢<i class="bi bi-search ms-2"></i> </button>
                                  </div>
                                </div>
                            </div>
                                </FORM>
                        </div>
                        
                        <!-- 表格 -->
                      <table class="table table-striped align-middle mb-0" >
                      <thead>
                        <tr  class="text-center">
                          <th scope="col">回覆信箱</th>
                          <th scope="col">訪客名稱</th>
                          <th scope="col">訊息內容</th>
                          <th scope="col">傳送時間</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="entry"  items="${pageBean.visitorBean}"> 
	                        <tr>
	                          <td class="w-25 text-center"><a href="mailto:${entry.visitorMail}">${entry.visitorMail}</a></td>
	                          <td class="w-25 text-center">${entry.visitorName}</td>
	                          <td class="w-25">${entry.visitorMessage}</td>
	                          <td class="w-25 text-center">${entry.visitorTime}</td>
	                        </tr>
                 		</c:forEach>
                       
                      </tbody>
                    </table>
                    </div>
             <!-- 分頁 -->
                    		<nav class="d-flex justify-content-center mt-3 mb-3">
                          <ul class="pagination">
                           <li class="page-item">
						        <c:if test="${pageBean.currentPage > 1}">
						        <c:choose>
						        	<c:when  test="${!empty param.inputValue}">
							          <a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&checked=${param.checked}&&pageNo=${pageBean.currentPage-1}' />" aria-label="Previous"> 
							          	<span aria-hidden="true">&laquo;</span>
							          </a>
						          </c:when>
						        	<c:otherwise>
							          <a class="page-link" href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage-1}' />" aria-label="Previous"> 
							          	<span aria-hidden="true">&laquo;</span>
							          </a>
						          	</c:otherwise>
						        </c:choose> 
						        
						         </c:if>
						         </li>
						         
						         
						       	<c:if test="${pageBean.totalPage > 1}">
						       		<c:forEach var="page"  begin="1" end="${pageBean.totalPage}" step="1" >                  
						        		<c:if test="${ pageBean.currentPage == page}">
										<li class="page-item active">
						        		<c:choose>
						       
							        			<c:when  test="${!empty param.inputValue}">
							        				<li class="page-item active">
							        				<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${page}'/>">${page}</a>
							        				</li>
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
						        		<c:when  test="${!empty param.role}">
						         			<a class="page-link" href="<c:url value='${servletPath}?role=${param.role}&pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
						         			<span aria-hidden="true">&raquo;</span>
						          			</a>
						          		</c:when>
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
                          </ul>
                    </nav>
                  </div>
                    
                </div>
            </div>
        </div>
    </section>


</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>