package runnerz.run;

import jakarta.validation.constraints.NotEmpty;

public record Run(
        Integer id,
        @NotEmpty
        String name,
        @NotEmpty
        String description
        ) {
}
