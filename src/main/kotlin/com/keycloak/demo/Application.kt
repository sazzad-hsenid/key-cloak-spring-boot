package com.keycloak.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}


@Controller
class HomeController {

    @RequestMapping("/")
    fun home() = "home"

    @RequestMapping(path = ["/customer"])
    fun customers(model: Model): String {
        return "customer"
    }

    @GetMapping(path = ["/logout"])
    @Throws(ServletException::class)
    fun logout(request: HttpServletRequest): String {
        request.logout()
        return "home"
    }

}