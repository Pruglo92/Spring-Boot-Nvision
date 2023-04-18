package com.example.SpringBootNvision.enums;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverterFactory implements
        ConverterFactory<String, Enum> {
    private record StringToEnumConverter<T extends Enum>(Class<T> enumType)
            implements Converter<String, T> {

        public T convert(final String source) {
            return (T) Enum.valueOf(this.enumType, source.trim().toUpperCase());
        }
    }

    @Override
    public <T extends Enum> @NonNull Converter<String, T> getConverter(
            @NonNull Class<T> targetType) {
        return new StringToEnumConverter<>(targetType);
    }
}
