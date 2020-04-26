package edu.examples;

public interface House {
    /**
     * @deprecated not used anymore
     */
	@Deprecated
    void open();
    void openFrontDoor();
    void openBackDoor();
}