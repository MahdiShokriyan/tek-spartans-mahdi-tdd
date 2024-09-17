package tek.tdd.api.model;

public enum EndPoints {
    TOKEN("/api/token"),
    GET_ACCOUNT("api/accounts/get-account");

    private final String value;
    EndPoints(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
