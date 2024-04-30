package org.akavity.models.registrationTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegUserData {
    String email;
    String password;
    String pasName;
    String emailName;
}
