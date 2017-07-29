package com.hrevfdz.util;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author lheo
 */
public class FramesUtil {

    public static void limpiarCampos(JPanel jp) {
        for (int i = 0; i < jp.getComponents().length; i++) {
            if (jp.getComponents()[i] instanceof JTextField) {
                ((JTextField) jp.getComponents()[i]).setText("");
            } else if (jp.getComponents()[i] instanceof JDateChooser) {
                ((JDateChooser) jp.getComponents()[i]).setDate(null);
            } else if (jp.getComponents()[i] instanceof JSpinner) {
                ((JSpinner) jp.getComponents()[i]).setValue(0);
            }
        }
    }

    public static boolean verificarCampos(JPanel jp) {
        boolean rpt = false;

        for (int i = 0; i < jp.getComponents().length; i++) {
            if (jp.getComponents()[i] instanceof JTextField) {
                if (((JTextField) jp.getComponents()[i]).getText().equals("")) {
                    return true;
                }

            } else if (jp.getComponents()[i] instanceof JDateChooser) {
                if (((JDateChooser) jp.getComponents()[i]).getDate() == null) {
                    return true;
                }
            }
//            else if (jp.getComponents()[i] instanceof JSpinner) {
//                rpt = ((JSpinner) jp.getComponents()[i]).getValue().equals("0");
//            }
        }
        return rpt;
    }

    public static void setPosition(JDesktopPane jdp, JInternalFrame iframe) {
        Dimension dimDesk = jdp.getSize();
        Dimension dimFrame = iframe.size();
        iframe.setLocation((dimDesk.width - dimFrame.getSize().width) / 2, (dimDesk.height - dimFrame.getSize().height) / 2);
    }

    public static void setIcon(JFrame frame) {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/icons/PharmaSoft_Icon.png")));
    }
}
