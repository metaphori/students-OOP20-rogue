package rogue.controller;

public interface InventoryController {

    boolean onPrimaryClick(int col, int row);

    boolean onSecondaryClick(int col, int row);

    boolean onMiddleClick(int col, int row, int swapping);

}
