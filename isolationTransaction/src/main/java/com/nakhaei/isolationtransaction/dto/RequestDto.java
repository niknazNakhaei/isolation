package com.nakhaei.isolationtransaction.dto;

import com.nakhaei.isolationtransaction.util.RequestStatus;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RequestDto {
    private Long id;

    private String status;
    private Long value;
}
