package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.search;

@WebServlet(name = "ServletProduct", urlPatterns = "/product")
public class ServletProduct extends HttpServlet {


    private ProductService ProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String action = request.getParameter("action");
           if (action == null){
               action = "";
           }

           switch (action){
               case "create":
                   addNewProduct(request, response);
               case "update":
                   updateProduct(request, response);

               default:
                   break;
           }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        ProductService.remove(id);
        request.setAttribute("message", "Delete successfully");
        goProductList(request, response);
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "create": showCreateForm(request, response);
            case "update": showUpdateForm(request, response);
            case "detail": getInfoProduct(request, response);
            case "delete": deleteProduct(request, response);
            case "sortProduct" : sortProduct(request, response);
            case "search" : searchProduct(request, response);
            default:
                goProductList(request, response);
                break;
        }

    }

    private void sortProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",ProductService.sortByName());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }


    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search1 = request.getParameter("searchProduct");
        request.setAttribute("listsearch",ProductService.searchProduct(search1));
        request.getRequestDispatcher("search.jsp").forward(request,response);
    }



    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("updateProduct",ProductService.findById(id));
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }


    public void goProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("list",ProductService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        Product product = new Product(id, name, price, description, manufacturer);
        ProductService.save(product);
        request.setAttribute("message", "Create successfully");
        goProductList(request, response);

    }




    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        Product product = new Product(id, name, price, description, manufacturer);
        ProductService.save(product);

        request.setAttribute("message", "Update successfully");
        goProductList(request, response);
    }


    private void getInfoProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("infoProduct",ProductService.findById(id));
        request.getRequestDispatcher("detail.jsp").forward(request,response);


    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }





}
