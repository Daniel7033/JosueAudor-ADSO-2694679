package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.IService.IContractService;
import com.sena.seguridad.Entity.Contract;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/contract")
public class ContractController extends ABaseController<Contract,IContractService>{

	protected ContractController(IContractService service) {
		super(service, "Contract");
	}

	
}
