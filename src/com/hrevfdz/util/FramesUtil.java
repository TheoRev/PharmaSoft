package com.hrevfdz.util;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FramesUtil {

    public static void limpiarCampos(JPanel jp) {
        for (Component component : jp.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JDateChooser) {
                ((JDateChooser) component).setDate(null);
            } else if (component instanceof JSpinner) {
                ((JSpinner) component).setValue(0);
            } else if (component instanceof JCheckBox) {
                ((JCheckBox) component).setSelected(false);
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
    }

    public static void limpiarTabla(JTable table, DefaultTableModel model) {
        for (int i = 0; i < table.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    public static void controlarInstancia(JInternalFrame iframe, JDesktopPane jdp) {
        boolean mostrar = true;
        String nombre = iframe.getTitle();

        for (int j = 0; j < jdp.getComponentCount(); j++) {
            if (iframe.getClass().isInstance(jdp.getComponent(j))) {
                JOptionPane.showMessageDialog(null, "La ventana " + nombre
                        + " que interta abrir ya está abierta, cierre la ventana actual e intente nuevamente", "Ventana ya Instanciada", JOptionPane.WARNING_MESSAGE);
                System.out.println("esta instancia, no se debe mostrar");
                iframe.toFront();
                jdp.moveToFront(iframe);
                mostrar = false;
            } else {
                System.out.println("no lo es, puede mostrarse");
            }
        }

        if (mostrar) {
            jdp.add(iframe);
        }

        iframe.show();
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

    public static double Redondear(double numero) {
        return Math.rint(numero * 100) / 100;
    }

    public static void enablerActionButtons(JButton update, JButton delete, boolean state) {
        update.setEnabled(state);
        delete.setEnabled(state);
    }

    public static void convertToMayucula(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String text = ("" + c).toUpperCase();
            c = text.charAt(0);
            evt.setKeyChar(c);
        }
    }

    public static void onlyDecimalNumber(java.awt.event.KeyEvent evt, JTextField txtComponent) {
        char c = evt.getKeyChar();

        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.' || txtComponent.getText().contains("."))) {
            evt.consume();
        }
    }
}
