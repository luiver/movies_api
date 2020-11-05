package com.codecool.moviesapi.helper;

import com.codecool.moviesapi.exception.UnprocessableEntityException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateDeserializer extends StdDeserializer<Date> {

    protected DateDeserializer(){
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String text = jsonParser.readValueAs(String.class);
        String pattern = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(text);
            if (text.matches(pattern)) return new Date(utilDate.getTime());
        } catch (ParseException e) {
            //e.printStackTrace();
            throw new UnprocessableEntityException("Wrong Date Format");
        }
        throw new UnprocessableEntityException("Wrong Date Format");
    }
}
