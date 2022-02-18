package store.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import region.service.RegionService;
import store.service.StoreService;

/**
 * Servlet implementation class search
 */
@WebServlet(name = "searchStore", urlPatterns = { "/searchStore" })
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		StoreService storeservice = new StoreService();
		RegionService regionservice = new RegionService();

		try {
			
				List<region.domain.Region> listregion = regionservice.findall();
				request.setAttribute("listregion", listregion);
				
				String bub = request.getParameter("button");
			
				System.out.println(bub);
				
				if(bub == null)
				{
					;
				}
				else if(bub.equals("Search By Region"))
				{
					String reg = request.getParameter("region");
					System.out.println(reg);
					System.out.println(reg);
					request.setAttribute("StoreList", storeservice.searchByRegion_Id(reg));
				}
				else if(bub.equals("Search By StoreName"))
				{
					String n = request.getParameter("name");
					System.out.println(n);
					request.setAttribute("StoreList", storeservice.searchByStore_Name(n));
				}
				else if(bub.equals("Search By Zip"))
				{
					String reg = request.getParameter("zip");
					
					if(reg.equals(""))
					{
						;
					}
					else
					{
						request.setAttribute("StoreList", storeservice.searchByZip(reg));
					}
					
				}
			

			request.getRequestDispatcher("/jsps/store/search.jsp").forward(request, response);
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Based on what button 
		
//		request.getRequestDispatcher("/jsps/store/search.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
