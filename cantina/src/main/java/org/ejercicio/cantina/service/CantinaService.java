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
        return orderRepo.getOrderByStatusIsFalse(false);
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
}