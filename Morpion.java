import java.awt.*;
import javax.swing.*;

public class Morpion {
    public static void main(String[] args) {
        int cellSize = 100;
        var f = new JFrame("Morpion J1");
        var f1 = new JFrame("Morpion J2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocationRelativeTo(null);

        var p = new JPanel(null);
        var p1 = new JPanel(null);
        p.setPreferredSize(new Dimension(cellSize*3,cellSize*3));
        p1.setPreferredSize(new Dimension(cellSize*3,cellSize*3));

        f.setContentPane(p);
        f.pack();

        f1.setContentPane(p1);
        f1.pack();

        var b = new JButton[3][3];
        var j = new int[] { 1 };
        for(int l = 0; l < 3; l++) {
            for(int c = 0; c < 3; c++) {
                b[l][c] = new JButton("-");
                b[l][c].setBounds(l*cellSize, c*cellSize, cellSize, cellSize);
                final var lFinal = l;
                final var cFinal = c;
                b[l][c].addActionListener(e -> {
                    if (b[lFinal][cFinal].getText().equals("-")) {
                        b[lFinal][cFinal].setText(j[0] == 1 ? "X": "O");
                        j[0] = (j[0] == 1) ? 2 : 1;
                    }
                    // Vérifier si gagnant ou fin de partie avec égalité.
                    boolean egalite = true;
                    for (int i = 0; i < 3; i++){
                        for (int k = 0 ; k < 3; k++){
                            if(b[i][k].getText().equals("-")){
                                egalite = false;
                            }
                        }
                    }
                    if(egalite){
                        System.exit(0);
                    }
                });
                p.add(b[l][c]);
            }
        }
        f.pack();
        
        f1.pack();
        f.setVisible(true);
        f1.setVisible(true);
        System.out.println("end of main");
    }
    
}
