package com.hrevfdz.util;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
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
            } else if (jp.getComponents()[i] instanceof JCheckBox) {
                ((JCheckBox) jp.getComponents()[i]).setSelected(false);
            } else if (jp.getComponents()[i] instanceof JComboBox) {
                ((JComboBox) jp.getComponents()[i]).setSelectedIndex(0);
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
}
