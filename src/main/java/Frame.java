import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JPanel panel;
    public Frame(){
        setTitle("Indirizzo ip");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        //TextField
        Font font = new Font("Times New Roman", Font.PLAIN, 25);
        JTextField primo = new JTextField("192");
        JTextField secondo = new JTextField("168");
        JTextField terzo = new JTextField("1");
        JTextField quarto = new JTextField("24");

        panel.add(primo);
        primo.setBounds(200,50,100,35);
        primo.setFont(font);
        primo.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(secondo);
        secondo.setBounds(primo.getX() + 105,primo.getY(),100,35);
        secondo.setFont(font);
        secondo.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(terzo);
        terzo.setBounds(secondo.getX() + 105,primo.getY(),100,35);
        terzo.setFont(font);
        terzo.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(quarto);
        quarto.setBounds(terzo.getX() + 105,primo.getY(),100,35);
        quarto.setFont(font);
        quarto.setHorizontalAlignment(SwingConstants.CENTER);

        //Label

        JLabel broadcast = new JLabel("Broadcast: ");
        JLabel netId = new JLabel("NetID: ");
        JLabel subnet = new JLabel("SubnetMask: ");
        JLabel gateA = new JLabel("Gateway A: ");
        JLabel gateB = new JLabel("Gateway B: ");
        JLabel classe = new JLabel("Classe: ");

        broadcast.setFont(font);
        broadcast.setBounds(primo.getX(), primo.getY() + 100, 350, 35);
        panel.add(broadcast);

        netId.setFont(font);
        netId.setBounds(primo.getX(), primo.getY() + 150, 350, 35);
        panel.add(netId);

        subnet.setFont(font);
        subnet.setBounds(primo.getX(), primo.getY() + 200, 350, 35);
        panel.add(subnet);

        gateA.setFont(font);
        gateA.setBounds(primo.getX(), primo.getY() + 250, 350, 35);
        panel.add(gateA);

        gateB.setFont(font);
        gateB.setBounds(primo.getX(), primo.getY() + 300, 350, 35);
        panel.add(gateB);

        classe.setFont(font);
        classe.setBounds(primo.getX(), primo.getY() + 350, 350, 35);
        panel.add(classe);


        //Button

        JButton bottoneBroad = new JButton("Calcola");
        bottoneBroad.setBounds(189, 460, 450,45);
        bottoneBroad.setFont(font);
        panel.add(bottoneBroad);

        bottoneBroad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primo.getText().equals("")|| secondo.getText().equals("") || terzo.getText().equals("") || quarto.getText().equals("")){
                    return;
                }

                try {
                    Integer.parseInt(primo.getText());
                    Integer.parseInt(secondo.getText());
                    Integer.parseInt(terzo.getText());
                    Integer.parseInt(quarto.getText());

                }catch (NumberFormatException ee){
                    //ee.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Non sono consentite lettere", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                IndirizzoIp indirizzoIp = new IndirizzoIp(Integer.parseInt(primo.getText()),
                                                          Integer.parseInt(secondo.getText()),
                                                          Integer.parseInt(terzo.getText()),
                                                          Integer.parseInt(quarto.getText()));


                indirizzoIp.generaNetID();
                indirizzoIp.generaBroadcast();
                indirizzoIp.generaGateway();
                indirizzoIp.generaSubnetMask();
                indirizzoIp.generaClasse();

                broadcast.setText("BroadCast: " + indirizzoIp.getBroadcast());
                netId.setText("NetId: " + indirizzoIp.getNetID());
                gateA.setText("Gateway A: " + indirizzoIp.getGatewayA());
                gateB.setText("Gateway B: " + indirizzoIp.getGatewayB());
                subnet.setText("SubnetMask: " + indirizzoIp.getSubnetMask());
                classe.setText("Classe: " + indirizzoIp.getClasse());


            }
        });


        add(panel);
        setVisible(true);
    }

}
