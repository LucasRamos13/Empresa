/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoEmpresa;
import javax.swing.JOptionPane;
import modelo.Empresa;
import tela.manutencao.ManutencaoEmpresa;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorEmpresa {
    public static void inserir(ManutencaoEmpresa man){
        Empresa objeto = new Empresa();
        objeto.setRazaosocial(man.jtfRazaosocial.getText());
        objeto.setNomefantasia(man.jtfNomefantasia.getText());
        
        boolean resultado = DaoEmpresa.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Nome fantasia");
        modelo.addColumn("Razão social");
        List<Empresa> resultados = DaoEmpresa.consultar();
        for (Empresa objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNomefantasia());
            linha.add(objeto.getRazaosocial());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void alterar(ManutencaoEmpresa man){
        Empresa objeto = new Empresa();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNomefantasia(man.jtfNomefantasia.getText());
        objeto.setRazaosocial(man.jtfRazaosocial.getText());
        
        boolean resultado = DaoEmpresa.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static void excluir(ManutencaoEmpresa man){
        Empresa objeto = new Empresa();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoEmpresa.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
