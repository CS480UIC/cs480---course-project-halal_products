package manufacturer.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manufacturer.service.ManufacturerService;

/**
 * Servlet implementation class findAll
 */
@WebServlet(name = "findAllManufacturer", urlPatterns = { "/findAllManufacturer" })
public class findAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public findAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManufacturerService manufacturerservice = new ManufacturerService();

		try {
			request.setAttribute("ManufacturerList", manufacturerservice.findall());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/jsps/manufacturer/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
