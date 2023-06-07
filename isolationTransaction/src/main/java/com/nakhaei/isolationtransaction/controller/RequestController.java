package com.nakhaei.isolationtransaction.controller;

import com.nakhaei.isolationtransaction.dto.RequestDto;
import com.nakhaei.isolationtransaction.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/request")
public class RequestController {
    private final RequestService requestService;

    @PostMapping(value = "/save")
    public RequestDto save(@RequestBody RequestDto requestDto){
        return requestService.save(requestDto);
    }

    @PutMapping(value = "/update")
    public RequestDto update(@RequestBody RequestDto requestDto){
        return requestService.update(requestDto);
    }

    @PutMapping(value = "/run")
    public void runExecutor(){
        requestService.runExecutor();
    }
}
