package com.adidas.email.controller;

import com.adidas.email.dto.Email;
import com.adidas.email.service.IEmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Email service", description = "Email service for the subscription system")
@Controller("email")
public class EmailController {

    @Autowired
    private IEmailService emailService;


    @DeleteMapping("/cancel")
    @Operation(summary = "Sends a cancellation email with the email defined in Email DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email sent properly"),
            @ApiResponse(responseCode = "400", description = "Email not sent because of invalid data")
    })
    public ResponseEntity<?> cancellation(@RequestBody
                                          @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Email DTO with email info for email creation")
                                                  Email email) {
        boolean emailSent = emailService.sendCancellationEmail(email);
        return emailSent ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }


    @PostMapping("/create")
    @Operation(summary = "Sends a creation email with the email defined in Email DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email sent properly"),
            @ApiResponse(responseCode = "400", description = "Email not sent because of invalid data")
    })
    public ResponseEntity<?> creation(@RequestBody
                                      @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Email DTO with email info for email creation")
                                              Email email) {
        boolean emailSent = emailService.sendCreationEmail(email);
        return emailSent ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Rula");
    }

}
