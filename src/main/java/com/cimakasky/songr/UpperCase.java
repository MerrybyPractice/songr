package com.cimakasky.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/capitalize")
public class UpperCase {

    @GetMapping("/{willBeCapitalized}")
    @ResponseBody
    public String toUpperCase(@PathVariable String willBeCapitalized){
        return willBeCapitalized.toUpperCase();
    }
}
