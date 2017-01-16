<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:param name="ageParam">30</xsl:param>

  <xsl:template match="people">
  <html ng-app="myApp">
	  <head>
	  <style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}ng\:form{display:block;}.ng-animate-shim{visibility:hidden;}.ng-anchor{position:absolute;}</style>
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<![CDATA[
			
			]]>
		</link>
		 <style>
        span.nobr { white-space: nowrap; }

        .indent { text-indent: 1.2em; }
		</style>
		<title>Struts 1.2 using AngularJS</title>
		
	  <script type="text/javascript" src="js/angular.min.js">
				<![CDATA[
				
				]]>
		</script>
		<script type="text/javascript" src="js/ng-xslt.js">
			<![CDATA[
			//
			]]>
		</script>
		
		<!-- <script type="text/javascript" src="js/angular.min.js"></script> -->
	</head>
		<body>
		<div  ng-controller="myCtrl" class="ng-scope">
			<div class="row">
				<div class="col-md-6">
					<h4>Angular JS Example (Start)</h4>
					First Name: <input type="text" ng-model="firstName"/><br/>
					Last Name: <input type="text" ng-model="lastName"/><br/>
					<br/>
					Full Name: {{firstName + " " + lastName}}
					<h4>Angular JS Example (END)</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<h4>Age From XML</h4>
					<label for="xml" class="sr-only">Age</label>
					<div id="xml"
						rows="10" ng-bind-html="xml1"></div>
				</div>
				<div class="col-md-6">
					<h4>Name From XML</h4>
					<label for="xslt" class="sr-only">Name</label>
					<div id="xslt" rows="10"
						ng-bind-html="xslt"></div>
				</div>
			</div>
			 <!--<div class="row" id="result">
				<div class="col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">
					<h4>Result</h4>
					<pre class="ng-binding">&lt;Query&gt;&lt;Key&gt;&lt;SomeNumber&gt;000123&lt;/SomeNumber&gt;&lt;/Key&gt;&lt;Option&gt;&lt;IncludeSomething&gt;Y&lt;/IncludeSomething&gt;&lt;AnotherItem&gt;N&lt;/AnotherItem&gt;&lt;JustForDemo&gt;N&lt;/JustForDemo&gt;&lt;XslStylesheet/&gt;&lt;/Option&gt;&lt;/Query&gt;</pre>
				</div>
			</div>-->
		</div>
		<script>
			var app = angular.module('myApp', ['ngXslt']);
			app.controller('myCtrl', function($scope, $sce) {
				 $scope.firstName = "John";
				 $scope.lastName = "Doe";
				 $scope.xml1 = $sce.trustAsHtml('<b><i><xsl:value-of select="//age" /></i></b>');
				 $scope.xslt =$sce.trustAsHtml('<h1><xsl:value-of select="//name" /></h1>');
			});
		</script>
		</body>
		
	</html>
  </xsl:template>

 <!--  <xsl:template match="person">
    <xsl:call-template name="processPerson">
      <xsl:with-param name="ageParam">
        65
      </xsl:with-param>
    </xsl:call-template>
  </xsl:template>

  <xsl:template name="processPerson">
    <xsl:param name="ageParam" />

    <tr>
      <td>
        <xsl:value-of select="name/text()" />
      </td>
      <td>
        <xsl:value-of select="age/text()"  />
        <xsl:if test="age/text() > $ageParam">
            (old!)
          </xsl:if>
      </td>
    </tr>    
  </xsl:template> -->
  

  <!-- <xsl:template match="people1">
      <head>
		<title>Struts 1.2 using AngularJS</title>
		<script type="text/javascript" src="js/angular.min.js">
			<![CDATA[
			//ADD SCRIPT HERE.
			]]>
		</script>
		<script type="text/javascript" src="js/angular.min.js"></script>
		</head>
	   <body>
		   <div ng-app = "">
		         <p>Enter your Name: <input type = "text" ng-model = "name"/></p>
		         <p>Hello <span ng-bind = "name"></span>!</p>
		    </div>  
	    </body>
  </xsl:template> -->

<!--   <xsl:template match="person">
    <xsl:call-template name="processPerson">
      <xsl:with-param name="ageParam">
      35
      </xsl:with-param>
    </xsl:call-template>
  </xsl:template>

  <xsl:template name="processPerson">
    <xsl:param name="ageParam" />
    <head>
	<title>Struts 1.2 using AngularJS</title>
	<script type="text/javascript" src="js/angular.min.js"></script>
	</head>
	   <body>
	   <div ng-app = "">
	         <p>Enter your Name: <input type = "text" ng-model = "name"/></p>
	         <p>Hello <span ng-bind = "name"></span>!</p>
	    </div>  
	    </body>
  </xsl:template> -->
</xsl:transform>