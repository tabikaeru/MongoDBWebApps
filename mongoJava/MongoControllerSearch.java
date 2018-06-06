package MongoDB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MongoContorollerUpdate
 */
@WebServlet("/MongoControllerSearch")
public class MongoControllerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MongoControllerSearch() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		
		
		//Getting parameters
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String duration = request.getParameter("duration");
		String natio = request.getParameter("natio");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		MongoProcessingSearch param = new MongoProcessingSearch();
		MongoBeans bean = param.ProcessUserData(title, year, duration, natio, name, age);
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>ShowGet(name and old)</title>");
		sb.append("</head>");
		sb.append("<body><p>The following inormation was saved:</p><ul>");
		
		sb.append("<li>Title: ");
		sb.append(bean.gettitle());
		sb.append("<li>Year: ");
		sb.append(bean.getyear());
		sb.append("</li><li>Nation: ");
		sb.append(bean.getduration());
		sb.append("</li><li>Duration: ");
		sb.append(bean.getduration());
		sb.append("</li><li>name: ");
		sb.append(bean.getname());
		sb.append("</li><li>age: ");
		sb.append(bean.getage());

		sb.append("</li></ul>");
		
		sb.append("</body>");
		sb.append("</html>");
		
		out.println(new String(sb));
		out.close();
		
		
		
		

		// move to result.jsp
		//request.setAttribute("filmList", filmList);
		//request.getRequestDispatcher("/WebContent/WEB-INF/jsp/filmList.jsp").forward(request, response);
		
	}

}
