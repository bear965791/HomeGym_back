<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>厝動HomeGym 後台系統</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<section class="staff_Backend">
		<div class="container-fluid">
			<div class="row  vh-100">
				<!-- 側邊欄 -->
				<jsp:include page="/BackendSystem/sideBar.jsp" />

				<div class="col-10 p-0">
					<!-- 導覽列 -->
					<jsp:include page="/BackendSystem/navBar.jsp" />

					<!-- 次導覽列 -->
					<nav class="nav_second mb-4 mt-3">
						<div
							class="nav d-flex align-items-center flex-row-reverse border-bottom mb-4">
							<div class="btn btn-outline-dark m-3" data-bs-toggle="modal"
								data-bs-target="#employeeRegistration">
								<span>新進員工報到</span>
							</div>

						</div>
					</nav>

					<!-- 查詢列 -->
					<div class="row row-cols-2 ps-5 pe-5">
						<FORM class="col-6"
							action="<c:url value='/Staff/SearchStaffId.do?' />" method="GET">
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputStaffId" class="col-form-label me-2">員工編號</label>
									</div>
									<input class="form-control me-2" id="inputStaffId" type="text"
										placeholder="請搜尋員工編號" name="inputId" value="${param.inputId}">
									<button class="btn btn-outline-primary col-auto" type="submit">查詢</button>
								</div>
							</div>
						</FORM>
						<FORM class="col-6"
							action="<c:url value='/Staff/SearchName.do?' />" method="GET">
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputStaffName" class="col-form-label me-2">員工姓名</label>
									</div>
									<input class="form-control me-2" id="inputStaffName"
										type="text" placeholder="請搜尋員工姓名" name="inputName" value="${param.inputName}">
									<button class="btn btn-outline-primary col-auto" type="submit">查詢</button>
								</div>
							</div>
						</FORM>
						<FORM class="col-6"
							action="<c:url value='/Staff/SearchPhone.do?' />" method="GET">
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputStaffPhone" class="col-form-label me-2">員工電話</label>
									</div>
									<input class="form-control me-2" id="inputStaffPhone"
										type="text" placeholder="請搜尋員工電話" name="inputPhone" value="${param.inputPhone}">
									<button class="btn btn-outline-primary col-auto" type="submit">查詢</button>
								</div>
							</div>
						</FORM>
						<FORM class="col-6"
							action="<c:url value='/Staff/SearchPosition.do?' />" method="GET" >
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputStaffPosition" class="col-form-label me-2">員工職稱</label>
									</div>
									<select id="inputStaffPosition" class="form-select me-2"
										name="inputPosition">
										<option selected>選擇職位</option>
										<option value="新進人員">新進人員</option>
										<option value="主管">主管</option>
										<option value="經理">經理</option>
									</select>
									<button class="btn btn-outline-primary col-auto" type="submit">查詢</button>
								</div>
							</div>
						</FORM>
					</div>
					<!-- 表格 -->
					<table class="table table-striped align-middle mt-4 text-center">
						<thead>
							<tr>
								<th scope="col">員工編號 <i class="fa fa-sort-amount-desc"
									aria-hidden="true"></i>
								</th>
								<th scope="col">員工姓名 <i class="fa fa-sort-amount-desc"
									aria-hidden="true"></i></th>
								<th scope="col">員工職稱 <i class="fa fa-sort-amount-asc"
									aria-hidden="true"></i></th>
								<th scope="col">員工電話 <i class="fa fa-sort-amount-desc"
									aria-hidden="true"></i></th>
								<th scope="col">員工生日 <i class="fa fa-sort-amount-desc"
									aria-hidden="true"></i></th>
								<th scope="col">報到日期 <i class="fa fa-sort-amount-desc"
									aria-hidden="true"></i></th>
								<th scope="col">員工狀態 <i class="fa fa-sort-amount-desc"
									aria-hidden="true"></i></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<!-- 員工項目 -->
							<c:forEach var="staff" items="${pageBean.staffBean}">
								<tr>
									<td>${staff.staffId}</td>
									<td>${staff.staffName}</td>
									<td>${staff.staffPosition}</td>
									<td>${staff.staffPhone}</td>
									<td><fmt:formatDate value="${staff.staffBirthday}"
											pattern="yyyy-MM-dd"></fmt:formatDate></td>
									<td><fmt:formatDate value="${staff.staffCheckInDay}"
											pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
									<td>${staff.staffStatus}</td>
									<td><a
										href="<c:url value='/Staff/findStaff?key=${staff.staffId}' />"
										class="btn btn-outline-dark">修改</a></td>
								</tr>
							</c:forEach>



						</tbody>
					</table>
					<!-- 分頁 -->
					<nav class="d-flex justify-content-center mt-3 mb-3">
						<ul class="pagination">
							<li class="page-item"><c:if
									test="${pageBean.currentPage > 1}">
									<c:choose>
										<c:when test="${!empty param.inputId}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputId=${param.inputId}&pageNo=${pageBean.currentPage-1}' />"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a>
										</c:when>
										<c:when test="${!empty param.inputPhone}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputPhone=${param.inputPhone}&pageNo=${pageBean.currentPage-1}' />"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a>
										</c:when>
										<c:when test="${!empty param.inputName}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputName=${param.inputName}&pageNo=${pageBean.currentPage-1}' />"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a>
										</c:when>
										<c:when test="${!empty param.inputPosition}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputPosition=${param.inputPosition}&pageNo=${pageBean.currentPage-1}' />"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a>
										</c:when>
										<c:otherwise>
											<a class="page-link"
												href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage-1}' />"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a>
										</c:otherwise>
									</c:choose>

								</c:if></li>
							<c:if test="${pageBean.totalPage > 1}">
								<c:forEach var="page" begin="1" end="${pageBean.totalPage}"
									step="1">
									<!-- 將當前頁數反藍 -->
									<c:if test="${ pageBean.currentPage == page}">
										<li class="page-item active">
										<c:choose>
												<c:when test="${!empty param.inputId}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputId=${param.inputId}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:when test="${!empty param.inputPhone}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputPhone=${param.inputPhone}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:when test="${!empty param.inputName}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputName=${param.inputName}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:when test="${!empty param.inputPosition}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputPosition=${param.inputPosition}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:otherwise>
													<a class="page-link"
														href="<c:url value='${servletPath}?pageNo=${page}'/>">${page}</a>
												</c:otherwise>
											</c:choose>
											</li>
									</c:if>
									<c:if test="${ pageBean.currentPage != page}">
										<li class="page-item">
										<c:choose>
												<c:when test="${!empty param.inputId}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputId=${param.inputId}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:when test="${!empty param.inputPhone}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputPhone=${param.inputPhone}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:when test="${!empty param.inputName}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputName=${param.inputName}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:when test="${!empty param.inputPosition}">
													<!-- 						        				<li class="page-item"> -->
													<a class="page-link"
														href="<c:url value='${servletPath}?inputPosition=${param.inputPosition}&pageNo=${page}'/>">${page}</a>
													<!-- 						        				</li> -->
												</c:when>
												<c:otherwise>
													<a class="page-link"
														href="<c:url value='${servletPath}?pageNo=${page}'/>">${page}</a>
												</c:otherwise>
											</c:choose>
											</li>
									</c:if>
									<!-- /將當前頁數反藍 -->
								</c:forEach>
							</c:if>

							<li class="page-item">
							<c:if test="${pageBean.currentPage != pageBean.totalPage && pageBean.totalPage != 0}">
									<c:choose>
										<c:when test="${!empty param.inputId}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputId=${param.inputId}&pageNo=${pageBean.currentPage+1}' />"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a>
										</c:when>
										<c:when test="${!empty param.inputPhone}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputPhone=${param.inputPhone}&pageNo=${pageBean.currentPage+1}' />"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a>
										</c:when>
										<c:when test="${!empty param.inputName}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputName=${param.inputName}&pageNo=${pageBean.currentPage+1}' />"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a>
										</c:when>
										<c:when test="${!empty param.inputPosition}">
											<a class="page-link"
												href="<c:url value='${servletPath}?inputPosition=${param.inputPosition}&pageNo=${pageBean.currentPage+1}' />"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a>
										</c:when>
										<c:otherwise>
											<a class="page-link"
												href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage+1}' />"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a>
										</c:otherwise>
									</c:choose>
								</c:if></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>

	<!-- 註冊畫面彈跳視窗 -->
	<form method="POST" action="<c:url value='/saveStaff.do' />"
		enctype='multipart/form-data'>
		<div class="modal fade" id="employeeRegistration"
			data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="employeeRegistrationLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="employeeRegistrationLabel">員工報到畫面</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="row row-cols-2">
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputMemberName" class="col-form-label me-2">員工姓名</label>
									</div>
									<input class="form-control me-2" id="inputMemberName"
										name="staffName" value="${param.staffName}" type="text"
										placeholder="" aria-label="Search">
								</div>
							</div>
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputMemberName" class="col-form-label me-2">員工電話</label>
									</div>
									<input class="form-control me-2" id="inputMemberName"
										name="staffPhone" value="${param.staffPhone}" type="text"
										placeholder="" aria-label="Search">
								</div>
							</div>
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputMemberName" class="col-form-label me-2">員工生日</label>
									</div>
									<input class="form-control me-2" id="inputMemberName"
										name="staffBirthday" value="${param.staffBirthday}"
										type="date" placeholder="" aria-label="Search">
								</div>
							</div>
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputMemberName" class="col-form-label me-2">員工職稱</label>
									</div>
									<select class="form-select me-3"
										aria-label="Default select example" name="staffPosition"
										value="${param.staffPosition}">
										<option selected>選擇職位</option>
										<option value="新進員工">新進員工</option>
										<option value="主管">主管</option>
										<option value="經理">經理</option>
									</select>
								</div>
							</div>
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputMemberName" class="col-form-label me-2">員工密碼</label>
									</div>
									<input class="form-control me-2" id="inputMemberName"
										name="staffPassword" value="${param.staffPassword}"
										type="password" placeholder="" aria-label="Search">

								</div>
							</div>
							<div class="col mb-3">
								<div class="d-flex">
									<div class="col-auto">
										<label for="inputMemberName" class="col-form-label me-2">確認密碼</label>
									</div>
									<input class="form-control me-2" id="inputMemberName"
										type="password" placeholder="" aria-label="Search">

								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">註冊</button>
					</div>
				</div>
			</div>
		</div>
	</form>







</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
</html>