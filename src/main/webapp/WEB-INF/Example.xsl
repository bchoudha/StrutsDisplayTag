<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:template match="people">
		<head>
			<link rel="stylesheet"
				href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<![CDATA[
			//
			]]>
			</link>
			<title>Struts 1.2 using AngularJS</title>
			<script type="text/javascript" src="js/angular.min.js">
				<![CDATA[
				 angular.module('app', ['ngXslt'])
            .controller('ExampleController', [
                '$scope',
                function ($scope) {
                    $scope.xml = '<Test>\n\t<SomeNumber>000123</SomeNumber>\n</Test>';
                    $scope.xslt =
                            '<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">\n\t<xsl:output method="xml" encoding="utf-8" />\n\t<xsl:template match="/">\n\t\t<Query>\n\t\t\t<Key>\n\t\t\t\t<SomeNumber>\n\t\t\t\t\t<xsl:value-of select="//SomeNumber" />\n\t\t\t\t</SomeNumber>\n\t\t\t</Key>\n\t\t\t<Option>\n\t\t\t\t<IncludeSomething>Y</IncludeSomething>\n\t\t\t\t<AnotherItem>N</AnotherItem>\n\t\t\t\t<JustForDemo>N</JustForDemo>\n\t\t\t\t<XslStylesheet />\n\t\t\t</Option>\n\t\t</Query>\n\t</xsl:template>\n</xsl:stylesheet>';
                }
            ]);
				]]>
			</script>
			<script type="text/javascript" src="js/ng-xslt.js">
			<![CDATA[
			]]>
			</script>
			<!-- <script type="text/javascript" src="js/angular.min.js"></script> -->
		</head>
		<!-- <h1>List of people in the XML document</h1> <table border="1"> <th>Name</th> 
			<th>Age</th> <xsl:apply-templates /> </table> -->
		<body>
		<table border="1">
			<div ng-app="">
				<p>
					Enter your Name:
					<input type="text" ng-model="name" />
				</p>
				<p>
					Hello
					<span ng-bind="name"></span>
				</p>
			</div>
		</table>

		<div class="container">
			<div class="page-header">
				<h1>
					<strong>Angular XSLT</strong>
					module
				</h1>
			</div>

			<p class="lead">
				This example shows an example usage of
				<code>angular-xslt</code>
				module
			</p>

			<p>
				It takes input XML, applies XSL template using
				<code>xslt</code>
				filter and outputs
				<a href="#result">result</a>
				of transformation
			</p>


			<h2>Live demo</h2>

			<p class="indent">
				<small>
					You can modify both XML and XSLT, and filter will be
					instantly applied
					thanks to Angular data binding
	        </small>
			</p>

			<div ng-controller="ExampleController" class="ng-scope">
				<div class="row">
					<div class="col-md-6">
						<h4>XML</h4>
						<label for="xml" class="sr-only">XML</label>
						<textarea id="xml"
							class="form-control ng-pristine ng-valid ng-touched" rows="10"
							ng-model="xml"></textarea>
					</div>
					<div class="col-md-6">
						<h4>XSLT</h4>
						<label for="xslt" class="sr-only">XSLT</label>
						<textarea id="xslt"
							class="form-control ng-pristine ng-untouched ng-valid" rows="10"
							ng-model="xslt"></textarea>
					</div>
				</div>
				<div class="row" id="result">
					<div class="col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">
						<h4>Result</h4>
						<pre class="ng-binding">&lt;Query&gt;&lt;Key&gt;&lt;SomeNumber&gt;000123&lt;/SomeNumber&gt;&lt;/Key&gt;&lt;Option&gt;&lt;IncludeSomething&gt;Y&lt;/IncludeSomething&gt;&lt;AnotherItem&gt;N&lt;/AnotherItem&gt;&lt;JustForDemo&gt;N&lt;/JustForDemo&gt;&lt;XslStylesheet/&gt;&lt;/Option&gt;&lt;/Query&gt;</pre>
					</div>
				</div>
			</div>
		</div>
		</body>
	</xsl:template>

	<!-- <xsl:param name="ageParam"> 30 </xsl:param> -->
	<!-- <xsl:template match="person"> <xsl:call-template name="processPerson"> 
		<xsl:with-param name="ageParam"> 65 </xsl:with-param> </xsl:call-template> 
		</xsl:template> <xsl:template name="processPerson"> <xsl:param name="ageParam" 
		/> <tr> <td> <xsl:value-of select="name/text()" /> </td> <td> <xsl:value-of 
		select="age/text()" /> <xsl:if test="age/text() > $ageParam"> (old!) </xsl:if> 
		</td> </tr> </xsl:template> -->


	<!-- <xsl:template match="people1"> <head> <title>Struts 1.2 using AngularJS</title> 
		<script type="text/javascript" src="js/angular.min.js"> <![CDATA[ //ADD SCRIPT 
		HERE. ]]> </script> <script type="text/javascript" src="js/angular.min.js"></script> 
		</head> <body> <div ng-app = ""> <p>Enter your Name: <input type = "text" 
		ng-model = "name"/></p> <p>Hello <span ng-bind = "name"></span>!</p> </div> 
		</body> </xsl:template> -->

	<!-- <xsl:template match="person"> <xsl:call-template name="processPerson"> 
		<xsl:with-param name="ageParam"> 35 </xsl:with-param> </xsl:call-template> 
		</xsl:template> <xsl:template name="processPerson"> <xsl:param name="ageParam" 
		/> <head> <title>Struts 1.2 using AngularJS</title> <script type="text/javascript" 
		src="js/angular.min.js"></script> </head> <body> <div ng-app = ""> <p>Enter 
		your Name: <input type = "text" ng-model = "name"/></p> <p>Hello <span ng-bind 
		= "name"></span>!</p> </div> </body> </xsl:template> -->
</xsl:transform>