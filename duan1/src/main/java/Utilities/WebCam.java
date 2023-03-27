package Utilities;

import com.github.sarxos.webcam.Webcam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class WebCam extends Thread {

    private volatile Webcam webcam;
    private volatile String result;
    private volatile BufferedImage image;
    private volatile boolean is_running;

    public WebCam() {
        this.webcam = Webcam.getDefault();
        this.result = new String("");
        this.is_running = true;
    }

    public synchronized Optional<BufferedImage> getImage() {
        return Optional.ofNullable(this.image);
    }

    public synchronized String getResult() {
        return this.result;
    }

    @Override
    public void run() {
        while (this.is_running) {
            this.webcam.open();
            this.image = webcam.getImage();
            this.getImage().ifPresentOrElse(
                    (o) -> {
                        this.onRunning(o);
                        System.out.println("running");
                    }, () -> {
                        this.is_running = false;
                        System.out.println("hihihihi");
                    });
        }
    }

    public void onRunning(BufferedImage _img) {
        // override
    }
    
    public void closeWebCam() throws InterruptedException {
        this.is_running = false;
        this.join();
        this.webcam.close();
    }
    
    public void openWebCam() {
        this.start();
    }
}
