package view;

import controller.ControladorRequerimientosReto4;
import model.vo.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    public JTextArea textArea;
    public JPanel panel;
    public JLabel label;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        panel = new JPanel();
        label = new JLabel("Misión TIC UTP");
        panel.add(label);
        setContentPane(panel);
        
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        textArea = new JTextArea(30, 30);
        textArea.setForeground(Color.BLUE);
        scrollPane.setViewportView(textArea);

        JButton boton1 = new JButton("Consulta 1");
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                consulta1();;
            }
        });
        panel.add(boton1);

        JButton boton2 = new JButton("Consulta 2");
        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                consulta2();;
            }
        });
        panel.add(boton2);

        JButton boton3 = new JButton("Consulta 3");
        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                consulta3();
            }
        });
        panel.add(boton3);

    }

    public void consulta1(){
        try{

            ArrayList<Consulta1VO_19> lista1 = controlador.consultarConsulta1();
            String salida = "-------Consulta1------\n\nID_Proyecto\tFecha_Inicio\tConstructora\t\tSerial\n\n";
            for(Consulta1VO_19 req : lista1){
                salida += req.getID_Proyecto();
                salida += "\t";
                salida += req.getFecha_inicio();
                salida += "\t";
                salida += req.getConstructora();
                salida += "\t";
                salida += req.getSerial();
                salida += "\n";
            }
            
            textArea.setText(salida);
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }

    public void consulta2(){
        try{

            ArrayList<Consulta2VO_19> lista2 = controlador.consultarConsulta2();
            String salida = "-------Consulta2------\n\nID_Proyecto\tArea_Max\n\n";
            for(Consulta2VO_19 req2 : lista2){ 
                salida += req2.getID_Proyecto();
                salida += "\t";
                salida += req2.getArea_Max();
                salida += "\n";
            }
            textArea.setText(salida);
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }


    public void consulta3(){
        try{

            ArrayList<Consulta3VO_19> lista3 = controlador.consultarConsulta3();
            String salida = "-------Consulta3------\n\nID_Proyecto\tNombreApellido\n\n";

            for(Consulta3VO_19 req3 : lista3){
                salida += req3.getiD_Proyecto();
                salida += "\t";
                salida += req3.getNombreapellido();
                salida += "\n";
                
            }
            textArea.setText(salida);
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }
}

