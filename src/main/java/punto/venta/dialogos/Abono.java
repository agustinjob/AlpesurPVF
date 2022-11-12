/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dialogos;

import javax.swing.ImageIcon;
import punto.servicio.rest.ApiSend;
import punto.venta.cliente.ClienteEstadoInformacion;

import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Cliente;
import punto.venta.modelo.Credito;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class Abono extends javax.swing.JFrame {

 
    Confirmacion confir;
    float resto;
    Integer idTicket;
    String fecha;
    ClienteEstadoInformacion cEI;
    Cliente cli;
    ApiSend api = new ApiSend();
    public Abono(Integer idTicket,String fecha, float resto, ClienteEstadoInformacion cEI, Cliente cli) {
        initComponents();
        setLocationRelativeTo(null);
      //  setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE); 
        ImageIcon mone = new ImageIcon("iconos/oro.png");
        Utilidades.im("RESTOO " + resto);
     
        monedas.setIcon(mone);
        this.resto = resto;
        this.cEI=cEI;
        this.cli = cli;
        this.fecha=fecha;
        this.idTicket=idTicket;
        txtAbono.setText(resto+"");
            ImageIcon logo = new ImageIcon("iconos/lavicentina.jpg");
        this.setIconImage(logo.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        monedas = new javax.swing.JLabel();
        lblAbonar = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        btnrealizaAbono = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(364, 51));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Abonar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(monedas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(monedas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblAbonar.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblAbonar.setText("¿Cuánto deseas abonar?");

        btnrealizaAbono.setBackground(new java.awt.Color(255, 204, 204));
        btnrealizaAbono.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnrealizaAbono.setText("Abonar");
        btnrealizaAbono.setPreferredSize(new java.awt.Dimension(79, 35));
        btnrealizaAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizaAbonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblAbonar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnrealizaAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnrealizaAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrealizaAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizaAbonoActionPerformed
    
        try{    
       float abo = Float.parseFloat(txtAbono.getText());
       if(resto<abo){
           Utilidades.mensajePorTiempo("El abono no puede ser mayor a la deuda del ticket");
       }else{
       
       boolean finalizado=false;
       
       if(resto==abo){
       finalizado = true;
       }
       Credito obcre= new Credito();
       obcre.setAbonado(abo);
       obcre.setFinalizado(finalizado);
       obcre.setIdCliente(cli.getIdCliente());
       obcre.setIdCredito(0);
       obcre.setMonto(resto);
       obcre.setIdTicket(idTicket);
       String f[]=Utilidades.getFechaDivididaString(this.fecha);
       ResponseGeneral res=api.usarAPI(EnviromentLocal.urlG+"creditos/"+f[0]+"%20"+f[1], obcre, "POST");
       Utilidades.mensajePorTiempo(res.getMensaje());
       cEI.llenarDatos(cli);
       
       this.dispose();}
    }catch(NumberFormatException e){
           
        Utilidades.mensajePorTiempo("Por favor ingresa un valor valido");
    }
    }//GEN-LAST:event_btnrealizaAbonoActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrealizaAbono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAbonar;
    private javax.swing.JLabel monedas;
    private javax.swing.JTextField txtAbono;
    // End of variables declaration//GEN-END:variables
}
