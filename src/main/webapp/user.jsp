<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts 1.2 using AngularJS</title>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
</head>
<style>
table,th,td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 5px;
}

table tr:nth-child(odd) {
	background-color: #f1f1f1;
}

table tr:nth-child(even) {
	background-color: #ffffff;
}
</style>
<body>
	<script>
		var app = angular.module('myApp', []);
		app
				.controller(
						'customersCtrl',
						function($scope, $http, $rootScope) {							
							$scope.cap = {};
							$scope.names = [];
							$scope.searchUser = {};

							$scope.load = function() {
								$http
										.get(
												"http://localhost:8082/StrutsDisplayTag/userAction.do")
										.then(function(response) {
											$scope.names = response.data;
										});
							};

							$scope.edit = function() {
								document.getElementById("messageDiv").style.display = "block";
								document.getElementById("messageDiv").innerHTML = "<b>Saving Data!!!</b>";
								//$("#img").fadeIn();
								$scope.cap.userId = document.getElementById("userId").value;
								$scope.cap.userName = document.getElementById("userName").value;
								$scope.cap.emailId = document.getElementById("emailId").value;
								$http
										.get(
												"http://localhost:8082/StrutsDisplayTag/editAction.do",
												{
													params : $scope.cap
												}).then(function(response) {
											$scope.names = response.data;
											/* $("#img").fadeOut(1000, function() {
												alert("Succesfully Updated!!");
												unLoadPopUp();
											}); */
											document.getElementById("messageDiv").innerHTML = "<b>Succesfully Updated!!</b>";
										});
								
							};

							$scope.search = function() {
								$http
										.get(
												"http://localhost:8082/StrutsDisplayTag/searchAction.do",
												{
													params : $scope.searchUser
												}).then(function(response) {
											$scope.names = response.data;
										});
							};
						});

		jQuery(document).ready(function() {
			jQuery('.modify').live('click', function() {
				$('#editPopup').fadeIn("slow", function() {
					$("#main").css({
						"opacity" : "0.3",
						"z-index" : "1",
						"pointer-events" : "none"
					});
				});
				var tr = $(this).closest('tr');
				var index = tr.find('#columnIndex').text();
				var userId = tr.find('#columnUserId').text();
				var userName = tr.find('#columnUserName').text();
				var emailId = tr.find('#columnEmailId').text();
				document.getElementById("userId").value = userId;
				document.getElementById("userName").value = userName;
				document.getElementById("emailId").value = emailId;
				//document.getElementById("userId").focus();
			});
		});
		jQuery(document).ready(function() {
			jQuery('.fetchbutton').live('click', function() {
				document.getElementById("tableDiv").style.display = "block";
			});
		});
		function unLoadPopUp() {
			$('#editPopup').fadeOut("slow", function() {
				$("#main").css({
					"opacity" : "1",
					"pointer-events" : "auto"
				});
			});
			document.getElementById("messageDiv").style.display = "none";
		}
	</script>
	<div ng-app="myApp" ng-controller="customersCtrl">
		<div align="center">
			<img src="img/loading.png" id="img" style="display: none"
				align="middle" />
		</div>
		<div id="main"
			style="width: 100%; height: 100%; padding: 50px; font-weight: bold;">
			<div id="fetchDataDiv" align="center">
				<button class="fetchbutton" type="submit" ng-click="load()"
					style="width: 50%; height: 50%">Fetch Data</button>
			</div>
			&nbsp;&nbsp;
			<div id="tableDiv" style="display: none;" align="center">
				<div id="searchDiv" align="center">
					<form ng-submit="search()">
						UserName : <input type="text" id="" ng-model="searchUser.userName" />
						<input type="submit" value="Search">
					</form>
				</div>
				&nbsp;
				<table id="tableData" align="center">
					<thead>
						<tr id="header">
							<th>Index</th>
							<th>User ID</th>
							<th>User Name</th>
							<th>Email Id</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr id="row" ng-repeat="x in names">
							<td id="columnIndex">{{ $index + 1 }}</td>
							<td id="columnUserId">{{ x.userId }}</td>
							<td id="columnUserName">{{ x.userName }}</td>
							<td id="columnEmailId">{{ x.emailId }}</td>
							<td id="columnButton">
								<button class="modify" type="submit">Modify</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div id="editPopup"
			style="height: 100%; top: 0; left: 0; position: fixed; opacity: 1; filter: alpha(opacity =       100); display: none; z-index: 2;"
			align="center">
			<div id="popup"
				style="position: absolute; _position: absolute; height: 107px; width: 335px; background: #FFFFFF; left: 633px; top: 250px; text-align: center; border: 2px solid #BDBDBD; padding: 55px; font-size: 15px; -moz-box-shadow: 0 0 5px #D8D8D8; -webkit-box-shadow: 0 0 5px #D8D8D8; box-shadow: 0 0 5px #D8D8D8;">
				<form ng-submit="edit()">
					<input type="text" id="userId"  ng-model="cap.userId" ng-disabled="true"/> <input
						type="text" id="userName" ng-model="cap.userName" /> <input
						type="text" id="emailId" ng-model="cap.emailId" /> <input
						type="submit" value="OK">
				</form>
				<a href="#" onclick="return unLoadPopUp();">Close</a>
				<div id="messageDiv" style="display: none" align="center">
				</div>
			</div>
		</div>
	</div>


</body>
</html>