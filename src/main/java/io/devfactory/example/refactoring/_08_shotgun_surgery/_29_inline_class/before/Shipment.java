package io.devfactory.example.refactoring._08_shotgun_surgery._29_inline_class.before;

public class Shipment {

  private TrackingInformation trackingInformation;

  public Shipment(TrackingInformation trackingInformation) {
    this.trackingInformation = trackingInformation;
  }

  public TrackingInformation getTrackingInformation() {
    return trackingInformation;
  }

  public void setTrackingInformation(TrackingInformation trackingInformation) {
    this.trackingInformation = trackingInformation;
  }

  public String getTrackingInfo() {
    return this.trackingInformation.display();
  }

}
