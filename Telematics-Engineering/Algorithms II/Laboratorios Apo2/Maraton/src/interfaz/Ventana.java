/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mundo.MaratonAPO1;
import visualkey.KFrame;

/**
 *
 * @author camilo
 */
public class Ventana extends KFrame implements ActionListener {
    
    private MaratonAPO1 maraton;
    private JTextArea input, output;
    private JTextField time;
    private JButton problemA, problemB, problemC, problemD, problemE, example;
    
    private final int A = 0;
    private final int B = 1;
    private final int C = 2;
    private final int D = 4;
    private final int E = 8;
    private final int X = 16;
    
    public Ventana() {
        super(750, 400);
        
        this.maraton = new MaratonAPO1();
        
        this.addLabel("Input", 0, 0, 1, 1, 1, 1, 1, true);
        this.addLabel("Output", 0, 1, 1, 1, 1, 1, 1, true);
        
        input = new JTextArea();
        JScrollPane scroll1 = new JScrollPane(input);
        scroll1.setPreferredSize(new Dimension(300,350));
        this.addComponent(scroll1, 1, 0, 1, 7);
        
        output = new JTextArea();
        JScrollPane scroll2 = new JScrollPane(output);
        scroll2.setPreferredSize(new Dimension(300,350));
        this.addComponent(scroll2, 1, 1, 1, 7);
        
        this.addLabel("Time limit (seconds)", 0, 2, 1, 1, 1, 1, 1, true);
        
        time = new JTextField("3");
        time.setPreferredSize(new Dimension(50, 30));
        this.addComponent(time, 1, 2, 1, 1);
        
        problemA = new JButton("Problem A");
        problemA.setActionCommand(""+A);
        problemA.addActionListener(this);
        this.addComponent(problemA, 2, 2, 1, 1);
        
        problemB = new JButton("Problem B");
        problemB.setActionCommand(""+B);
        problemB.addActionListener(this);
        this.addComponent(problemB, 3, 2, 1, 1);
        
        problemC = new JButton("Problem C");
        problemC.setActionCommand(""+C);
        problemC.addActionListener(this);
        this.addComponent(problemC, 4, 2, 1, 1);
        
        problemD = new JButton("Problem D");
        problemD.setActionCommand(""+D);
        problemD.addActionListener(this);
        this.addComponent(problemD, 5, 2, 1, 1);
        
        problemE = new JButton("Problem E");
        problemE.setActionCommand(""+E);
        problemE.addActionListener(this);
        this.addComponent(problemE, 6, 2, 1, 1);
        
        example = new JButton("Example");
        example.setActionCommand(""+X);
        example.addActionListener(this);
        this.addComponent(example, 7, 2, 1, 1);
        
        
    }
    
    public static void main(String args[]) {
        Ventana v = new Ventana();
        v.setVisible(true);
        v.setDefaultCloseOperation(v.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        long start_time = System.currentTimeMillis();
        
        maraton.startSolving(input.getText());
        
        try {
        switch(Integer.valueOf(e.getActionCommand())) {
            case A:
                maraton.resolverProblemaA();
                break;
            case B:
                maraton.resolverProblemaB();
                break;
            case C:
                maraton.resolverProblemaC();
                break;
            case D:
                maraton.resolverProblemaD();
                break;
            case E:
                maraton.resolverProblemaE();
                break;
            case X:
                maraton.resolverEjemplo();
                break;
        }
        } catch(Exception exception) {
            this.showMessage("Error en tiempo de ejecucion.");
            return;
        }
        
        String answer = maraton.getOutput();
        
        try {
            if((System.currentTimeMillis()-start_time) > Integer.valueOf(time.getText())*1000) {
                this.showMessage("Tiempo Limite");
            } else {
                if(answer.equals(output.getText())) {
                    this.showMessage("SI");
                } else {
                    output.setText("Respuesta incorrecta, tu respuesta fue:\n"+answer);
                    this.showMessage("NO");
                }
            }
        } catch(NumberFormatException nfe) {
            this.showMessage("Use unicamente valores numericos en el campo 'Tiempo limite'.");
        } catch(NullPointerException npe) {
            this.showMessage("Su programa esta vacio.");
        }
        
        
    }
    
}
