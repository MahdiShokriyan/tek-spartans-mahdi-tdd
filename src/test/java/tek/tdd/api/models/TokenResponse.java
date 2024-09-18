package tek.tdd.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenResponse {
    private String fullName;
    private String username;
    private String token;
    private Date tokenExpiration;
    private Date issueAt;
    private AccountType accountType;
}
