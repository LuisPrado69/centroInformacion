/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.controlador;

import com.uisrael.centroinformacion.modelo.dao.UsuarioDao;
import java.util.Map;

import com.uisrael.centroinformacion.servicios.ServiciosEmail;
import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LUCHO
 */
@Controller
public class RecuperarContrasenaControlador {

    UsuarioDao usuarioDao = new UsuarioDao();

    @Autowired
    private ServiciosEmail emailServicio;

    @RequestMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetRequest(@RequestParam(value = "email") String email) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        usuarioDao.generarToken(email, token);
        emailServicio.sendMail(email, token);
        return "checkMail";
    }

    @RequestMapping(value = "/newPassword/{email}/{token}")
    public String resetPassword(@PathVariable String email,@PathVariable String token, Map<String, String> model) {

        // VERIFY TOKEN URL OR POST 
        // ALTER TABLE PASSWORD USER
        // EXIT TO RECOVERY PASSWORD
        model.put("emailid", email);
        model.put("token", token);
        return "newPassword";
    }
}
