package com.cinema.fraud.web.mappers;

import com.cinema.fraud.domain.Fraud;
import com.cinema.fraud.domain.Fraud.FraudBuilder;
import com.cinema.fraud.web.models.FraudDto;
import com.cinema.fraud.web.models.FraudDto.FraudDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T14:40:03+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class FraudMapperImpl_ implements FraudMapper {

    @Override
    public FraudDto fraudToFraudDto(Fraud fraud) {
        if ( fraud == null ) {
            return null;
        }

        FraudDtoBuilder fraudDto = FraudDto.builder();

        fraudDto.id( fraud.getId() );
        fraudDto.lastUpdate( fraud.getLastUpdate() );
        fraudDto.customerId( fraud.getCustomerId() );
        fraudDto.isFraudster( fraud.getIsFraudster() );

        return fraudDto.build();
    }

    @Override
    public Fraud fraudDtoToFraud(FraudDto fraudDto) {
        if ( fraudDto == null ) {
            return null;
        }

        FraudBuilder fraud = Fraud.builder();

        fraud.id( fraudDto.getId() );
        fraud.lastUpdate( fraudDto.getLastUpdate() );
        fraud.customerId( fraudDto.getCustomerId() );
        fraud.isFraudster( fraudDto.getIsFraudster() );

        return fraud.build();
    }
}
