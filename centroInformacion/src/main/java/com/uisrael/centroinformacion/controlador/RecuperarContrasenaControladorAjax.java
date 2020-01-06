/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.controlador;

import com.uisrael.centroinformacion.modelo.dao.UsuarioDao;
import com.uisrael.centroinformacion.modelo.entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crifa
 */
/**
 * Servlet implementation class RecuperarContrasenaControladorAjax
 */
@WebServlet("/RecuperarContrasenaControladorAjax")
public class RecuperarContrasenaControladorAjax extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarContrasenaControladorAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //@EJB
    private UsuarioDao usuarioDao;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        // TODO: query
        // Usuario existeUsuario = usuarioDao.findByEmail("luis.prado@crifa.com");
        
        if (email == "luis.prado@crifa.com") {
            response.getWriter().write("false");
        } else {
            response.getWriter().write("true");
        }
    }

}
