package niccolosciucco.u5_w2_d3.authors.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandlerPayload {
    private LocalDateTime localDateTime;
    private String message;
}
