package niccolosciucco.u5_w2_d3.blogs.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@NoArgsConstructor
@Getter
public class BlogPayload {
    private String category;
    private String title;
    private String plot;
    private int readingTime;
    private UUID authorId;
}
