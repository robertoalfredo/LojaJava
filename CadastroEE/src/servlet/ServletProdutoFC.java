package servlet;



import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import controller.ProdutoDAO;
import model.Produto;


@WebServlet("/ServletProdutoFC")
public class ServletProdutoFC extends HttpServlet {

    private ProdutoDAO dao = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        String destino = "ProdutoLista.jsp";

        try {

       
            if ("listar".equals(acao)) {
                List<Produto> lista = dao.findAll();
                request.setAttribute("lista", lista);
            }

     
            else if ("formIncluir".equals(acao)) {
                destino = "ProdutoDados.jsp";
            }

         
            else if ("formAlterar".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Produto p = dao.find(id);

                request.setAttribute("produto", p);
                destino = "ProdutoDados.jsp";
            }

            
            else if ("incluir".equals(acao)) {
                Produto p = new Produto();

                p.setNome(request.getParameter("nome"));
                p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                p.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));

                dao.create(p);

                List<Produto> lista = dao.findAll();
                request.setAttribute("lista", lista);
            }

           
            else if ("alterar".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));

                Produto p = dao.find(id);
                p.setNome(request.getParameter("nome"));
                p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                p.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));

                dao.edit(p);

                List<Produto> lista = dao.findAll();
                request.setAttribute("lista", lista);
            }

            // ✅ EXCLUIR
            else if ("excluir".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));

                dao.remove(id);

                List<Produto> lista = dao.findAll();
                request.setAttribute("lista", lista);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}


