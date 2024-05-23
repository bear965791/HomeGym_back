<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
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

                <Form class='center' Action="<c:url value='/staff/staffUpdate.do' />" method="POST" >

                    <div class="d-flex mt-5 justify-content-center align-items-center">
                    
                    <!-- 存放值的地方 -->
                    <input type="hidden" name="staffId"     value="${sb.staffId}" >
                    <input type="hidden" name="staffBirthday"     value="${sb.staffBirthday}" >
                    <input type="hidden" name="staffCheckInDay"     value="${sb.staffCheckInDay}" >
                    <input type="hidden" name="finalDecision" value="" > 
                    

                      <div>
                        <!-- 員工編號 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffId" class="col-form-label me-3">員工編號</label>
                          </div>
                          <div class="p-0" name="staffId" id="staffId">${sb.staffId}</div>
                        </div>
                        <!-- 員工姓名 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffName" class="col-form-label me-3">員工姓名</label>
                          </div>
                          <input class="form-control me-2" name="staffName" id="staffName" type="text" value="${sb.staffName}" aria-label="Search">
                        </div>
                        <!-- 員工密碼 -->
                        <!-- <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffPassword" class="col-form-label me-3">員工密碼</label>
                          </div>
                          <input class="form-control me-2" name="staffPassword" id="staffPassword" type="text" value="" aria-label="Search">
                        </div> -->
                          <input class="form-control me-2" name="staffPassword" id="staffPassword" type="hidden" value="${sb.staffPassword}" aria-label="Search">
                        <!-- 員工職稱 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffPosition" class="col-form-label me-3">員工職稱</label>
                          </div>
                          <select class="form-select me-3" name="staffPosition" id="staffPosition" aria-label="Default select example">
                            <option selected>選擇職位</option>
                            <option value="新進人員">新進人員</option>
                            <option value="主管">主管</option>
                            <option value="經理">經理</option>
                          </select>
                        </div>
                        <!-- 員工電話 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffPhone" class="col-form-label me-3">員工電話</label>
                          </div>
                          <input class="form-control me-2" name="staffPhone" id="staffPhone" value="${sb.staffPhone}" type="text" aria-label="Search">
                        </div>
                        <!-- 員工生日 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffBirthday" class="col-form-label me-3">員工生日</label>
                          </div>
                          <div class="p-0" name="staffBirthday" id="staffBirthday"><fmt:formatDate value="${sb.staffBirthday}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></div>
                        </div>
                        <!-- 報到日期 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffCheckInDay" class="col-form-label me-3">報到日期</label>
                          </div>
                          <div class="p-0" name="staffCheckInDay" id="staffCheckInDay"><fmt:formatDate value="${sb.staffCheckInDay}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></div>
                        </div>
                        <!-- 員工狀態 -->
                        <div class="d-flex align-items-center mb-3">
                          <div class="col-auto fw-bold">
                            <label for="staffStatus" class="col-form-label me-3">員工狀態</label>
                          </div>
                          <select class="form-select me-3" name="staffStatus" id="staffStatus" aria-label="Default select example">
                          	<option value="在職中">在職中</option>
                            <option value="已離職">已離職</option>
                            
                          </select>
                        </div>

                        <div class="d-flex justify-content-center mt-5 me-5">
                          <input class="btn btn-outline-dark" type="submit" value="更新" name='updateBtn' onclick="return confirmUpdate('${sb.staffName}');"> 

                        </div>

                      </div>

                    </div>
                </Form>                
                  
              </div>
          </div>
      </div>
  </section>


</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script>
  function confirmUpdate(userId){
	  var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "UPDATE";
	      return true;
	  }
	  return false;
  }
</script>
</html>