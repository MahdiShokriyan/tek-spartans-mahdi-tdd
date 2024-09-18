package tek.tdd.api.models;

public enum EndPoints {
    TOKEN("/api/token"),
    GET_ACCOUNT("api/accounts/get-account"),
    GET_ALL_PLAN_CODE("/api/plans/get-all-plan-code"),
    GET_PRIMARY_ACCOUNT("api/accounts/get-primary-account");

    private final String value;
    EndPoints(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
