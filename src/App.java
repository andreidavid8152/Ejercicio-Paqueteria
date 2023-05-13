import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class App extends JFrame {
    private JPanel trackingPanel;
    private JTabbedPane tabbedPane1;
    private JTextField fieldCalleR;
    private JTextField fieldCiudadR;
    private JTextField fieldEstadoR;
    private JTextField fieldCPR;
    private JTextField fieldCalleD;
    private JTextField fieldCiudadD;
    private JTextField fieldEstadoD;
    private JTextField fieldCPD;
    private JButton crear;
    private JTextField fieldAnio;
    private JTextField fieldMes;
    private JTextField fieldDia;
    private JTextField textRPaquete;
    private JButton removerPaqueteButton;
    private JButton mostrarPaquetesButton;
    private JTextArea textArea1;
    private JButton crearDatosQuemadosButton;
    private JTextArea textArea2;
    private JTabbedPane tabbedPane2;
    private JTextField fCalle;
    private JButton buscarButton;
    private JTextArea textArea3;
    private JTextField fCiudad;
    private JTextField fEstado;
    private JTextField fCPostal;
    private JTextField fPaquete;
    private JButton buscarNumero;
    private JTextArea textArea4;
    private JTabbedPane tabbedPane3;
    private JTextField textFieldCiudad;
    private JButton buscarCiudad;
    private JTextArea textArea5;
    private JTextField estadoCED;
    private JTextArea textArea6;
    private JButton bEstadoCED;
    private JTextField cpCED;
    private JButton buscarCP;
    private JTextArea textArea7;
    private JButton buscarCED;

    TrackingSystem t = new TrackingSystem();

    public App() {
        setContentPane(trackingPanel);

        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPaquete();
            }
        });
        removerPaqueteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPaquete();
            }
        });
        mostrarPaquetesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPaquetes();
            }
        });
        crearDatosQuemadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datosQuemados();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaDireccionDestinatario();
            }
        });
        buscarNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaNumSeguimiento();
            }
        });
        buscarCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaCiudad();
            }
        });
        bEstadoCED.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaEstado();
            }
        });
        buscarCP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaCP();
            }
        });
    }

    private void crearPaquete(){
        Address dRemitente = new Address(fieldCalleR.getText(), fieldCiudadR.getText(), fieldEstadoR.getText(), fieldCPR.getText());
        Address dDestinatario = new Address(fieldCalleD.getText(), fieldCiudadD.getText(), fieldEstadoD.getText(), fieldCPD.getText());
        Package p = new Package(t.getnPackage()+1, dRemitente, dDestinatario, Integer.parseInt(fieldAnio.getText()), Integer.parseInt(fieldMes.getText()), Integer.parseInt(fieldDia.getText()));
        t.addPackage(p);
        JOptionPane.showMessageDialog(null, "El paquete " + p.getTrackingNumber() + " se ha creado exitosamente");
    }

    private void eliminarPaquete(){
        if(t.removePackage(textRPaquete.getText())){
            JOptionPane.showMessageDialog(null, "El paquete " + textRPaquete.getText() + " se ha eliminado exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error. No existe el paquete " + textRPaquete.getText());
        }
    }
    private void mostrarPaquetes(){
        String text = "";
        if(t.getPackages().size() > 0){
            for(int i = 0; i < t.getPackages().size(); i++){
                text += t.getPackages().get(i).toString();
            }
            textArea1.setText(text);
        }else{
            textArea1.setText("No hay paquetes en el sistema.");
        }
    }

    private void datosQuemados(){
        String text = "";

        //Paquetes predeterminados
        Package p1 = new Package(t.getnPackage()+1, new Address("Bellavista", "Quito", "Pichincha", "1701"),
                new Address("Kenedy", "Quito", "Pichincha", "1703"), 2023, 12, 25);
        t.addPackage(p1);

        Package p2 = new Package(t.getnPackage()+1, new Address("Jose aguas", "Quito", "Pichincha", "1709"),
                new Address("Jose calama", "Guayaquil", "Guayas", "1603"), 2023, 11, 25);
        t.addPackage(p2);

        Package p3 = new Package(t.getnPackage()+1, new Address("Real audiencia", "Quito", "Pichincha", "1510"),
                new Address("6 de diciembre", "Quito", "Pichincha", "1613"), 2023, 10, 25);
        t.addPackage(p3);

        Package p4 = new Package(t.getnPackage()+1, new Address("Granados", "Quito", "Pichincha", "2709"),
                new Address("De los colimes", "Quito", "Pichincha", "3603"), 2023, 12, 15);
        t.addPackage(p4);

        Package p5 = new Package(t.getnPackage()+1, new Address("El inca", "Quito", "Pichincha", "2409"),
                new Address("La prensa", "Quito", "Pichincha", "3603"), 2023, 9, 24);
        t.addPackage(p5);

        Package p6 = new Package(t.getnPackage()+1, new Address("Roldos", "Quito", "Pichincha", "2119"),
                new Address("Portugal", "Manta", "Pichincha", "9621"), 2023, 9, 24);
        t.addPackage(p6);

        text += "Los datos quemados son: \n\n" + p1.toString() + p2.toString() + p3.toString() + p4.toString() + p5.toString() + p6.toString();

        textArea2.setText(text);

        JOptionPane.showMessageDialog(null, "Se han quemado los datos correctamente.");

    }

    private void busquedaDireccionDestinatario(){
        Package p = t.searchByRecipientAddress(fCalle.getText(), fCiudad.getText(), fEstado.getText(), fCPostal.getText());
        if(p != null){
            textArea3.setText(p.toString());
        }else{
            textArea3.setText("No se ha encontrado ningun paquete con esa direccion.");
        }
    }

    private void busquedaNumSeguimiento(){
        Package p = t.searchByTrackingNumberBinary(fPaquete.getText());
        if(p != null){
            textArea4.setText(p.toString());
        }else{
            textArea4.setText("No se ha encontrado ningun paquete con ese numero de seguimiento.");
        }
    }

    private void busquedaCiudad(){
        List<Package> paquetesCiudad = t.searchByCity(textFieldCiudad.getText());
        if(paquetesCiudad.size() > 0){
            textArea5.setText(paquetesCiudad.toString());
        }else{
            textArea5.setText("No se ha encontrado ningun paquete para la ciudad.");

        }
    }

    private void busquedaEstado(){
        List<Package> paquetesEstado = t.searchByState(estadoCED.getText());
        if(paquetesEstado.size() > 0){
            textArea6.setText(paquetesEstado.toString());
        }else{
            textArea6.setText("No se ha encontrado ningun paquete para el estado.");

        }
    }

    private void busquedaCP(){
        List<Package> paquetesCP = t.searchByCP(cpCED.getText());
        if(paquetesCP.size() > 0){
            textArea7.setText(paquetesCP.toString());
        }else{
            textArea7.setText("No se ha encontrado ningun paquete para el codigo postal.");

        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
