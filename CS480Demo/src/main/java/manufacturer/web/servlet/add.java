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
		Manufacturer manufacturer = new Manufacturer();
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		
		int id = Integer.parseInt(info.get(0));
		
		try {
			manufacturer = manufacturerservice.findById(id);

			request.setAttribute("manufacturer", manufacturer);
			request.getRequestDispatcher("/jsps/manufacturer/add.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		
		if(info.get(0) != "") {
			manufacturer.setId(Integer.parseInt(info.get(0)));
		}
		else {
			manufacturer.setId(0);
		}
		
		manufacturer.setName(info.get(1));
		
		try {
			if(manufacturer.getId() == 0) {
				manufacturerservice.add(manufacturer);
			}
			else {
				manufacturerservice.update(manufacturer);
			}
			
			request.getRequestDispatcher("findAllManufacturer").forward(request, response);
		} catch (ClassNotFoundException | ManufacturerException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("manufacturer", manufacturer);
			request.getRequestDispatcher("/jsps/manufacturer/add.jsp").forward(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		}
	}

}
