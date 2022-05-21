package controller;

import model.KhachHang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_customer" , urlPatterns = "/customer")
public class Servlet_customer extends HttpServlet {

    List<KhachHang> customerList = new ArrayList<>();

    public void init() {
       customerList.add(new KhachHang("A","01-01-2021","Đà Nẵng 1","D:\\JSP+Sevlet\\Danh Sách Khách Hàng\\src\\main\\webapp\\img\\gabriel-lopes-silence-ok.jpg"));
       customerList.add(new KhachHang("B","02-01-2021","Đà Nẵng 2","D:\\JSP+Sevlet\\Danh Sách Khách Hàng\\src\\main\\webapp\\img\\s0rldm9jov061.jpg"));
       customerList.add(new KhachHang("C","03-01-2021","Đà Nẵng 3","D:\\JSP+Sevlet\\Danh Sách Khách Hàng\\src\\main\\webapp\\img\\s0rldm9jov061.jpg"));
       customerList.add(new KhachHang("D","04-01-2021","Đà Nẵng 4","D:\\JSP+Sevlet\\Danh Sách Khách Hàng\\src\\main\\webapp\\img\\s0rldm9jov061.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action="";
        }
        switch (action){
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",customerList);
        request.getRequestDispatcher("/views/danh_sach.jsp").forward(request,response);
    }
}
