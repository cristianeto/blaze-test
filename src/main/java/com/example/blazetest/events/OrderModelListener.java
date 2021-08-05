package com.example.blazetest.events;

import com.example.blazetest.models.Order;
import com.example.blazetest.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderModelListener extends AbstractMongoEventListener<Order> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public OrderModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Order> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
        }
    }
}

