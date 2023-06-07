package com.nakhaei.isolationtransaction.entity;

import com.nakhaei.isolationtransaction.util.RequestStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Table(name = "tbl_request")
@Entity()
@Getter
@Setter
@Accessors(chain = true)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Long amount;
}
