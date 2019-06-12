<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@ include file="../include/head.jsp" %>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@ include file="../include/main_header.jsp" %>
		
		<!-- Left side column. contains the logo and sidebar -->
		<%@ include file="../include/left_column.jsp" %>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Page Header <small>Optional description</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
					<li class="active">Here</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">

				<!-- Your Page Content Here -->
				<div class="col-lg-12">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">게시글 목록</h3>
						</div>
						<div class="box-body">
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th style="width: 30px;">#</th>
										<th>제목</th>
										<th style="width: 100px;">작성자</th>
										<th style="width: 150px;">작성시간</th>
										<th style="width: 60px;">조회수</th>
									</tr>
									
									<c:forEach items="${articles }" var="article">
									<tr>
										<td>${article.articleNo }</td>
										<td>
											<a href="${path }/article/read?articleNo=${article.articleNo }">${article.title }</a>
										</td>
										<td>${article.writer }</td>
										<td><fmt:formatDate value="${article.regdate }" pattern="yyyy-MM-dd a HH:mm" /></td>
										<td><span class="badge bg-red">${article.viewcnt }</span></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<div class="box-footer">
							<div class="pull-right">
								<button type="button" class="btn btn-success btn-flat" id="writeBtn">
									<i class="fa fa-pencil"></i> 글쓰기
								</button>		
							</div>
						</div>
					</div>
				</div>

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@ include file="../include/main_footer.jsp" %>

		<!-- Control Sidebar -->
		<%@ include file="../include/control_sidebar.jsp" %>
		
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	
	<%@ include file="../include/plugin_js.jsp" %>
	
	<script>
	
		var result = "${msg }";
		console.log(result);
		
		if(result == "regSuccess") {
			alert("게시글이 등록되었습니다");
		} else if(result == "modSuccess") {
			alert("게시글이 수정되었습니다");
		} else if(result == "delSuccess") {
			alert("게시글이 삭제되었습니다");
		}
		
		$(document).ready(function() {
			// 글쓰기 버튼 클릭시
			$("#writeBtn").on("click", function() {
				self.location = "write";
			})
		})
	
	</script>

	
</body>
</html>