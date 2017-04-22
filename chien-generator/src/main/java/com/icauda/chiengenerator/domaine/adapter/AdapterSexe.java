package com.icauda.chiengenerator.domaine.adapter;

import com.icauda.chiengenerator.domaine.Sexe;

import fr.ybonnel.csvengine.adapter.AdapterCsv;

public class AdapterSexe extends AdapterCsv<Sexe> {

	@Override
	public Sexe parse(String chaine) {
		return Sexe.valueOfByCode(Integer.parseInt(chaine));
	}

	@Override
	public String toString(Sexe sexe) {
		return sexe.isMale() ? "1" : "2";
	}
}
