package com.missouristate.arrafi.burgercalories;

public class BurgerCal extends MainActivity {
    //Declearing Final constent for the callorie count!!
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCIUTTO = 115;
    //Declearing fields for constractor class With properties of calories!
    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;
//default constractor class BurgerCal
    public BurgerCal() {
        //Initiating the field by adding value to the constractor field,
        //This sets everything to 0 so we can set the value selected by
        // the user from main activity and assigning to be constracted
        // here to give out the required result
        mPattyCal = 0;
        mCheeseCal = 0;
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }

//Setters and getters
    public void setPattyCalories(int calories){
        //gets assigned from the mainActivity, but the FINAL_CONSTANT
        // Values are declared above under the burerCal class
        mPattyCal = calories;
    }

    public void setCheeseCalories( int calories){
        //gets assigned from the mainActivity, but the FINAL_CONSTANT
        // Values are declared above under the burerCal class
        mCheeseCal = calories;
    }
    public void setProsciuttoCalories (int calories){
        mProsciuttoCal = calories;
    }
    public void setSauceCalories(int calories){
        mSauceCal = calories;
    }

    public int getTotalCalories() {
        // Returns the total calories to displayed in UI:
        return mPattyCal + mCheeseCal + mProsciuttoCal + mSauceCal;
    }




}
