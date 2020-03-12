package com.example.spring_first.controller.v1;

import com.example.spring_first.constants.Paths;
import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.dto.response.BaseResponse;
import com.example.spring_first.dto.response.PaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Paths.paymentBase)
public class PaymentController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(ResponseStatus.SUCCESS_STATUS, 1);
    }

    @RequestMapping(value = Paths.makePay, method = RequestMethod.GET)
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
        return new BaseResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
    }
}