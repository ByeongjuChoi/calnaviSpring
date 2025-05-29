package com.example.demo.mapper;

import com.example.demo.model.UserSAL;
public interface UserSALMapper {
    
    void userSalInsert(UserSAL userSAL);
    UserSAL userSalSelect(String userid, String year_month);
}
