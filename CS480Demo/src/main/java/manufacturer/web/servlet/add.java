package manufacturer.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manufacturer.domain.Manufacturer;
import manufacturer.service.ManufacturerException;
import manufacturer.service.ManufacturerService;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public add() {
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
		Map<String, String[]> paramMap = request.getParameterMap();
		Manufacturer manufacturer = new Manufacturer();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		
		manufacturer.setName(info.get(1));

		try {
			manufacturerservice.add(manufacturer);

			response.sendRedirect("findAllManufacturer");
		} catch (ClassNotFoundException | ManufacturerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
