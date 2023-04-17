package com.practice.library.services;


import com.practice.library.entity.Admin;
import com.practice.library.repository.AdminRepository;
import com.practice.library.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    @Override
    public Admin getAdmin(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return unwrapAdmin(admin, id);
    }

    @Override
    public Admin getAdmin(String email) {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        return unwrapAdmin(admin, 404L);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    static Admin unwrapAdmin(Optional<Admin> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Admin.class);
    }

}
