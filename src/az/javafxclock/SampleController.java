/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package az.javafxclock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javax.swing.Timer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author AGAYAROV
 */
public class SampleController implements Initializable {
    
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView imgMinute;
    @FXML
    private ImageView imgSecond;
    @FXML
    private ImageView imgHour;
    Timer timer;   
    boolean bul = true;
    boolean bul1 = true;
    boolean bul2 = true;
    boolean bul3 = true;
    boolean bul4 = true;
    int hour = new Date().getHours();
    int minute = new Date().getMinutes();
    int second = new Date().getSeconds();
    double secondAngle = 270 + second * 6;
    double minuteAngle = 270 + minute * 6;
    double hourAngle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageView.setImage(new Image("/az/images/clock1.png"));
        imgHour.setImage(new Image("/az/images/hour.png"));
        imgMinute.setImage(new Image("/az/images/minute.png"));
        imgSecond.setImage(new Image("/az/images/second.png"));
        if (hourAngle > 12) {
            hourAngle = 270 + (hour - 12) * 30;
        } else {
            hourAngle = 270 + hour * 30;
        }
        if (minuteAngle > 330 && minuteAngle <= 390) {
            hourAngle += 0;
        } else if (minuteAngle > 390 && minuteAngle <= 450) {
            hourAngle += 6;
        } else if (minuteAngle > 450 && minuteAngle <= 510) {
            hourAngle += 12;
        } else if (minuteAngle > 510 && minuteAngle <= 570) {
            hourAngle += 18;
        } else if (minuteAngle > 570 && minuteAngle <= 630) {
            hourAngle += 24;
        }

        imgSecond.setRotate(secondAngle);
        imgMinute.setRotate(minuteAngle);
        imgHour.setRotate(hourAngle);



        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imgSecond.setRotate(secondAngle);
                secondAngle += 6;

                if (secondAngle >= 630) {
                    secondAngle = 270;
                    minuteAngle += 6;
                    imgMinute.setRotate(minuteAngle);
                }

                if (minuteAngle > 330 && minuteAngle <= 390 && bul) {
                    hourAngle += 6;
                    bul = false;
                    bul1 = true;
                } else if (minuteAngle > 390 && minuteAngle <= 450 && bul1) {
                    hourAngle += 6;
                    bul1 = false;
                    bul2 = true;
                } else if (minuteAngle > 450 && minuteAngle <= 510 && bul2) {
                    hourAngle += 6;
                    bul2 = false;
                    bul3 = true;
                } else if (minuteAngle > 510 && minuteAngle <= 570 && bul3) {
                    hourAngle += 6;
                    bul3 = false;
                    bul4 = true;
                } else if (minuteAngle > 570 && minuteAngle <= 630 && bul4) {
                    hourAngle += 6;
                    bul4 = false;
                    bul = true;
                }
                if (minuteAngle >= 630) {
                    minuteAngle = 270;
                }
                imgSecond.setRotate(secondAngle);
                imgMinute.setRotate(minuteAngle);
                imgHour.setRotate(hourAngle);

            }
        });
        timer.start();
    }
}
