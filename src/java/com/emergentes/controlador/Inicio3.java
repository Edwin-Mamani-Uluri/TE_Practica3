package com.emergentes.controlador;
import com.emergentes.dao.ProductoDAO3;
import com.emergentes.dao.ProductoDAOimpl3;
import com.emergentes.modelo.Producto3;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio3", urlPatterns = {"/inicio3"})
public class Inicio3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductoDAO3 dao = new ProductoDAOimpl3();
            int id;
            Producto3 pro = new Producto3();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            
            switch(action){
                case "add":
                    request.setAttribute("producto3", pro);
                    request.getRequestDispatcher("frmproducto3.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    System.out.println(pro);
                    request.setAttribute("producto3", pro);
                    request.getRequestDispatcher("frmproducto3.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio3");
                    break;
                case "view":
                    List<Producto3> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("index3.jsp").forward(request, response);
                default:
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error "+ ex.getMessage());
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre_producto = request.getParameter("nombre_producto");
        float precio = Float.parseFloat(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        
        Producto3 pro = new Producto3();
        
        pro.setId(id);
        pro.setNombre_producto(nombre_producto);
        pro.setPrecio(precio);
        pro.setStock(stock);
        
        if(id == 0){
            try{
                ProductoDAO3 dao  = new ProductoDAOimpl3();
                dao.insert(pro);
                response.sendRedirect(request.getContextPath()+"/inicio3");
            }catch (Exception ex){
                System.out.println("Error " + ex.getMessage());
            }
        }else
        {
            try{
                ProductoDAO3 dao  = new ProductoDAOimpl3();
                dao.update(pro);
                response.sendRedirect(request.getContextPath()+"/inicio3");
            }catch (Exception ex){
                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
