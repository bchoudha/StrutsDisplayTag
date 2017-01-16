<%@page import="org.w3c.dom.Document"%>
<%@page import="com.test.XMLutils"%>
<%
Document viewDom = (Document) request.getAttribute("DOM");
//System.out.println("viewDom=======>>"+viewDom);
long startTime = System.currentTimeMillis();
ServletContext context = getServletContext();
String path = context.getRealPath("/WEB-INF/ExampleXML.xsl");
//System.out.println("path=="+path);
String screenCaptureHtml = XMLutils.XSLTFromDocToHTML(viewDom,path);
//System.out.println("HTML================>>"+screenCaptureHtml);
out.print(screenCaptureHtml);
%>