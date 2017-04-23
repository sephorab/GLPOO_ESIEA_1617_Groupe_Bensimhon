package com.eggame.enfant.dao.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.eggame.enfant.Enfant;

import au.com.bytecode.opencsv.CSVReader;


public class OpenCsvEnfantDao {
	
	protected File file;
	protected List<Enfant> enfants;	
	
	
	private static final Logger LOGGER = Logger.getLogger(OpenCsvEnfantDao.class);

	private final static char SEPARATOR = ';';
	
	public void initialiserFichier(File file) {
		LOGGER.debug("init");
		this.file = file;
	}
	
	private List<String[]> getLignesFromFile() {
		LOGGER.debug("getLignesFromFile");

		if (file == null) {
			throw new IllegalStateException("Le fichier est nul...");
		}

		final List<String[]> lignes = new ArrayList<String[]>();

		try {
			final FileReader fr = new FileReader(file);
			final CSVReader csvReader = new CSVReader(fr, SEPARATOR);

			String[] nextLine = null;
			while ((nextLine = csvReader.readNext()) != null) {
				int size = nextLine.length;

				// ligne vide
				if (size == 0) {
					continue;
				}
				String debut = nextLine[0].trim();
				if (debut.isEmpty() && size == 1) {
					continue;
				}

				// ligne de commentaire
				if (debut.startsWith("#")) {
					continue;
				}
				lignes.add(nextLine);
			}

		} catch (Exception e) {
			LOGGER.error("aie aie aie", e);
		}

		return lignes;
	}
	
	private Enfant transformerLigneEnEnfant(final String[] valeurs) {
		LOGGER.debug("TRANSFORMER LIGNE EN ENFANT DEBUG");
		final Enfant enfant=new Enfant();
		final String nom=valeurs[0];
		enfant.setNom(nom);
		final int posX=Integer.parseInt(valeurs[1].trim());
		enfant.setPosX(posX);
		final int posY=Integer.parseInt(valeurs[2].trim());
		enfant.setPosY(posY);
		final String orientation=valeurs[3].trim();
		enfant.setOrientation(orientation);
		
		return enfant;
	}
	public List<Enfant> listerEnfants() throws Exception {
		final List<String[]> liste=getLignesFromFile();
		liste.remove(0); // supprime l'en-tête
		final List<Enfant> listeEnfant=new ArrayList<Enfant>();
		for(String[] valeurEnfant:liste) {
			Enfant enfant =transformerLigneEnEnfant(valeurEnfant);
			listeEnfant.add(enfant);
		}
		return listeEnfant; 
	} 

}