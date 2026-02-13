package ru.diasoft.ncheranev.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Класс Task3Dot8Application")
class Task3Dot8ApplicationTest {

    @Test
    @DisplayName("main() должен выполниться без ошибок")
    void shouldRunWithoutException() {
        assertThatCode(() -> Task3Dot8Application.main(new String[] {"arg"}))
                .doesNotThrowAnyException();
    }
}