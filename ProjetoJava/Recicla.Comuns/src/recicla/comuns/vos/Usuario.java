/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recicla.comuns.vos;

import recicla.comuns.crud.basis.Entidade;

/**
 *
 * @author vitorlupinetti
 */
public class Usuario extends Entidade {
    private String Nome;
    private String Usuario;
    private String Senha;
    private char TipoUsuario;
    private int SalaId;
    private double Dinheiro;
}
