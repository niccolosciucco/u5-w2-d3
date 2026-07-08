package niccolosciucco.u5_w2_d3.authors.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorPayload {
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
}