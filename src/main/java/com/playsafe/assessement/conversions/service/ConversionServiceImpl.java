package com.playsafe.assessement.conversions.service;

import com.playsafe.assessement.conversions.model.ConversionData;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static Double DISTANCE_RATIO = 0.621371;
    private static Double TEMPERATURE_FACTOR = 273.15;

    @Override
    public ConversionData convertDistance(ConversionData conversionData) {
        if(conversionData.getConvertFrom().equalsIgnoreCase("KM")){
            conversionData.setConvertedValue(DISTANCE_RATIO * conversionData.getConvertValue());
        }else if(conversionData.getConvertFrom().equalsIgnoreCase("MI")){
            conversionData.setConvertedValue(conversionData.getConvertValue() / DISTANCE_RATIO);
        }

        return conversionData;
    }

    @Override
    public ConversionData convertTemperature(ConversionData conversionData) {
        if(conversionData.getConvertTo().equalsIgnoreCase("CELCIUS")){
            conversionData.setConvertedValue(conversionData.getConvertValue() - TEMPERATURE_FACTOR);
        }else if(conversionData.getConvertTo().equalsIgnoreCase("KELVIN")){
            conversionData.setConvertedValue(conversionData.getConvertValue() + TEMPERATURE_FACTOR);
        }
        return conversionData;
    }
}
