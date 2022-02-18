package region.web.servlet;

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


import region.domain.Region;
import region.service.RegionException;
import region.service.RegionService;

/**
 * Servlet implementation class add
 * @author abdul
 * @author meraj
 */
@WebServlet(name = "addregion", urlPatterns = { "/addregion" })
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
		RegionService regionservice = new RegionService();
		Region region = new Region();
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		
		int id = Integer.parseInt(info.get(0));
		
		try {
			region = regionservice.findById(id);

			request.setAttribute("region", region);
			request.getRequestDispatcher("/jsps/region/add.jsp").forward(request, response);
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
		RegionService regionservice = new RegionService();
		Map<String, String[]> paramMap = request.getParameterMap();
		Region region = new Region();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {

			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		
		if(info.get(0) != "") {
			region.setId(Integer.parseInt(info.get(0)));
		}
		else {
			region.setId(0);
		}
		
		region.setName(info.get(1));
		
		try {
			if(region.getId() == 0) {
				regionservice.add(region);
			}
			else {
				regionservice.update(region);
			}
			
			request.getRequestDispatcher("findAllRegion").forward(request, response);
		} catch (ClassNotFoundException | RegionException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("region", region);
			request.getRequestDispatcher("/jsps/region/add.jsp").forward(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		}
	}

}
