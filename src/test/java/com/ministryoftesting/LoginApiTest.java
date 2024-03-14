package com.ministryoftesting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ministryoftesting.api.TimesheetManagerApplication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TimesheetManagerApplication.class)
@ActiveProfiles("dev")

public class LoginApiTest {
    public LoginApiTest() {
    }

    @Test
    public void testCheckLoginReturnsPositiveResult() {
        AuthPayload authPayload = new AuthPayload(this, "admin@test.com", "password123");
        Response response = (Response)RestAssured.given().body(authPayload).contentType("application/json").post("http://localhost:8080/v1/auth/login", new Object[0]);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    public class AuthPayload {
        @JsonProperty
        private String email;
        @JsonProperty
        private String password;

        public AuthPayload(final LoginApiTest this$0, String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPassword() {
            return this.password;
        }
    }
}

