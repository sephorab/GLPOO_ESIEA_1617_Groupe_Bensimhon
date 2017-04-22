/*
 * Copyright (C)1995-2013 icauda.com
 * Copyright (C)2012 Developpez.com
 *
 * Ces sources sont libres de droits, et vous pouvez les utiliser a votre 
 * convenance. 
 * 
 * http://www.icauda.com 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.icauda.chiengenerator.domaine;

import java.util.ArrayList;
import java.util.List;

import com.icauda.chiengenerator.domaine.adapter.AdapterCouleurs;
import com.icauda.chiengenerator.domaine.adapter.AdapterPoids;
import com.icauda.chiengenerator.domaine.adapter.AdapterRace;
import com.icauda.chiengenerator.domaine.adapter.AdapterSexe;

import fr.ybonnel.csvengine.annotation.CsvColumn;
import fr.ybonnel.csvengine.annotation.CsvFile;

/**
 * Represente un chien standard.
 * 
 * @author Thierry Leriche-Dessirier
 * 
 */
@CsvFile(separator = ";")
public class SimpleChien implements Chien {

	/**
	 * serial Version UID
	 */
	/*
	 * Note : Ne faites pas attention au "serialVersionUID" pour l'instant.
	 */
	private static final long serialVersionUID = -1225454238084424608L;

	/*
	 * Note : Les commentaire entoures de dieses (#) servent a vous montrer la structure de la classe. Dans un "vrai" programme, on ne les aurait probablement pas mis.
	 */

	// ################################################
	// ################# Attributs ####################
	// ################################################

	@CsvColumn(value = "Nom", order = 0)
	private String nom;

	@CsvColumn(value = "Nom complet", order = 1)
	private String nomComplet;

	@CsvColumn(value = "sexe", adapter = AdapterSexe.class, order = 2)
	private Sexe sexe;

	@CsvColumn(value = "race", adapter = AdapterRace.class, order = 3)
	private RaceDeChien race;

	@CsvColumn(value = "couleurs", adapter = AdapterCouleurs.class, order = 4)
	private List<String> couleurs;

	@CsvColumn(value = "poids", adapter = AdapterPoids.class, order = 5)
	private Double poids;

	// ################################################
	// ############### Constructeurs ##################
	// ################################################

	/**
	 * Construit un chien.
	 */
	public SimpleChien() {
		// rien...
	}

	public SimpleChien(final String nom) {
		this.nom = nom;
	}

	public SimpleChien(final String nom, final RaceDeChien race, final Sexe sexe) {
		this(nom);
		this.race = race;
		this.sexe = sexe;
	}

	public SimpleChien(String nom, String nomComplet, Sexe sexe, RaceDeChien race, List<String> couleurs, Double poids) {
		this(nom, race, sexe);
		this.nomComplet = nomComplet;
		this.couleurs = couleurs;
		this.poids = poids;
	}

	public SimpleChien(String nom, String nomComplet, Sexe sexe, RaceDeChien race, String[] couleurs, Double poids) {
		this(nom, nomComplet, sexe, race, tabToList(couleurs), poids);

	}

	private static List<String> tabToList(String[] couleurs) {
		List<String> couleurList = new ArrayList<String>();
		for (String couleur : couleurs) {
			couleurList.add(couleur);
		}
		return couleurList;
	}

	// ################################################
	// ############## Methodes diverses ###############
	// ################################################

	// @Override
	// public String toString() {
	// return "SimpleChien [nom=" + nom + "]";
	// }

	@Override
	public String toString() {
		return "SimpleChien [nom=" + nom + ", nomComplet=" + nomComplet + ", sexe=" + sexe + ", race=" + race + ", couleurs=" + couleurs + ", poids=" + poids + "]";
	}

	// ################################################
	// ############# Getters et setters ###############
	// ################################################

	/*
	 * Note : J'ai genere les getters/setters a l'aide d'Eclipse. Bouton droit puis "Sources" puis "Generate getters and setters".
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public RaceDeChien getRace() {
		return race;
	}

	public void setRace(RaceDeChien race) {
		this.race = race;
	}

	public List<String> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(List<String> couleurs) {
		this.couleurs = couleurs;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

}
