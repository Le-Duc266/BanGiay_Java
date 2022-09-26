/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "admin")
public class HomeController {
    private checkUrl c;

    public HomeController() {
        c = new checkUrl();

    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpSession session) {
        if (c.check(session)) {
            return "admin/index";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }
}
