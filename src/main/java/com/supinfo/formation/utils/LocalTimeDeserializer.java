package com.supinfo.formation.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class LocalTimeDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat format = new SimpleDateFormat("hh:mm");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String time = jsonParser.getText();

        try {
            return format.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
