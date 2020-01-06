/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.controlador;

import com.uisrael.centroinformacion.modelo.dao.UsuarioDao;
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
    UsuarioDao usuarioDao = new UsuarioDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarContrasenaControladorAjax() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        
        boolean existeUsuario = usuarioDao.exists(email);

        if (existeUsuario) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("true");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("false");
        }
    }

}
