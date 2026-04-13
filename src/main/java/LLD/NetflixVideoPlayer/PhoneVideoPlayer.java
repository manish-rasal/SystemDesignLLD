package main.java.LLD.NetflixVideoPlayer;

public class PhoneVideoPlayer extends VideoPlayer{

    public PhoneVideoPlayer(Device device, Resolution resolution) {
        this.currentDevice = device;
        this.currentResolution = resolution;
    }

    @Override
    void display() {
        getDevice();
        getResolution();
    }
}
