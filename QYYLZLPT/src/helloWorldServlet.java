import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class helloWorldServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public helloWorldServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 request.setCharacterEncoding("utf-8");
	      String user = request.getParameter("user");
	      
	      response.setCharacterEncoding("utf-8");
	      PrintWriter out = response.getWriter();
	      //out.print("{idnumber:'888',name:'json',age:'18'}");//得到的JSON
	      //out.print("{list:[{name:'lisa',age:'18'},{name:'carson',age:'20'}]}");//得到的JSON
	      out.print("{list:[{id:'123',name:'lisa'},{id:'456',name:'carson'},{id:'789',name:'fear'}]}");
	      //out.print("{\"name\":\"fly\",\"type\":\"虫子\"}");
	      /*out.print("{“list”:[{“time”:”2014-09-11-08-09-09”, 
	      “systolic_pressure”:150.1, “diastolic_pressure”:88.7, “heart_rate”:87.4}, {“time”:”2014-10-10-19-22-22”, “systolic_pressure”:144.5, “diastolic_pressure”:87.9, “heart_rate”:99.0}]}");
	      */
	      //String tempjs;
	      //out.print("{idnumber:'888',username:'json',username:'json',age:'18'}");//得到的JSON

	      String tempjs="{idnumber:'999',username:'hello',gender:'男',race:'汉',age:'24',marriage:'未婚',job:'学生',address:'汕头大学',occupation:'汕头大学',tel_1:'1234567',tel_2:'7896541',tel_3:'5467891',history_1:'无',history_2:'无',history_3:'无' }";
	      //out.print(tempjs);
	      		//",race:'汉',age:'24',marriage:'未婚',job:'学生',address:'汕头大学',occupation:'汕头大学',tel_1:'1234567',tel_2:'7896541',tel_3:'5467891',history_1:'无',history_2:'无',history_3:'无' }");
      	

	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
