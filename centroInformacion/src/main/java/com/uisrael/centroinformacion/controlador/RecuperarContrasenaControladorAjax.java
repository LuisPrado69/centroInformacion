/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.controlador;

import com.uisrael.centroinformacion.modelo.dao.PasswordDao;
import com.uisrael.centroinformacion.modelo.dao.UsuarioDao;
import com.uisrael.centroinformacion.modelo.entidades.Password;
import com.uisrael.centroinformacion.modelo.entidades.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author crifa
 */
/**
 * Servlet implementation class RecuperarContrasenaControladorAjax
 */
@WebServlet("/RecuperarContrasenaControladorAjax")
@RequestMapping("/RecuperarContrasenaControladorAjax")
public class RecuperarContrasenaControladorAjax extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UsuarioDao usuarioDao = new UsuarioDao();
    PasswordDao passwordDao = new PasswordDao();

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

        int asunto = Integer.parseInt(request.getParameter("asunto"));
        
        // Verify Email
        if (asunto == 1) {
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
        // Verify token and update password
        } else if (asunto == 2) {
            String password = request.getParameter("password");
            String token = request.getParameter("token");
            // Find user by token
            Usuario usuario = usuarioDao.findByToken(token);
            if (usuario == null) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("false");
            } else {
                
                // Insert password
                Password newPassword = new Password();
                newPassword.setUserUserId(usuario.getUserId());
                newPassword.setPassDate(new Date());
                newPassword.setPassStatus(1);
                // TODO: format PASSWORD
                newPassword.setPassValue(password);
                passwordDao.insertar(newPassword);
                
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("true");
            }
        }
    }

}
