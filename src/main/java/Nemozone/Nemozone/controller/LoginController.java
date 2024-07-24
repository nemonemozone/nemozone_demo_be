package Nemozone.Nemozone.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class LoginController {

    public static List<String> clickIpList = new ArrayList<>();

    @GetMapping("/click")
    public ResponseEntity<?> plusOneAtLogin(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) ip = request.getRemoteAddr();

        if (!clickIpList.contains(ip)) {
            clickIpList.add(ip);
            log.info("[click ip]  " + ip);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/click-ip-list")
    public ResponseEntity<?> getClickIpList() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clickIpList);
    }
}
