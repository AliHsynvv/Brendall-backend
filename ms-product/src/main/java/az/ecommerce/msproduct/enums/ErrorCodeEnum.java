package az.ecommerce.msproduct.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    UNKNOWN_ERROR(1000, "Unknown error!"),
    PRODUCT_NOT_FOUND(1001, "Cannot find product with given id!"),
    NOT_ENOUGH_PRODUCT(1002, "Product not found!"),
    NOT_ENOUGH_STORE(1003, "Store not found!"),
    STORE_NOT_FOUND(1004, "Cannot find store with given id!"),
    CATEGORY_NOT_FOUND(1005, "Cannot find category with given id!"),
    NOT_ENOUGH_CATEGORY(1006, "category not found!"),
    COLOUR_NOT_FOUND(1007, "Cannot find colour with given id!"),
    NOT_ENOUGH_COLOUR(1008, "Colour not found!"),
    DISCOUNT_NOT_FOUND(1009, "Cannot find discount with given id!"),
    NOT_ENOUGH_DISCOUNT(1010, "Discount not found!"),
    FEEDBACK_NOT_FOUND(1011, "Cannot find feedback with given id!"),
    NOT_ENOUGH_FEEDBACK(1012, "Feedback not found!"),
    GENDER_NOT_FOUND(1013, "Cannot find gender with given id!"),
    NOT_ENOUGH_GENDER(1014, "Gender not found!"),
    PRICE_NOT_FOUND(1015, "Cannot find price with given id!"),
    NOT_ENOUGH_PRICE(1016, "Price not found!"),
    SIZE_NOT_FOUND(1017, "Cannot find size with given id!"),
    NOT_ENOUGH_SIZE(1018, "Size not found!"),
    LOCATION_NOT_FOUND(1019, "Cannot find location with given id!"),
    NOT_ENOUGH_LOCATION(1020, "Location not found!"),
    INVALID_FILE(1021,"File is invalid!");


    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}