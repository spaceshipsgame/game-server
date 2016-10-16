package spaceships.gameserver.model;

public class Ship {

    private float maxSpeed;
    private float acceleration;
    private float slowDown;
    private float mobility;

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public float getSlowDown() {
        return slowDown;
    }

    public void setSlowDown(float slowDown) {
        this.slowDown = slowDown;
    }

    public float getMobility() {
        return mobility;
    }

    public void setMobility(float mobility) {
        this.mobility = mobility;
    }
}
