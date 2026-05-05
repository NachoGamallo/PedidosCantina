package org.ejercicio.cantina.controller;


import jakarta.transaction.Transactional;
import org.ejercicio.cantina.entity.Order;
import org.ejercicio.cantina.service.CantinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CantinaController {

    @Autowired
    private CantinaService cantinaService;

    // Página principal
    @GetMapping({"/", "/alumnos"})
    public String index(Model model) {

        model.addAttribute("alumnos",cantinaService.getAllAlums());
        model.addAttribute("totalAlumnos", cantinaService.getAllAlumns());
        model.addAttribute("pedidosHoy", cantinaService.getTodayOrders());
        return "alumnos";

    }

    // Listado de productos
    @GetMapping("/productos")
    public String products(Model model) {

        model.addAttribute("productos",cantinaService.getAllProducts());
        model.addAttribute("activos", cantinaService.getActiveProducts());
        model.addAttribute("sinStock", cantinaService.getProductsWithOutStock());
        return "productos";

    }

    // Show form.
    @GetMapping("/pedidos/nuevo")
    public String newOrder(Model model) {

        model.addAttribute("pedido", new Order());
        model.addAttribute("alumnos", cantinaService.getAllAlums());
        model.addAttribute("productos", cantinaService.getAllProducts());
        return "nuevo_pedido";

    }

    //Regist an order.
    @PostMapping("/pedidos/nuevo")
    public String registerOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes, Model model) {

        if (order.getQuantity() <= 0){

            model.addAttribute("error", "La cantidad debe ser mayor a 0");
            model.addAttribute("alumnos", cantinaService.getAllAlums());
            model.addAttribute("productos", cantinaService.getAllProducts());
            return "nuevo_pedido";
        }

        boolean check = cantinaService.registerOrder(order);
        if (check){
            redirectAttributes.addFlashAttribute("mensaje", "Pedido registrado con exito");
            return "redirect:/pedidos/pendientes";
        }else {

            model.addAttribute("error", "Error: Stock insuficiente o producto no valido");
            model.addAttribute("alumnos", cantinaService.getAllAlums());
            model.addAttribute("products", cantinaService.getAllProducts());
            return "nuevo_pedido";

        }
    }

    // Pedidos de un alumno
    @GetMapping("/pedidos/alumno/{id}")
    public String alumnOrder(@PathVariable("id") int idAlumn, Model model) {

        model.addAttribute("alumno", cantinaService.getAlumnById(idAlumn));
        model.addAttribute("pedidos", cantinaService.getOrderByAlumnId(idAlumn));
        return "pedidos_alumno";

    }

    // Pedidos pendientes
    @GetMapping("/pedidos/pendientes")
    public String pendingOrder(Model model) {

        model.addAttribute("pedidos", cantinaService.getPendingOrder());
        return "pedidos_pendientes";

    }

    @PostMapping("/pedidos/entregar/{id}")
    public String sendOrder(@PathVariable("id") int idOrder){

        cantinaService.markOrderAsTrue(idOrder);
        return "redirect:/pedidos/pendientes";

    }
}