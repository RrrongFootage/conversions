package com.playsafe.assessement.conversions.model;


import lombok.Getter;
import lombok.Setter;

public class ConversionData {


    @Getter @Setter
    private String convertFrom;
    @Getter @Setter
    private String convertTo;
    @Getter @Setter
    private Double convertValue;
    @Getter @Setter
    private Double convertedValue;
    @Getter @Setter
    private String message;


}
