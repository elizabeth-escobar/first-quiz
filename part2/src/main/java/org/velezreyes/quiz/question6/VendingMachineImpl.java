package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  private int quartersInserted;
  private boolean drinkDispensed;

  private static VendingMachineImpl instance;

  private VendingMachineImpl() {
    this.quartersInserted = 0;
    this.drinkDispensed = false;
  }

  public static VendingMachine getInstance() {
    // Fix me!
  if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  public void insertQuarter() {
    quartersInserted++;
  }

    public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (name.equals("ScottCola")) {
      if (quartersInserted >= 3) {
        quartersInserted -= 3;
        drinkDispensed = true;
        return new ScottCola();
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if (name.equals("KarenTea")) {
      if (quartersInserted >= 4) {
        quartersInserted -= 4;
        drinkDispensed = true;
        return new KarenTea();
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      throw new UnknownDrinkException();
    }
  }

  public boolean isDrinkDispensed() {
    return drinkDispensed;
  }

  public void reset() {
    quartersInserted = 0;
    drinkDispensed = false;
  }
}
