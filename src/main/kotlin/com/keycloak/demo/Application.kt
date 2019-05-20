package com.keycloak.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import sun.security.x509.OIDMap.addAttribute
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping



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

}