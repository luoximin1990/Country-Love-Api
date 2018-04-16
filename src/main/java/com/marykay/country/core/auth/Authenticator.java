//package com.marykay.country.core.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.marykay.country.core.auth.oauth.OAuthService;
//import com.marykay.country.core.exception.AuthenticationException;
////import com.marykay.country.love.model.Admin;
////import com.marykay.country.love.service.AdminService;
//import com.marykay.country.love.util.DateTimeUtility;
//
//import java.util.Date;
//
///**
// * Created by wanwei on 2016/10/11.
// */
//@Component
//public class Authenticator {
//
//    @Autowired
//    OAuthService oAuthService;
////    @Autowired
////    private AdminService adminService;
//
//
////    public Admin oauthAuthenticate(String authorization) throws AuthenticationException {
////        if (authorization == null || authorization.isEmpty()) {
////            throw new AuthenticationException("please login first");
////        }
////
////        Admin admin=adminService.getByToken(authorization);
////        if(admin==null){
////            throw new AuthenticationException("please login first");
////        }
////        Date time=new Date();
////        if(admin.getToken_expiration_time()< DateTimeUtility.GetTimeMilliseconds(time)){
////            throw new AuthenticationException("login timeout");
////        }
////        return admin;
////    }
//
//
//}
