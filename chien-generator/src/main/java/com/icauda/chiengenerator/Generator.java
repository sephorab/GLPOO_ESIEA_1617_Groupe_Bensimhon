package com.icauda.chiengenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.icauda.chiengenerator.domaine.Chien;
import com.icauda.chiengenerator.domaine.RaceDeChien;
import com.icauda.chiengenerator.domaine.Sexe;
import com.icauda.chiengenerator.domaine.SimpleChien;

import fr.ybonnel.csvengine.CsvEngine;
import fr.ybonnel.csvengine.model.EngineParameters;

public class Generator {

	// Filles : Emma, Lola, Chlo�, In�s, L�a, Jade, Manon, Louise, Zo�, Lilou, L�na, Sarah, Camille, Ma�lys, Lina, Eva, Louna, Clara, Alice et Romane.
	private static final String PRENOMS_FILLES = "Emma, Lola, Chlo�, In�s, L�a, Jade, Manon, Louise, Zo�, Lilou, L�na, Sarah, Camille, Ma�lys, Lina, Eva, Louna, Clara, Alice, Romane";
	private static final List<String> PRENOMS_FILLES_LIST = Splitter.on(",").trimResults().splitToList(PRENOMS_FILLES);
	private static final int PRENOMS_FILLES_LIST_SIZE = PRENOMS_FILLES_LIST.size();

	// Garcons : Nathan, Lucas, L�o, Enzo, Louis, Gabriel, Jules, Tim�o, Hugo, Arthur, Ethan, Rapha�l, Ma�l, Tom, Noah, Mathis, Th�o, Adam, Nolan et Cl�ment !
	private static final String PRENOMS_GARCONS = "Nathan, Lucas, L�o, Enzo, Louis, Gabriel, Jules, Tim�o, Hugo, Arthur, Ethan, Rapha�l, Ma�l, Tom, Noah, Mathis, Th�o, Adam, Nolan, Cl�ment";
	private static final List<String> PRENOMS_GARCONS_LIST = Splitter.on(",").trimResults().splitToList(PRENOMS_GARCONS);
	private static final int PRENOMS_GARCONS_LIST_SIZE = PRENOMS_GARCONS_LIST.size();

	// Pays : Allemagne, Autriche, Belgique, Chypre, Espagne, Estonie, Finlande, France, Gr�ce, Irlande, Italie, Lettonie, Luxembourg, Malte, Pays-Bas, Portugal, Slovaquie, Slov�nie
	private static final String PAYS = "Allemagne, Autriche, Belgique, Chypre, Espagne, Estonie, Finlande, France, Gr�ce, Irlande, Italie, Lettonie, Luxembourg, Malte, Pays-Bas, Portugal, Slovaquie, Slov�nie";
	private static final List<String> PAYS_LIST = Splitter.on(",").trimResults().splitToList(PAYS);
	private static final int PAYS_LIST_SIZE = PAYS_LIST.size();

	// Couleurs : rouge, orange, jaune, vert, bleu, indigo, violet
	private static final String COULEURS = "rouge, orange, jaune, vert, bleu, indigo, violet";
	private static final List<String> COULEURS_LIST = Splitter.on(",").trimResults().splitToList(COULEURS);
	private static final int COULEURS_LIST_SIZE = COULEURS_LIST.size();

	private static SimpleChien generateOneChien() {

		final Random random = new Random();
		final SimpleChien chien = new SimpleChien();

		// Sexe
		int rand = random.nextInt(2);
		final boolean isMale = rand == 0;
		final Sexe sexe = Sexe.valueOfByCode(rand + 1);
		chien.setSexe(sexe);

		// Nom
		String nom = null;
		switch (sexe) {
			case FEMALE:
				rand = random.nextInt(PRENOMS_FILLES_LIST_SIZE);
				nom = PRENOMS_FILLES_LIST.get(rand);
				break;

			case MALE:
				rand = random.nextInt(PRENOMS_GARCONS_LIST_SIZE);
				nom = PRENOMS_GARCONS_LIST.get(rand);
				break;
		}
		chien.setNom(nom);

		// Nom complet
		rand = random.nextInt(PAYS_LIST_SIZE);
		final String nomComplet = nom + " de " + PAYS_LIST.get(rand);
		chien.setNomComplet(nomComplet);

		// Couleur

		final int nbCouleurs = random.nextInt(3) + 1; // Le +1 pour eviter les listes vides.
		final List<String> couleurs = Lists.newArrayListWithExpectedSize(nbCouleurs);
		for (int i = 0; i < nbCouleurs; i++) {
			rand = random.nextInt(COULEURS_LIST_SIZE);
			final String couleur = COULEURS_LIST.get(rand);
			couleurs.add(couleur);
		}
		chien.setCouleurs(couleurs);

		// Race
		rand = random.nextInt(RaceDeChien.values().length);
		final RaceDeChien race = RaceDeChien.values()[rand];
		chien.setRace(race);

		// Poids
		final double poids = random.nextInt(20) + BigDecimal.valueOf(random.nextDouble()).setScale(1, RoundingMode.HALF_UP).doubleValue();
		chien.setPoids(poids);

		return chien;
	}

	private static void doSauver(final List<SimpleChien> chiens, final File file) {

		final EngineParameters parameters = EngineParameters.createBuilder().setAddQuoteCar(false).build();
		final CsvEngine engine = new CsvEngine(parameters, SimpleChien.class);

		try {
			engine.writeFile(new FileWriter(file), chiens, SimpleChien.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void generate(final int nb) {
		List<SimpleChien> chiens = Lists.newArrayListWithExpectedSize(nb);

		for (int i = 0; i < nb; i++) {
			chiens.add(generateOneChien());
		}

		for (final Chien chien : chiens) {
			System.out.println(chien);
		}

		final String fileName = "generated-chiens-" + nb + ".csv";
		final File f = new File(fileName);

		doSauver(chiens, f);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Chien generator");

		final int NB_CHIEN = 1000;

		// Ici je veux des fichiers avec de 50 a 10'000 chiens.
		// Ca marche si on en demande plus mais la taille des fichiers (en ko) explose.
		// Par exemple, pour 100'000, le fichier pese deja plusieurs Mo.
		final int[] nombres = { 50, 100, 200, 500, 1000, 10000 };
		for (final int nb : nombres) {
			generate(nb);
		}

		System.out.println("Done");

	}

}
