package com.adidas.email.controller;

import com.adidas.email.dto.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("email")
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);

    @PostMapping("/cancel")
    public ResponseEntity<Boolean> cancellation(@RequestBody Email email) {
        LOGGER.info("Sent cancellation email to {}", email.getTo());
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @PostMapping("/create")
    public ResponseEntity<Boolean> creation(@RequestBody Email email) {
        LOGGER.info("Sent creation email to {}", email.getTo());
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
