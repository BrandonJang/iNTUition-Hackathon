package iNTUition;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Thread;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        int id =Integer.parseInt(request.getParameter("id"));
//        double account_balance = Double.parseDouble(request.getParameter("account_balance"));
        double account_balance = 0;
         
        System.out.println("ID number: " + id);
//        System.out.println("Account Balance: " + account_balance);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your ID number is: " + id + "<br/>";      
        htmlResponse += "Your Account Balance is: $" + String.format("%.2f",account_balance) + "</h2>";    
        htmlResponse += "</html>";
        
        // return response
        writer.println(htmlResponse);
        
        //add new user into database
        writer.println(UpdateUsers.addNewUser(UpdateUsers.account_map, id, account_balance));
        
        String htmlResponse2 = "<html><br/>";
        htmlResponse2 += "<a href=\"index.html\"><button type = \"button\">Back to Home</button></a>";
        writer.println(htmlResponse2);
        
        
         
    }

}
