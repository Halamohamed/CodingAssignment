package se.ecutb.service;

import org.springframework.stereotype.Component;
import se.ecutb.dto.TodoDto;
import se.ecutb.model.Todo;
@Component
public class TodoDtoConversionServiceImpl implements TodoDtoConversionService {
    @Override
    public TodoDto convertToDto(Todo todo) {
        return null;
    }
}
