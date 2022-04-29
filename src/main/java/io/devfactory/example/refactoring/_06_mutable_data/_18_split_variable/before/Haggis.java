package io.devfactory.example.refactoring._06_mutable_data._18_split_variable.before;

@SuppressWarnings("ClassCanBeRecord")
public class Haggis {

  private final double primaryForce;
  private final double secondaryForce;
  private final double mass;
  private final int delay;

  public Haggis(double primaryForce, double secondaryForce, double mass, int delay) {
    this.primaryForce = primaryForce;
    this.secondaryForce = secondaryForce;
    this.mass = mass;
    this.delay = delay;
  }

  public double distanceTravelled(int time) {
    double result;
    double acc = primaryForce / mass;
    int primaryTime = Math.min(time, delay);
    result = 0.5 * acc * primaryTime * primaryTime;

    int secondaryTime = time - delay;
    if (secondaryTime > 0) {
      double primaryVelocity = acc * delay;
      acc = (primaryForce + secondaryForce) / mass;
      result += primaryVelocity * secondaryTime + 0.5 * acc * secondaryTime + secondaryTime;
    }

    return result;
  }

}
