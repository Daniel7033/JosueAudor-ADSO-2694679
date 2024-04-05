package com.sena.seguridad.Service;

import com.sena.seguridad.Entity.User;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IUserRepository;
import com.sena.seguridad.IService.IUserService;
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
