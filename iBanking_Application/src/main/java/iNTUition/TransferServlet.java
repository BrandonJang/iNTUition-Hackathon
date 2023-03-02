package iNTUition;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       // read form fields
       int sender_id =Integer.parseInt(request.getParameter("sender_id"));
       int receiver_id  =Integer.parseInt(request.getParameter("receiver_id"));
       double amount = Double.parseDouble(request.getParameter("amount"));

       // get response writer
       PrintWriter writer = response.getWriter();
        
       // build HTML code
       String htmlResponse = "<html>";
       htmlResponse += "<h2>Sender ID number is: " + sender_id + "<br/>";  
       htmlResponse += "Receipient ID number is: " + receiver_id + "<br/>";
       htmlResponse += "The amount being transferred is: $" + amount + "</h2>";    
       htmlResponse += "</html>";
       
       // return response
       writer.println(htmlResponse);
       
       //top up users account
       writer.println(Transact.transfer(UpdateUsers.account_map, sender_id, receiver_id, amount));
       
       String htmlResponse2 = "<html><br/>";
       htmlResponse2 += "<a href=\"index.html\"><button type = \"button\">Back to Home</button></a>";
       writer.println(htmlResponse2);
       
       
        
   }

}
