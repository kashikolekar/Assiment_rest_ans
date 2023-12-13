package com.baches.Contoller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assignments_Controller {
	
	@PostMapping("/login")
    public String authenticate(@RequestBody String requestBody) {
      
        JSONObject requestJson = new JSONObject(requestBody);

        
        String loginId = requestJson.getString("login_id");
        String password = requestJson.getString("password");

  
        boolean isAuthenticated = authenticateUser(loginId, password);

        if (isAuthenticated) {
      
            JSONObject responseJson = new JSONObject();
            responseJson.put("token", "your_generated_token");
            return responseJson.toString();
        } else {
            
            return "Authentication failed";
        }
    }
	
	private boolean authenticateUser(String loginId, String password) {
        // Replace this with your actual authentication logic (e.g., check against a database)
        return "test@sunbasedata.com".equals(loginId) && "Test@123".equals(password);
    }


}
