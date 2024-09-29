package pl.kurs.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.kurs.deserializer.CarDeserializer;
import pl.kurs.model.Car;
import pl.kurs.serializer.CarSerializer;

import java.text.SimpleDateFormat;

public enum ObjectMapperHolder {
    INSTANCE;

    private final ObjectMapper objectMapper;

    ObjectMapperHolder() {
        this.objectMapper = create();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static ObjectMapper create() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(SerializationFeature
                .WRITE_DATES_AS_TIMESTAMPS, false);
        om.configure(SerializationFeature
                .WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));


        CarSerializer carSerializer = new CarSerializer(Car.class);
        CarDeserializer carDeserializer = new CarDeserializer(Car.class);
        SimpleModule simpleModule = new SimpleModule("CarSerializerAndDeserializer");
        simpleModule.addSerializer(carSerializer);
        simpleModule.addDeserializer(Car.class, carDeserializer);
        om.registerModule(simpleModule);

        return om;
    }
}
