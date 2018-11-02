<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
     <style type="text/css">
		body {
		background-image: url('http://www.azmandavidson.com.my/wp-content/uploads/2016/02/Login-background-1024x512.jpg');
		}
		</style>
		<h2>
			Welcome! Have a good day!<br> <br>
		</h2>
    <body>
  <table>
            
    	
        <tr>
            <th>FirstName</th><th>LastName</th><th>Email</th>
        </tr> 
        <tr>
        	<td>${firstname}</td><td>${lastname}</td><td>${email}</td>
        </tr>
    
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
                <td><a href="home.jsp">Home</a>
                </td>
            </tr>
        </table>
    </body>
    </html>