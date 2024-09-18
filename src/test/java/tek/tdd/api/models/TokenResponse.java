package tek.tdd.api.models;

import java.util.Date;

public class TokenResponse {
    private String fullName;
    private String username;
    private String token;
    private Date tokenExpiration;
    private Date issueAt;
    private AccountType accountType;

    public TokenResponse() {
    }

    public TokenResponse(String fullName, String username, String token, Date tokenExpiration, Date issueAt, AccountType accountType) {
        this.fullName = fullName;
        this.username = username;
        this.token = token;
        this.tokenExpiration = tokenExpiration;
        this.issueAt = issueAt;
        this.accountType = accountType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(Date tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public Date getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(Date issueAt) {
        this.issueAt = issueAt;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
