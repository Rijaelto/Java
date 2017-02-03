/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Datos.Diccionario;
import Datos.LibroDeLectura;
import Datos.LibroDeTexto;
import Logica.Kioskero;
import Logica.Kiosko;
import javax.swing.JFrame;

/**
 *
 * @author Ernesto
 */
public class PantallaLibro extends javax.swing.JFrame {

    
    private JFrame principal;
    Kiosko tienda;
    int productoNum;
    String usuario;
    
    /**
     * Creates new form PantallaLectorDeLibro
     */
    public PantallaLibro(JFrame ventana,Kiosko tienda, int productoNum,String usuario) {
        initComponents();
        principal = ventana;
        principal.setVisible(true);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        getContentPane().setBackground(new java.awt.Color(200, 220, 240));
        this.productoNum=productoNum;
        
        
        Kioskero igor = Kioskero.getInstance();
        int tipoDeProducto = igor.determinaElProducto((Kiosko.getProductosDisponibles().get(productoNum)));  
        jLabelNombreUsuario.setText(usuario);
        
        
        
        
        if(tipoDeProducto == 1) {
            jTextFieldISBN.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getISBNString());
        jTextFieldTitulo.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getTitulo());
        jTextFieldAutor.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getAutor());
        jTextFieldEditorial.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getEditorial());
        jTextFieldFecha.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getFechaPublicacionString());
        jTextFieldPrecio.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getPrecioString()+" Euros");
        jTextFieldPrecioConsulta.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getPrecioConsultaString()+" Euros"); 
            jTextFieldNivel.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getNivel());
            jTextFieldMateria.setText(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getMateria());                       
            jTextFieldCurso.setText(Integer.toString(((LibroDeTexto)(Kiosko.getProductosDisponibles().get(productoNum))).getCurso()));
            jTextFieldIdioma.setText("Vacio");        
            jTextFieldCursos.setText("Vacio");        
            jTextFieldGenero.setText("Vacio");
            
        }
        
        if(tipoDeProducto == 3){
            jTextFieldISBN.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getISBNString());
        jTextFieldTitulo.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getTitulo());
        jTextFieldAutor.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getAutor());
        jTextFieldEditorial.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getEditorial());
        jTextFieldFecha.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getFechaPublicacionString());
        jTextFieldPrecio.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getPrecioString()+" Euros");
        jTextFieldPrecioConsulta.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getPrecioConsultaString()+" Euros"); 
            jTextFieldNivel.setText("Vacio");
            jTextFieldMateria.setText("Vacio");                    
            jTextFieldCurso.setText("Vacio");
            jTextFieldIdioma.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getIdioma());        
            /*jTextFieldCursos.setText(((Diccionario)(Kiosko.getProductosDisponibles().get(productoNum))).getCursos());*/        
            jTextFieldGenero.setText("Vacio");
        }if(tipoDeProducto == 2){
            jTextFieldISBN.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getISBNString());
        jTextFieldTitulo.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getTitulo());
        jTextFieldAutor.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getAutor());
        jTextFieldEditorial.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getEditorial());
        jTextFieldFecha.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getFechaPublicacionString());
        jTextFieldPrecio.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getPrecioString()+" Euros");
        jTextFieldPrecioConsulta.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getPrecioConsultaString()+" Euros"); 
            jTextFieldNivel.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getNivel());
            jTextFieldMateria.setText("Vacio");                     
            jTextFieldCurso.setText("Vacio");
            jTextFieldIdioma.setText("Vacio");        
            jTextFieldCursos.setText("Vacio");        
            jTextFieldGenero.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getGenero());
            jTextArea1.setLineWrap(true);
            jTextArea1.setWrapStyleWord(true);
            jTextArea1.setText(((LibroDeLectura)(Kiosko.getProductosDisponibles().get(productoNum))).getResumen());
            /*Resumen*/
        }
              
    
        
      
                        
        
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();
        jTextFieldEditorial = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldPrecioConsulta = new javax.swing.JTextField();
        jTextFieldNivel = new javax.swing.JTextField();
        jTextFieldMateria = new javax.swing.JTextField();
        jTextFieldCurso = new javax.swing.JTextField();
        jTextFieldIdioma = new javax.swing.JTextField();
        jTextFieldCursos = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonAtras = new javax.swing.JButton();
        jButtonComprar = new javax.swing.JButton();
        jToggleComentarios = new javax.swing.JToggleButton();
        jLabel15 = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ISBN");

        jLabel2.setText("TITULO");

        jLabel3.setText("AUTOR");

        jLabel4.setText("EDITORIAL");

        jLabel5.setText("FECHA DE PUBLICACION");

        jLabel6.setText("PRECIO");

        jLabel7.setText("PRECIO CONSULTA ONLINE");

        jLabel8.setText("NIVEL");

        jLabel9.setText("MATERIA");

        jLabel10.setText("CURSO");

        jLabel11.setText("IDIOMA");

        jLabel12.setText("CURSOS RECOMENDADOS");

        jLabel13.setText("GENERO");

        jLabel14.setText("RESUMEN");

        jTextFieldISBN.setEditable(false);
        jTextFieldISBN.setText("jTextField1");

        jTextFieldTitulo.setEditable(false);
        jTextFieldTitulo.setText("jTextField2");

        jTextFieldAutor.setEditable(false);
        jTextFieldAutor.setText("jTextField3");

        jTextFieldEditorial.setEditable(false);
        jTextFieldEditorial.setText("jTextField4");

        jTextFieldFecha.setEditable(false);
        jTextFieldFecha.setText("jTextField5");

        jTextFieldPrecio.setEditable(false);
        jTextFieldPrecio.setText("jTextField6");

        jTextFieldPrecioConsulta.setEditable(false);
        jTextFieldPrecioConsulta.setText("jTextField7");

        jTextFieldNivel.setEditable(false);
        jTextFieldNivel.setText("jTextField8");

        jTextFieldMateria.setEditable(false);
        jTextFieldMateria.setText("jTextField9");

        jTextFieldCurso.setEditable(false);
        jTextFieldCurso.setText("jTextField10");

        jTextFieldIdioma.setEditable(false);
        jTextFieldIdioma.setText("jTextField11");

        jTextFieldCursos.setEditable(false);
        jTextFieldCursos.setText("jTextField12");

        jTextFieldGenero.setEditable(false);
        jTextFieldGenero.setText("jTextField13");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonComprar.setText("Comprar");
        jButtonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprarActionPerformed(evt);
            }
        });

        jToggleComentarios.setSelected(true);
        jToggleComentarios.setText("Comentarios");

        jLabelNombreUsuario.setText("jLabel16");

        jLabel16.setText("Sesión iniciada por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(99, 99, 99)))
                    .addComponent(jLabel12))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldIdioma, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(jTextFieldCurso)
                    .addComponent(jTextFieldMateria)
                    .addComponent(jTextFieldNivel)
                    .addComponent(jTextFieldPrecioConsulta)
                    .addComponent(jTextFieldPrecio)
                    .addComponent(jTextFieldFecha)
                    .addComponent(jTextFieldEditorial)
                    .addComponent(jTextFieldAutor)
                    .addComponent(jTextFieldTitulo)
                    .addComponent(jTextFieldISBN)
                    .addComponent(jTextFieldCursos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldGenero)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAtras))
                            .addComponent(jButtonComprar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleComentarios))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonComprar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAtras)
                            .addComponent(jLabelNombreUsuario))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldPrecioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        principal.setVisible(true);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprarActionPerformed
        
            // TODO add your handling code here:
            PantallaConfirmacion C = new PantallaConfirmacion(this, tienda, productoNum,jLabelNombreUsuario.getText());
        
        
        
        
    }//GEN-LAST:event_jButtonComprarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldCurso;
    private javax.swing.JTextField jTextFieldCursos;
    private javax.swing.JTextField jTextFieldEditorial;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldIdioma;
    private javax.swing.JTextField jTextFieldMateria;
    private javax.swing.JTextField jTextFieldNivel;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldPrecioConsulta;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JToggleButton jToggleComentarios;
    // End of variables declaration//GEN-END:variables
}
