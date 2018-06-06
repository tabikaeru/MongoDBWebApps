package MongoDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;
import MongoDB.MongoBeans;
import MongoDB.MongoProcessingDelete;



/**
 * Servlet implementation class MongoController
 */
@WebServlet("/MongoControllerDelete")
public class MongoControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MongoControllerDelete() {
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
				MongoProcessingDelete param = new MongoProcessingDelete();
				MongoBeans bean = param.ProcessUserData(title, year, duration, natio, name, age);
				MongoClient client = null;
				client = new MongoClient("localhost", 27017);
				MongoDB mongo = new MongoDB();
		        DB db = mongo.getConnection().getDB("cinema");
		        DBCollection films = db.getCollection("films");
		        DBCursor cursor = films.find();
		        ArrayList<DBObject> filmList = new ArrayList<DBObject>();
				sb.append("<html>");
				sb.append("<head>");
				sb.append("<title>ShowGet(name and old)</title>");
				sb.append("</head>");
				sb.append("<body><p>The following inormation was saved:</p><ul>");
				while(cursor.hasNext()) {
		              DBObject obj = cursor.next();
		              filmList.add(obj);
		              sb.append("</li><li>");
		              sb.append(obj);
		            
		          };
				sb.append("</li></ul>");
				
				sb.append("</body>");
				sb.append("</html>");
				
				out.println(new String(sb));
				out.close();
				
				
				
				//request.setAttribute("fromServlet", bean);

				// move to result.jsp
				//request.setAttribute("filmList", filmList);
				//request.getRequestDispatcher("/WebContent/WEB-INF/jsp/filmList.jsp").forward(request, response);
				
			}
}
