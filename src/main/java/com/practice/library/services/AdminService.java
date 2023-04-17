package com.practice.library.services;

import com.practice.library.entity.Admin;

public interface AdminService {

    Admin getAdmin(Long id);
    Admin getAdmin(String email);
    Admin saveAdmin(Admin admin);

}
