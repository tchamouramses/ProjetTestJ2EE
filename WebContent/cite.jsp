<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
<!-- Toastr -->
<link rel="stylesheet" href="plugins/toastr/toastr.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout des cites</title>
</head>
<body>
	<div class="wrapper">
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
		<!-- Left navbar links -->
		<ul class="navbar-nav">
			<li class="nav-item d-none d-sm-inline-block"><a href="accueil"
				class="nav-link">Home</a></li>
		</ul>
		<!-- Right navbar links -->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link"
				data-widget="control-sidebar" data-slide="true" href="#"
				role="button"> <i class="fas fa-th-large"></i>
			</a></li>
		</ul>
		</nav>
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<!-- Brand Logo --> <a href="index3.html" class="brand-link"> <img
			src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
			class="brand-image img-circle elevation-3" style="opacity: .8">
			<span class="brand-text font-weight-light">Work</span>
		</a> <!-- Sidebar -->
		<div class="sidebar">
			<!-- Sidebar user (optional) -->
			<div class="user-panel mt-3 pb-3 mb-3 d-flex">
				<div class="image">
					<img src="dist/img/face_picture.jpg" class="img-circle elevation-2"
						alt="User Image">
				</div>
				<div class="info">
					<a href="#" class="d-block">Tchamou Ramses</a>
				</div>
			</div>

			<div class="user-panel mt-3 pb-3 mb-3 d-flex">
				<div class="image">
					<img src="dist/img/home1.png" class="img-circle elevation-2"
						alt="User Image">
				</div>
				<div class="info">
					<a href="accueil" class="d-block">HOME</a>
				</div>
			</div>


			<!-- Sidebar Menu -->
			<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<li class="nav-item has-treeview"><a href="#" class="nav-link">
						<i class="nav-icon fas fa-copy"></i>
						<p>
							Gestion client <i class="fas fa-angle-left right"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="../layout/top-nav.html"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>liste des clients</p>
						</a></li>
						<li class="nav-item"><a href="clients" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Ajout des clients</p>
						</a></li>
					</ul></li>

				<li class="nav-item has-treeview"><a href="#" class="nav-link">
						<i class="nav-icon fas fa-copy"></i>
						<p>
							Gestion chambres <i class="fas fa-angle-left right"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="" class="nav-link"> <i
								class="far fa-circle nav-icon"></i>
								<p>liste des chambres</p>
						</a></li>
						<li class="nav-item"><a href="chambre" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Ajout des chambres</p>
						</a></li>
					</ul></li>

				<li class="nav-item has-treeview"><a href="#" class="nav-link">
						<i class="nav-icon fas fa-copy"></i>
						<p>
							Gestion cites <i class="fas fa-angle-left right"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="../layout/top-nav.html"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>liste des cites</p>
						</a></li>
						<li class="nav-item"><a href="../layout/top-nav-sidebar.html"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Ajout des cites</p>
						</a></li>
					</ul></li>

				<li class="nav-item has-treeview"><a href="#" class="nav-link">
						<i class="nav-icon fas fa-copy"></i>
						<p>
							Gestion reservation <i class="fas fa-angle-left right"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="../layout/top-nav.html"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>liste des reservations</p>
						</a></li>
						<li class="nav-item"><a href="../layout/top-nav-sidebar.html"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Ajout d'une reservation</p>
						</a></li>
					</ul></li>
			</ul>
			</nav>
			<!-- /.sidebar-menu -->
		</div>
		<!-- /.sidebar --> </aside>

		<div class="content-wrapper" style="min-height: 1416.81px;">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">
							<font style="vertical-align: inherit;"><font
								style="vertical-align: inherit;">AJOUT D'UNE CITE</font>
						</h3>
					</div>
					<form action="cite" method="POST">
						<div class="card-body">
							<div class="form-group">
								<label for="nature">bailleur</label> <input type="text"
									name="bailleur" class="form-control" id="bailleur"
									placeholder="bailleur">
							</div>
							<div class="form-group">
								<label for="prix">nbChambre</label> <input type="text" name="nbChambre"
									class="form-control" id="prix" placeholder="nbChambre">
							</div>
							
						</div>
						<div class="card-footer">
							<button type="submit" class="btn btn-primary">Valider</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- jQuery -->
	<script src="plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- SweetAlert2 -->
	<script src="plugins/sweetalert2/sweetalert2.min.js"></script>
	<!-- Toastr -->
	<script src="plugins/toastr/toastr.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="dist/js/demo.js"></script>

</body>
</html>