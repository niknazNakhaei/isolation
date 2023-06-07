package com.nakhaei.isolationtransaction.service.impl;

import com.nakhaei.isolationtransaction.dto.RequestDto;
import com.nakhaei.isolationtransaction.entity.Request;
import com.nakhaei.isolationtransaction.repository.RequestRepository;
import com.nakhaei.isolationtransaction.service.RequestService;

import com.nakhaei.isolationtransaction.util.RequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository repository;

    @Override
    @Transactional()
    public RequestDto save(RequestDto requestDto) {
        Request entity=mapToEntity(requestDto);
        return mapToDTO(repository.save(entity)) ;
    }


    public void runExecutor(){
        ExecutorService service= Executors.newFixedThreadPool(10);
        List.of(1,2,3,4,5,6).forEach(value-> service.execute(()-> updateMulti(value.longValue())));
    }

    private void updateMulti( Long value){
        System.out.println("run thread "+ value);
        update(new RequestDto().setId(1L).setValue(value));
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public RequestDto update(RequestDto requestDto) {
       return mapToDTO( repository.findById(requestDto.getId()).map(entity -> {
           System.out.println("run thread " + requestDto.getValue() + " value is " + entity.getAmount());
            entity.setAmount(entity.getAmount()+1);
           Request save = repository.save(entity);
           System.out.println("finish thread " + requestDto.getValue() + " value is " + entity.getAmount());
           return save;
       }).orElseThrow(RuntimeException::new));
    }

    private Request mapToEntity(RequestDto requestDto) {
        return new Request().setAmount(requestDto.getValue())
                .setStatus(requestDto.getStatus())
                .setId(requestDto.getId());
    }

    private RequestDto mapToDTO(Request request) {
        return new RequestDto().setValue(request.getAmount())
                .setStatus(request.getStatus())
                .setId(request.getId());
    }
}
