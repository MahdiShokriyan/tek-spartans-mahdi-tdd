package tek.tdd.api.models;

import lombok.Getter;

@Getter
public enum EndPoints {
    TOKEN("/api/token"),
    GET_ACCOUNT("api/accounts/get-account"),
    GET_ALL_PLAN_CODE("/api/plans/get-all-plan-code"),
    GET_PRIMARY_ACCOUNT("api/accounts/get-primary-account"),
    ADD_PRIMARY_ACCOUNT("/api/accounts/add-primary-account"),
    DELETE_ACCOUNT("/api/accounts/delete-account"),
    USER_PROFILE("/api/user/profile");

    private final String value;
    EndPoints(String value){
        this.value = value;
    }

}
