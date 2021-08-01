package product.web.servlet;

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

import product.service.ProductService;
import region.domain.Region;
import region.service.RegionService;

/**
 * Servlet implementation class StoreAvailability
 */
@WebServlet("/ProductAvailability")
public class ProductAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService productservice = new ProductService();
		RegionService regionservice = new RegionService();

		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		Integer region_id = null;

		if (info.get(0) != "") {
			region_id = Integer.parseInt(info.get(0));
		}

		request.setAttribute("region_id", region_id);

		try {
			request.setAttribute("listregion", regionservice.findall());
			
			request.setAttribute("DetailList", productservice.findProductByStoreAvailability(region_id));

			request.getRequestDispatcher("/jsps/product/productAvailability.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/jsps/product/productAvailability.jsp").forward(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/jsps/product/productAvailability.jsp").forward(request, response);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/jsps/product/productAvailability.jsp").forward(request, response);
		}
	}

}
