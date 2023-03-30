package Utilities;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.NotFoundException;
import java.awt.image.BufferedImage;
import java.util.Optional;

public abstract class WebCam extends Thread {

    private volatile Webcam webcam;
    private volatile String result;
    private volatile BufferedImage image;
    private volatile QrCode qr_code;
    private volatile boolean is_running;

    public WebCam() {
        this.qr_code = new QrCode();
        this.webcam = Webcam.getDefault();
        this.result = new String("");
        this.is_running = true;
    }

    public synchronized Optional<BufferedImage> getImage() {
        return Optional.ofNullable(this.image);
    }

    @Override
    public void run() {
        while (this.is_running) {
            this.webcam.open();
            this.image = webcam.getImage();
            this.getImage().ifPresentOrElse(
                    (o) -> {
                        this.onRunning(o);
                        try {
                            result = this.qr_code.ReadQR(image);
                            if (!result.isEmpty()) {
                                this.onQrPassed(this.qr_code.ReadQR(image));
                            }
                        } catch (NotFoundException ex) {
                            System.out.println("QR not found");
                        }
                        System.out.println("running");
                    }, () -> {
                        this.is_running = false;
                        System.out.println("thread finish");
                    });
        }
    }

    public abstract void onRunning(BufferedImage _img);

    public abstract void onQrPassed(String _result);

    public void closeWebCam() throws InterruptedException {
        this.is_running = false;
        this.join();
        this.webcam.close();
    }

    public void openWebCam() {
        this.start();
    }
}
