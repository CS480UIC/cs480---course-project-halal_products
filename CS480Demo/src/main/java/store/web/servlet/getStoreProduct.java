package store.web.servlet;

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

import store.service.StoreService;

/**
 * Servlet implementation class getStoreProduct
 */
@WebServlet("/getStoreProduct")
public class getStoreProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getStoreProduct() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StoreService storeservice = new StoreService();

		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}

		String product_name = "";
		Integer zipcode = null;

		product_name = info.get(0);

		request.setAttribute("product_name", product_name);

		if (info.get(1) != "") {
			zipcode = Integer.parseInt(info.get(1));
		}

		request.setAttribute("zipcode", zipcode);

		try {
			request.setAttribute("DetailList", storeservice.getStoreByProduct(product_name, zipcode));

			request.getRequestDispatcher("/jsps/store/storeProduct.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/jsps/store/storeProduct.jsp").forward(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/jsps/store/storeProduct.jsp").forward(request, response);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/jsps/store/storeProduct.jsp").forward(request, response);
		}
	}

}
