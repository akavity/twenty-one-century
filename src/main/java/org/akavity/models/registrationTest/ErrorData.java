package org.akavity.models.registrationTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorData {
    String email;
    String error;
    String name;
}
