package com.developer.java.fundamentals.variables.datatypes.enums;

/**
 * Enum advantages: - makes the code more readable - allow for compile-time checking - document
 * the list of accepted values upfront - avoid unexpected behavior due to invalid values being
 * passed in - Comes with many useful methods that we would otherwise need to write if we were
 * using traditional public static final constants
 */
public enum StoryStatus {
    BACKLOG("Backlog", "Has not yet been selected for development"),
    TODO(
            "Todo",
            "Has been selected for the current sprint during the Sprint Planning meeting but work has not yet started on it"),
    IN_PROGRESS("In Progress", "The team is actively working on it"),
    IN_REVIEW(
            "In Review",
            "Completed from a development perspective but is under review (e.g., code review, QA testing) to ensure it meets the acceptance criteria."),
    DONE(
            "Done",
            "Fully completed, meets the definition of done, and is accepted by the Product Owner");

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    private final String name;
    private final String description;

    StoryStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Defining some extra API methods
    private static StoryStatus getStatusByOrdinal(int ordinal) {
        StoryStatus[] statuses = StoryStatus.values(); // Store the values once

        if (ordinal < 0) {
            return statuses[0]; // Return the first element directly
        }

        if (ordinal >= statuses.length) {
            return statuses[statuses.length - 1]; // Return the last element directly
        }

        return statuses[ordinal]; // Return the element at the specified ordinal
    }

    // Defining some extra API methods
    public static StoryStatus getNextState(
            StoryStatus currentState, boolean isCompletedSuccessfully) {
        return isCompletedSuccessfully
                ? getStatusByOrdinal(currentState.ordinal() + 1)
                : getStatusByOrdinal(currentState.ordinal() - 1);
    }
}
