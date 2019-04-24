package com.qj.springboot.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class LocaleController {

    @Autowired
    LocaleUtils localeUtils;

    @GetMapping("/locale")
    public String locale() {
        String string = localeUtils.get("user.username");
        return string;
    }


}
