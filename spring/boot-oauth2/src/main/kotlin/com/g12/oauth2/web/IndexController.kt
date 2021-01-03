package com.g12.oauth2.web

import com.g12.oauth2.config.SessionUser
import javax.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping
class IndexController {

    @GetMapping
    fun index(httpRequest: HttpServletRequest, model: Model): String {

        val sessionUser = (httpRequest.session.getAttribute("user") ?: return "index") as SessionUser

        model.addAttribute("userName", sessionUser.name)
        model.addAttribute("userEmail", sessionUser.email)

        return "index"
    }
}