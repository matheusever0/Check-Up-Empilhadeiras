package br.com.fortlev.cue.controller;

import br.com.fortlev.cue.bean.Empilhadeira;
import br.com.fortlev.cue.dao.EmpilhadeiraDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author matheus.s
 */
public class EmpilhadeiraController {

    Empilhadeira emp = new Empilhadeira();
    EmpilhadeiraDAO dao = new EmpilhadeiraDAO();

    public void cadastroEmpilhadeira(JTextField numeroemp, JTextField numeroserie, JTextField modelo) {


        emp.setNumeroEmp(Integer.parseInt(numeroemp.getText()));
        emp.setNumeroDeSerie(Integer.parseInt(numeroserie.getText()));
        emp.setModelo(modelo.getText());

        try {
            if (dao.create(emp) == true) {
                JOptionPane.showMessageDialog(null, "Cadastro de empilhadeira criado com sucesso!");
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpilhadeiraController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateEmpilhadeira(JTextField numeroemp, JTextField numeroserie, JTextField modelo, JTextField id) {


        emp.setNumeroEmp(Integer.parseInt(numeroemp.getText()));
        emp.setNumeroDeSerie(Integer.parseInt(numeroserie.getText()));
        emp.setModelo(modelo.getText());
        emp.setId(Integer.parseInt(id.getText()));

        try {
            if (dao.update(emp) == true) {
                JOptionPane.showMessageDialog(null, "Atualizaçao de empilhadeira foi um sucesso!");
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpilhadeiraController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ExcluirEmpilhadeira(JTextField id) {

        emp.setId(Integer.parseInt(id.getText()));

        try {
            if (dao.delete(emp) == true) {
                JOptionPane.showMessageDialog(null, "A exclusão foi um sucesso!");
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpilhadeiraController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
