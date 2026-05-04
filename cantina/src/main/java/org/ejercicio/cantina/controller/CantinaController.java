package org.ejercicio.cantina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CantinaController {

    // Página principal
    @GetMapping({"/", "/alumnos"})
    public String index() {
        return "alumnos";
    }

    // Listado de productos
    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }

    // Formulario nuevo pedido
    @GetMapping("/nuevo_pedido")
    public String nuevoPedido() {
        return "nuevo_pedido";
    }

    // Pedidos de un alumno
    @GetMapping("/pedidos_alumno")
    public String pedidosAlumno() {
        return "pedidos_alumno";
    }

    // Pedidos pendientes
    @GetMapping("/pedidos_pendientes")
    public String pedidosPendientes() {
        return "pedidos_pendientes";
    }

}