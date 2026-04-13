package main.java.LLD.NetflixVideoPlayer;

public class VideoPlayerMain {
    public static void main(String[] args) {
        Resolution resol = new Resol480p();
        Device device = new TV();
        VideoPlayer videoPlayer = new TVVideoPlayer(device, resol);
        videoPlayer.display();
    }
}
