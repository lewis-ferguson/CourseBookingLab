package com.codebase.CourseBooking.types;

public enum Rating {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int rating;

    Rating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }


}
