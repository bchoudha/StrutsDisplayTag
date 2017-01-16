<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:param name="ageParam">30</xsl:param>

  <xsl:template match="people">
	  <head>
		<title>Struts 1.2 using AngularJS</title>
		<script type="text/javascript" src="js/angular.min.js">
				<![CDATA[
				//ADD SCRIPT HERE.
				]]>
		</script>
		<!-- <script type="text/javascript" src="js/angular.min.js"></script> -->
	</head>
    <h1>List of people in the XML document</h1>
    <table border="1">
		<th>Name</th>
		<th>Age</th>
		<xsl:apply-templates />
	</table>
	<table border="1">
	     <div ng-app="">
			<p>
				Enter your Name:
				<input type="text" ng-model="name" />
			</p>
			<p>
				Hello <span ng-bind="name"></span>
			</p>
		</div>  
	</table>
  </xsl:template>

  <xsl:template match="person">
    <xsl:call-template name="processPerson">
      <xsl:with-param name="ageParam">
        65
      </xsl:with-param>
    </xsl:call-template>
  </xsl:template>

  <xsl:template name="processPerson">
    <!-- <xsl:param name="ageParam" /> -->

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
  </xsl:template>
  

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