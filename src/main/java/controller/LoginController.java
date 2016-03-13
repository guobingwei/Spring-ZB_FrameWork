package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class LoginController {

    @RequestMapping(value = "login.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, ModelMap model) {
        String userName = request.getParameter("userName");
        Map user = new TreeMap<>();
        user.put("userName", userName);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        model.addAttribute("user",user);
        return new ModelAndView("main");
    }
}
