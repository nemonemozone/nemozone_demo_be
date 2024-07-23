package Nemozone.Nemozone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController {

    public static Long sumOfClick = 0L;

    @GetMapping("/click")
    public ResponseEntity<?> plusOneAtLogin() {
        sumOfClick++;
        log.info("[sum of clicks]  " + sumOfClick);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sumOfClick);
    }

    @GetMapping("/set-zero")
    public ResponseEntity<?> setZero() {
        sumOfClick = 0L;
        log.info("------ Reset -----");
        log.info("[sum of clicks]  " + sumOfClick);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sumOfClick);
    }
}
