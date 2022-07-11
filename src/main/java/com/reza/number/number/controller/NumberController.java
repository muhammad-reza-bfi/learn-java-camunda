package com.reza.number.number.controller;

import com.reza.number.number.dto.number.request.NumberRequest;
import com.reza.number.number.dto.number.response.NumberResponse;
import com.reza.number.number.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/number")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    NumberResponse CreateNumber(@RequestBody NumberRequest req) {
        return numberService.createNumber(req);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<NumberResponse> GetNumbers() {
        return numberService.getNumbers();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    NumberResponse UpdateNumbers(@RequestBody NumberRequest req, @PathVariable(name="id") UUID id) {
        return numberService.updateNumber(req, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    NumberResponse DeleteNumbers(@PathVariable(name="id") UUID id) {
        return numberService.deleteNumber(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    NumberResponse GetNumber(@PathVariable(name="id") UUID id) {
        // get detail
        return numberService.getNumber(id);
    }


}
