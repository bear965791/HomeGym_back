<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" style="overflow-x:hidden;">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="overflow-x:hidden;">

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
                          <span>會員管理</span>
                      </div>
                      <i class="fa fa-angle-right" aria-hidden="true"></i>
                      <span class="ms-3 fw-bold">會員列表</span>
                  </div>
                  
                </nav>

                <div class="container-fluid p-0">
                <div class="mb-5">
                  <ul class="nav nav-tabs border-0 border-bottom">
                    <li  class="nav-item ">
                        <a class="nav-link active fw-bold" href="<c:url value='/Member/MemberListPageServlet' />">會員列表</a>
                    </li >
                    <li class="nav nav-tabs border-0">
                        <a class="nav-link text-dark" href="<c:url value='/Member/CoachListPage' />">教練審核</a>
                    </li>
                  </ul>

                  <!-- 查詢列 -->
                  <div class="row row-cols-3 border-0 py-3 ps-4 pe-4">
                   <FORM class="col-5" action="<c:url value='/Member/CategoryPage' />" method="GET">
                      <div class="col mb-4">
                        <div class="d-flex">
                          <div class="col-auto">
                            <label for="inputMemberIdentity" class="col-form-label me-2">會員身份</label>
                          </div>
                          <select class="form-select ms-2 me-2"  name="role">
                            <option selected>請選擇要查詢的會員身分</option>
                            <option value="0" >全部</option>
                            <option value="ROLE_MEMBER">會員</option>
                            <option value="ROLE_COACH">教練</option>
                          </select>  
                          <Input class="btn btn-outline-primary" type="submit" value='查詢' >
                          </div>
                        </div>
                        </FORM>
                         <FORM class="col-5" action="<c:url value='/Member/SearchPageServlet' />" method="GET"> 
                        <div class="col mb-4">
                          <div class="d-flex">
                            <input class="form-control me-2" id="inputMemberName" type="text" placeholder="請輸入會員名稱" name="inputValue">
                            <div class="col-auto">
                            	<Input type='hidden' name='checked' value='1'>
                              <Input class="btn btn-outline-primary" type="submit" value='查詢' >
                            </div>
                          </div>
                        </div>
                        </FORM>
                      </div>
                  
                  <!-- 表格 -->
                  <table class="table table-striped align-middle mb-0 text-center" >
                      <thead>
                        <tr>
                          <th scope="col">會員編號</th>
                          <th scope="col">會員名稱</th>
                          <th scope="col">會員信箱</th>
                          <th scope="col">會員電話</th>
                          <th scope="col">會員身份</th>
                          <th scope="col">會員狀態</th>
                          <th scope="col">會員生日</th>
                          <th scope="col">會員大頭照 </th>
                          <th scope="col">教練資料 </th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="entry"  items="${pageBean.memberBean}" > 
                        <tr>
                          <td>HGMR-${entry.memberId}</td>
                          <td>${entry.memberName}</td>
                          <td>${entry.email}</td>
                          <td>${entry.phone}</td>
                          <c:if test="${entry.role =='ROLE_MEMBER'}">
	                          <td>會員</td>
                          </c:if>
                          <c:if test="${entry.role == 'ROLE_COACH'}">
	                          <td>教練</td>
                          </c:if>
                          <c:if test="${entry.status == 1}">
	                          <td>已驗證</td>
                          </c:if>
                          <c:if test="${entry.status == 0}">
	                          <td class="text-danger">未驗證</td>
                          </c:if>
                       	
                          <td>${entry.birthday}</td>
                          <td><div class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#showPhoto${entry.memberId}">預覽</div></td>
                          <td>
                          	<c:choose>
								<c:when test="${entry.coach.pass == 1}"><a href="<c:url value='/CoachDetalPageServlet?memberId=${entry.memberId}' />" class="btn btn-outline-dark">教練內容</a></c:when> 
								<c:otherwise></c:otherwise> 
							</c:choose>
                          </td>
                        </tr>
                 		</c:forEach>
                       
                      </tbody>
                    </table>
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
						          <c:when  test="${!empty param.role}">
							          <a class="page-link" href="<c:url value='${servletPath}?role=${param.role}&pageNo=${pageBean.currentPage-1}' />" aria-label="Previous"> 
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
						         <!-- 當頁 -->
						       	<c:if test="${pageBean.totalPage > 1}">
						       		<c:forEach var="page"  begin="1" end="${pageBean.totalPage}" step="1" >
						       			<c:if test="${ pageBean.currentPage == page}">
										<li class="page-item active">                  
						        		<c:choose>
						        			<c:when  test="${!empty param.role}">
						        				<a class="page-link" href="<c:url value='${servletPath}?role=${param.role}&pageNo=${page}'/>">${page}
						        				</a>
						        			</c:when>
						        			<c:when  test="${!empty param.inputValue}">
						        				<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${page}'/>">${page}
						        				</a>
						        			</c:when>
						        			<c:otherwise>
						        			
						        			<a class="page-link"
														href="<c:url value='${servletPath}?pageNo=${page}'/>">${page}</a>
														
						        			</c:otherwise>
						        		</c:choose> 
						        		</li></c:if>
						        		
						        		<!-- 非當頁 -->
						        		<c:if test="${ pageBean.currentPage != page}">
										<li class="page-item">
											<c:choose>
						        			<c:when  test="${!empty param.role}">
						        				<a class="page-link" href="<c:url value='${servletPath}?role=${param.role}&pageNo=${page}'/>">${page}
						        				</a>
						        			</c:when>
						        			<c:when  test="${!empty param.inputValue}">
						        				<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${page}'/>">${page}
						        				</a>
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
						         			<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
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
      </div>
  </section>

  <!-- 圖片預覽的彈跳視窗 -->
  <c:forEach var="page"  items="${pageBean.memberBean}" >
	  <div class="modal fade" id="showPhoto${page.memberId }" tabindex="-1" aria-labelledby="showPhotoLabel" aria-hidden="true">
	    <div class="modal-dialog modal-dialog-centered">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h5 class="modal-title" id="showPhotoLabel">會員照片</h5>
	          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	        </div>
	        <div class="modal-body">
	          <img class="ratio ratio-1x1 " src="${page.image}" alt="">
	        </div>
	      </div>
	    </div>
	  </div>
  
  </c:forEach>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>