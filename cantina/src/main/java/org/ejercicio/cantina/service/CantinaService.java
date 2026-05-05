package org.ejercicio.cantina.service;

import jakarta.transaction.Transactional;
import org.ejercicio.cantina.entity.Alumn;
import org.ejercicio.cantina.entity.Order;
import org.ejercicio.cantina.entity.Product;
import org.ejercicio.cantina.repository.AlumnRepository;
import org.ejercicio.cantina.repository.OrderRepository;
import org.ejercicio.cantina.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class CantinaService {

    @Autowired
    private AlumnRepository alumnRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    public List<Alumn> getAllAlums(){
        return alumnRepo.findAll();
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Order> getPendingOrder(){
        return orderRepo.getOrderByStatus(false);
    }

    public long getNumPendingOrder(){
        return orderRepo.getOrderByStatus(false).size();
    }

    public List<Order> getOrderByAlumnId(int idAlumn){
        return orderRepo.getOrderByAlumn_Id(idAlumn);
    }

    public Alumn getAlumnById(int id){
        return alumnRepo.findById(id).orElse(null);
    }

    //Principal logic to register cheking the stock.
    @Transactional
    public boolean registerOrder(Order order){

        Product product = productRepo.findById(order.getProduct().getId()).orElse(null);

        //Check if the product exists, and the quantity is > 0 and there's available stock.
        if (product != null && order.getQuantity() > 0 && product.getStock() >= order.getQuantity()) {

            //Update stock.
            product.setStock(product.getStock() - order.getQuantity());
            productRepo.save(product);

            //save order.
            orderRepo.save(order);
            return true;
        }else return false;

    }

    //Mark order as true.
    @Transactional
    public void markOrderAsTrue(int idOrder){

        Order order = orderRepo.findById(idOrder).orElse(null);
        if (order != null){

            order.setStatus(true);
            orderRepo.save(order);

        }

    }

    //Total alumnos.
    public long getAllAlumns(){ return alumnRepo.count(); }

    //Pedidos de hoy
    public long getTodayOrders(){
        return orderRepo.findAll().stream()
                .filter(o -> o.getCreated_at() != null &&
                        o.getCreated_at().toLocalDate().equals(LocalDate.now()))
                .count();
    }

    //Productos activos (con stock).
    public long getActiveProducts() {
        return productRepo.findAll().stream()
                .filter(p -> p.getStock() > 0)
                .count();
    }

    //Productos con stock 0
    public long getProductsWithOutStock() {
        return productRepo.findAll().stream()
                .filter(p -> p.getStock() == 0)
                .count();
    }

    public long getNumberOrdersByAlumn(int idAlumn){ return orderRepo.getOrderByAlumn_Id(idAlumn).size(); }

    public Product getProductById(int idProduct){ return productRepo.getProductById(idProduct);}
}