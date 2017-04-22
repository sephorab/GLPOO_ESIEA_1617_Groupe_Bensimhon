package com.icauda.chiengenerator.domaine.adapter;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import fr.ybonnel.csvengine.adapter.AdapterCsv;

public class AdapterCouleurs extends AdapterCsv<List<String>> {

	@Override
	public List<String> parse(final String chaine) {
		return Lists.newArrayList(Splitter.on(",").split(chaine));
	}

	@Override
	public String toString(final List<String> couleurs) {
		return Joiner.on(',').join(couleurs);
	}

}
