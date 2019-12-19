package com.example.spring_first.controllers;

import com.example.spring_first.constants.Status;
import com.example.spring_first.models.BaseResponse;
import com.example.spring_first.models.PaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(Status.SUCCESS_STATUS, 1);
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {

        final BaseResponse response;

        if (sharedKey.equalsIgnoreCase(key)) {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            // Process the request
            // ....
            // Return success response to the client.
            response = new BaseResponse(Status.SUCCESS_STATUS, Status.CODE_SUCCESS);
        } else {
            response = new BaseResponse(Status.ERROR_STATUS, Status.AUTH_FAILURE);
        }
        return response;
    }
}