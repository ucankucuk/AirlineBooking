package com.ucankucuk.AirlineBooking.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FlightQuotaUpdateDto {

    private Long fligtId;
    private Boolean quotaUp;
    private BigDecimal newPrice;
    private BigDecimal oldPrice;
    private Integer oldQuota;
    private Integer newQuota;

}
