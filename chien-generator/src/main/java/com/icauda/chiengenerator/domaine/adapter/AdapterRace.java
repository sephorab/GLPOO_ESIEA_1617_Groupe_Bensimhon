package com.icauda.chiengenerator.domaine.adapter;

import com.icauda.chiengenerator.domaine.RaceDeChien;

import fr.ybonnel.csvengine.adapter.AdapterCsv;

public class AdapterRace extends AdapterCsv<RaceDeChien> {

	@Override
	public RaceDeChien parse(String chaine) {
		return RaceDeChien.valueOfByCode(chaine);
	}

	@Override
	public String toString(RaceDeChien race) {
		return race.getCode();
	}
}
