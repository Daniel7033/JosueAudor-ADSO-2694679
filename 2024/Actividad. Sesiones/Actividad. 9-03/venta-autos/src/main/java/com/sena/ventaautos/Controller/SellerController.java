package com.sena.ventaautos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ventaautos.Entity.Seller;
import com.sena.ventaautos.IService.ISellerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/seller")
public class SellerController extends ABaseController<Seller,ISellerService>{
    public SellerController(ISellerService service){
        super(service, "Seller");
    }
}
