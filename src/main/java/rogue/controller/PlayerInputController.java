package rogue.controller;

/**
 * An interface modeling the player's controller.
 */
public interface PlayerInputController {

    /**
     * Notifies the movement change. 
     * @param cmd
     *          the concrete command to be executed
     */
    void notifyCommand(Command cmd); 

}
