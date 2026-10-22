package aed.utils;

import javax.swing.*;
import java.io.File;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class IOUtils {

    public static File escolherFicheiroAbrir() {
        JDialog dialog = new JDialog();
        JFileChooser chooser = new JFileChooser();
        return chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }

    public static File escolherFicheiroGravar() {
        JDialog dialog = new JDialog();
        JFileChooser chooser = new JFileChooser();
        return chooser.showSaveDialog(dialog) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }
}
