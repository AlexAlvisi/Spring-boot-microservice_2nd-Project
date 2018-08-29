package com.project.microservices.ToDoMicroservice.services;

import com.project.microservices.ToDoMicroservice.daos.UserDao;
import com.project.microservices.ToDoMicroservice.entities.User;
import com.project.microservices.ToDoMicroservice.utilities.EncryptionUtils;
import com.project.microservices.ToDoMicroservice.utilities.JwtUtils;
import com.project.microservices.ToDoMicroservice.utilities.UserNotInDatabaseException;
import com.project.microservices.ToDoMicroservice.utilities.UserNotLoggedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao;

    @Autowired
    EncryptionUtils encryptionUtils;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public Optional<User> getUserFromDb(String email, String pwd) throws UserNotInDatabaseException{
        Optional<User> userr = userDao.findUserByEmail(email);
        if(userr.isPresent()){
            User user = userr.get();
            if(! encryptionUtils.decrypt(user.getPassword()).equals(pwd)){
                throw  new UserNotInDatabaseException("Wrong Email or Password");
            }
        }else{
            throw  new UserNotInDatabaseException("Wrong Email or Password");
        }
        return userr;
    }

    @Override
    public String createJwt(String email, String name, Date date) throws UnsupportedEncodingException{
        date.setTime(date.getTime() + (300*1000));
        return jwtUtils.generateJwt(email, name, date);
    }


    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws  UnsupportedEncodingException, UserNotLoggedException{
        String jwt = jwtUtils.getJwtFromHttpRequest(request);
        if(jwt == null){
            throw  new UserNotLoggedException("User not logged! Login first.");
        }
        return jwtUtils.jwt2Map(jwt);
    }

}

