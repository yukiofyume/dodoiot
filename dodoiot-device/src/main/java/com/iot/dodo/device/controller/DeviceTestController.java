package com.iot.dodo.device.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceTestController {

    @GetMapping("/test")
    public String test() {
        return "this is device test";
    }
}
