package com.sena.seguridad.Service.Seguridad;

import com.sena.seguridad.Entity.User;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Seguridad.IUserRepository;
import com.sena.seguridad.IService.Seguridad.IUserService;
import com.sena.seguridad.Service.ABaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ABaseService<User> implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected IBaseRepository<User, Long> getRepository() {
        return userRepository;
    }

    
}
