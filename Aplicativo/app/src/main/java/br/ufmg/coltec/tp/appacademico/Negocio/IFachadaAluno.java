package br.ufmg.coltec.tp.appacademico.Negocio;

/**
 * Created by a2016951820 on 19/09/18.
 */

public interface IFachadaAluno {

    public void inserirAluno(Aluno aluno);

    public boolean removerAluno(long matricula);

    public Aluno buscarAluno(long matricula);

}
