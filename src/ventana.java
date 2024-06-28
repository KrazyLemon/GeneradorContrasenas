import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ventana extends JFrame{
    private JPanel panel1;
    private JTextField pass_output;
    private JCheckBox caps_checkbox;
    private JCheckBox num_checkbox;
    private JCheckBox simb_checkbox;
    private JTextField digitos_input;
    private JButton generar_button;

    public ventana() {

        setTitle("Mi Ventana");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        generar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean s = simb_checkbox.isSelected();
                boolean n = num_checkbox.isSelected();
                boolean m = caps_checkbox.isSelected();
                int lenght = Integer.parseInt(digitos_input.getText().toString());
                if(lenght>=8 && lenght<=16){
                   pass_output.setText(generaContra(s,n,m,lenght));
                }else{
                    JOptionPane.showMessageDialog(null,"Inserte un rango valido 8-16","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    String generaContra(boolean simb, boolean num, boolean caps, int length){
        StringBuilder sb = new StringBuilder();
        if(simb && num && caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(1);
                sb.append(c);
            }
        }
        if(!simb && !num && !caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(2);
                sb.append(c);
            }
        }
        if(simb && !num && !caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(3);
                sb.append(c);
            }
        }
        if(!simb && num && !caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(4);
                sb.append(c);
            }
        }
        if(!simb && !num && caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(5);
                sb.append(c);
            }
        }
        if(simb && num && !caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(6);
                sb.append(c);
            }
        }
        if(!simb && num && caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(7);
                sb.append(c);
            }
        }
        if(simb && !num && caps){
            for(int i = 0;i<=length; i++){
                char c = obtenerDigito(1);
                sb.append(c);
            }
        }

        return sb.toString();
    }

    char obtenerDigito(int a){
       int num;
       num = new Random().nextInt((126 - 33) + 1)+33;
       int a_3[][] = {{48,57},{65,90}};                             //S = 1; N = 0; M = 0; 3
       int a_4[][] = {{33,47},{58,64},{91,96},{123,126},{65,90}};   //S = 0; N = 1; M = 0; 4
       int a_5[][] = {{33,47},{58,64},{91,96},{123,126},{48,57}};   //S = 0; N = 0; M = 1; 5
       int a_6[][] = {{65,90}};                                     //S = 1; N = 1; M = 0; 6
       int a_7[][] = {{33,47},{58,64},{91,96},{123,126}};           //S = 0; N = 1; M = 1; 7
       int a_8[][] = {{48,57}};                                     //S = 1; N = 0; M = 1; 8

       switch (a){
           case 2: //False
                num = new Random().nextInt((122 - 97)+1)+97;
                break;
           case 3: //S = 1; N = 0; M = 0;
               do{
                   num = new Random().nextInt((126 - 33) + 1)+33;
               }while( !isValid(num,a_3 ));
               break;
           case 4: // S = 0; N = 1 ; M = 0;
               do{
                   num = new Random().nextInt((126 - 33) + 1)+33;
               }while( !isValid(num,a_4));
               break;
           case 5: // S = 0; N = 0 ; M = 1;
               do{
                   num = new Random().nextInt((126 - 33) + 1)+33;
               }while( !isValid(num,a_5));
               break;
           case 6: // S = 1; N = 1; M = 0;
               do{
                   num = new Random().nextInt((126 - 33) + 1)+33;
               }while( !isValid(num,a_6));
               break;
           case 7: // S = 0; N = 1 ; M = 1;
               do{
                   num = new Random().nextInt((126 - 33) + 1)+33;
               }while( !isValid(num,a_7));
               break;
           case 8: // S = 1; N = 0; M = 1;
               do{
                   num = new Random().nextInt((126 - 33) + 1)+33;
               }while( !isValid(num,a_8));
               break;
           default:  return (char) num;
       }
       return (char) num;
    }

    boolean isValid(int number, int[][] excludeRanges){
        for(int[] range : excludeRanges ){
            int min = range[0];
            int max = range[1];
            if(number>=min && number<=max){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }
}
