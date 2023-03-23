/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.*;
import java.awt.geom.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class ClockPanel extends JPanel {

    private final static String[] NUMBERS = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    public ClockPanel() {
        Timer timer = new Timer(1000, event -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        // Chuyển đổi tọa độ để vẽ đồng hồ ở giữa JPanel
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        AffineTransform transform = new AffineTransform();
        transform.translate(centerX, centerY);
        ((Graphics2D) g).setTransform(transform);

        // Vẽ các số trên đồng hồ
        for (int i = 0; i < 12; i++) {
            double angle = i * Math.PI / 6;
            String number = NUMBERS[i];
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D rect = fm.getStringBounds(number, g);
            int x = (int) (75 * Math.cos(angle) - rect.getWidth() / 2);
            int y = (int) (75 * Math.sin(angle) + rect.getHeight() / 2);
            g.drawString(number, x, y);
        }

        // Vẽ kim giờ
        double hourAngle = (hour + minute / 60.0) * Math.PI / 6;
        drawHand(g, hourAngle, 40);

        // Vẽ kim phút
        double minuteAngle = (minute + second / 60.0) * Math.PI / 30;
        drawHand(g, minuteAngle, 50);

        // Vẽ kim giây
        double secondAngle = second * Math.PI / 30;
        drawHand(g, secondAngle, 55);
    }

    private void drawHand(Graphics g, double angle, int length) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.rotate(angle);
        Stroke stroke = new BasicStroke(2);
        g2d.setStroke(stroke);
        g2d.draw(new Line2D.Float(0, 0, length, 0));
        g2d.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDongHo = new javax.swing.JLabel();

        lblDongHo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDongHo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addGap(366, 366, 366))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addGap(247, 247, 247))
        );
    }// </editor-fold>//GEN-END:initComponents
public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ClockPanel());
        frame.pack();
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDongHo;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void run() {
//        while (true) {
//            Calendar cal = Calendar.getInstance();
//            int h = cal.get(Calendar.HOUR); // lay ra gio
//
//            int m = cal.get(Calendar.MINUTE); // lay phut
//
//            int s = cal.get(Calendar.SECOND); // lay giay
//
////            System.out.println(h + ":" + m + ":" + s);
//            lblDongHo.setText(h + ":" + m + ":" + s);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ClockPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
