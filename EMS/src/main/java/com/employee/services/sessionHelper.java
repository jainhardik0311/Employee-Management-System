package com.employee.services;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class sessionHelper {
    public void removeMessageFromSession(){
        try{
            System.out.println("Removing message from session");
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("msg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
