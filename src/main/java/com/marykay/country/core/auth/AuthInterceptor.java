//package com.marykay.country.core.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.marykay.country.core.annotation.OAuthSecured;
//import com.marykay.country.core.exception.AuthenticationException;
//import com.marykay.country.core.support.Environment;
////import com.marykay.country.love.model.Admin;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//
///**
// * Created by wanwei on 2016/9/22.
// */
//@Component
//public class AuthInterceptor extends HandlerInterceptorAdapter {
//
//    private static final String HttpHeaderAuthorization = "Authorization";
//    private static final String BEARER = "Bearer";
//
//    @Autowired
//    private Authenticator authenticator;
//
//    private Environment env;
//
//    @Value("${ACCESS_RESTRICT}")
//    public  String accessRestrict;
//
//    private boolean enableOauthValidation;
//
//    /**
//     * Interceptor for authentication
//     * @param env
//     * NOTE: constructor parameter name should be 'env', not be 'environment'
//     * otherwise it'll conflict with spring's environment bean
//     */
//    public AuthInterceptor(Environment env) {
//        this.env = env;
//        String value = this.env.getVariable("EnableOAuthValidation") == null ? "true" : System.getenv("EnableOAuthValidation");
//        enableOauthValidation = Boolean.parseBoolean(value);
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return authHandle(request, response, handler);
//    }
//
//    private boolean authHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//            Class<?> clazz = handlerMethod.getBeanType();
//            Method method = handlerMethod.getMethod();
//            if (clazz == null || method == null)
//                return false;
//
//            // access restrict
//            accessRestrict = accessRestrict == null ? "external" : accessRestrict;
////            String accessRestrict =  accessRestrict;//env.getVariable("ACCESS_RESTRICT");
//
//            String packageName = clazz.getPackage().getName();
//            if (packageName.endsWith(".internal") || packageName.endsWith(".external")) {
//                if (accessRestrict == null || (!accessRestrict.equals("internal") && !accessRestrict.equals("external"))) {
//                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "ACCESS_RESTRICT not set or invalid");
//                    return false;
//                }
//
//                if (!packageName.endsWith("."+accessRestrict)) {
//                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "resource not found");
//                    return false;
//                }
//            }
//
//            OAuthSecured OAuthSecured = null;
//            if (clazz.isAnnotationPresent(OAuthSecured.class)) {
//                OAuthSecured = clazz.getAnnotation(OAuthSecured.class);
//            } else if (method.isAnnotationPresent(OAuthSecured.class)) {
//                OAuthSecured = method.getAnnotation(OAuthSecured.class);
//            }
//
//
//            if (OAuthSecured != null) {
//                if (!enableOauthValidation) {
//                    return true;
//                }
//
//                String authorization = getAuthorization(request);
//
//                try {
////                    Admin admin=authenticator.oauthAuthenticate(authorization);
////                    request.setAttribute("user", admin);
//                	request.setAttribute("user", "");
//                } catch (AuthenticationException e) {
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//                    return false;
//                }
//            }
//
//        }
//
//        return true;
//    }
//
//    private String getAuthorization(HttpServletRequest request) {
//        String authorization = request.getHeader(HttpHeaderAuthorization);
//        if (authorization == null) {
//            authorization = request.getParameter("Authorization");
//            if (authorization == null) return null;
//        }
//
//        authorization = authorization.trim();
//        if (authorization.startsWith(BEARER)) {
//            authorization = authorization.substring(BEARER.length());
//        }
//        return authorization.trim();
//    }
//
//}
