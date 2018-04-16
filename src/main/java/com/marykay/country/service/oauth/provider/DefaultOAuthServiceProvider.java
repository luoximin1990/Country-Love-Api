//package com.marykay.country.service.oauth.provider;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.marykay.country.core.auth.oauth.AuthenticationToken;
//import com.marykay.country.core.auth.oauth.OAuthService;
//import com.marykay.country.core.exception.AuthenticationException;
//import com.marykay.country.core.exception.BadCredentialsException;
////import com.marykay.country.love.model.Admin;
////import com.marykay.country.love.service.AdminService;
//import com.marykay.country.love.util.DateTimeUtility;
//
//import java.util.Date;
//
///**
// * Represent oauth api
// * Created by wanwei on 16/9/6.
// */
//@Service
//public class DefaultOAuthServiceProvider implements OAuthService {
//
////    @Autowired
////    AdminService adminService;
//
//    @Override
//    public AuthenticationToken authenticate(String accessToken) throws AuthenticationException {
//        if (accessToken == null || accessToken.isEmpty()) {
//            throw new BadCredentialsException("The access token is missing");
//        }
////        Admin model=adminService.getByToken(accessToken);
////        if(model==null){
////            return null;
////        }
////        long now= DateTimeUtility.GetTimeMilliseconds(new Date());
////        if(model.getToken_expiration_time()<now){
////            return null;
////        }
////        AuthenticationToken token=new AuthenticationToken(model,model.getToken_expiration_time());
////        return token;
//		return null;
//    }
//
//
//}
