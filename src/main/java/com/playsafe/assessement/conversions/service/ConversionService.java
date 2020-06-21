package com.playsafe.assessement.conversions.service;

import com.playsafe.assessement.conversions.model.ConversionData;

public interface ConversionService {

    ConversionData convertDistance(ConversionData conversionData);

    ConversionData convertTemperature(ConversionData conversionData);
}
