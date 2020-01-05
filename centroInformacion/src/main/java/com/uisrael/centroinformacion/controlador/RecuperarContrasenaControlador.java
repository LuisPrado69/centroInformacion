/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.controlador;

import java.util.Map;

import com.uisrael.centroinformacion.servicios.ServiciosEmail;
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
        //check if the email id is valid and registered with us.
        emailServicio.sendMail(email);
        return "checkMail";
    }

    @RequestMapping(value = "/newPassword/{email}")
    public String resetPassword(@PathVariable String email, Map<String, String> model) {
        //check if the email id is valid and registered with us.
        model.put("emailid", email);
        return "newPassword";
    }
}
