package com.org.hu.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//@Configuration
//@Component
@Configuration
public class DateConventer {
//    @Override
//    public LocalDate convert(String s) {
//        if(null==s||"".equals(s)){
//            s=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        }
//        try{
//            LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
    @Bean
    public Converter<String, String> StringConvert() {
        return new Converter<String, String>() {
            @Override
            public String convert(String source) {
                return StringUtils.trimToNull(source);
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> LocalDateConvert() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                if (StringUtils.isBlank(source)) {
                    return null;
                }
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

        };
    }

    @Bean
    public Converter<String, LocalDateTime> LocalDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                if (StringUtils.isBlank(source)) {
                    return null;
                }
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

        };
    }
}
