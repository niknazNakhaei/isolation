package com.nakhaei.isolationtransaction.service;

import com.nakhaei.isolationtransaction.dto.RequestDto;

public interface RequestService {
    void runExecutor();
    RequestDto save(RequestDto requestDto);
    RequestDto update(RequestDto requestDto);
}
