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

/**
 * Cette enum represente une race de chien.
 * 
 * J'ai mis une vingtaine de races seulement car ca prend du temps de lister toutes les races qui existent ; il y en a vraiment beaucoup. Rien de vous empeche d'en ajouter.
 * 
 * @author Thierry Leriche-Dessirier
 * 
 */
public enum RaceDeChien {

	/*
	 * Note : Les commentaire entoures de dieses (#) servent a vous montrer la structure de l'enum. Dans un "vrai" programme, on ne les aurait probablement pas mis.
	 */

	// ################################################
	// ############## Valeurs de l'enum ###############
	// ################################################

	/**
	 * Akita
	 */
	AKITA("Akita", "akita"),

	/**
	 * Akita inu
	 */
	AKITA_INU("Akita inu", "akitinu"),

	/**
	 * Basset des Alpes
	 */
	BASSET_ALPES("Basset des Alpes", "basset_alp"),

	/**
	 * Berger allemand
	 */
	BERGER_ALLEMAND("Berger allemand", "berger_all"),

	/**
	 * Caniche
	 */
	CANICHE("Caniche", "caniche"),

	/**
	 * Danois
	 */
	DANOIS("Danois", "danois"),

	/**
	 * Dunker
	 */
	DUNKER("Dunker", "dunker"),

	/**
	 * Estrela
	 */
	ESTRALA("Estrela", "estrela"),

	/**
	 * Golden retriever
	 */
	GOLDEN("Golden retriever", "golden_ret"),

	/**
	 * Harrier
	 */
	HARRIER("Harrier", "harrier"),

	/**
	 * Irish red setter
	 */
	IRISH_RED_SETTER("Irish red setter", "iriredse"),

	/**
	 * Irish setter
	 */
	IRISH_SETTER("Irish setter", "irisett"),

	/**
	 * Jack Russell terrier
	 */
	JACK_RUSSELL_TERRIER("Jack Russell terrier", "jackrute"),

	/**
	 * Kangai
	 */
	KANGAI("Kangai", "kangai"),

	/**
	 * Labrador
	 */
	LABRADOR("Labrador", "labrador"),

	/**
	 * Maltais
	 */
	MALTAIS("Maltais", "maltais"),

	/**
	 * Ovtcharka du Caucase
	 */
	OVTCHARKA_CAUCASE("Ovtcharka du Caucase", "ovtccau"),

	/**
	 * Rottweiler
	 */
	ROTTWEILER("Rottweiler", "rottweiler"),

	/**
	 * Tchin
	 */
	TCHIN("Tchin", "tchin"),

	/**
	 * Westie
	 */
	WESTIE("Westie", "westie");

	// TODO Ajouter d'autres races de chien. Vous trouverez une
	// liste assez exhaustive sur http://www.chien.com. Pour que ce soit plus
	// simple a lire, bien que ce ne soit pas obligatoire, conservez
	// ordre alphabetique.

	// ################################################
	// ################# Attributs ####################
	// ################################################

	/**
	 * Le "label" est utilise pour les affichages.
	 */
	private final String label;

	/**
	 * Le "code" est enregistre en base de donnees ou dans les fichiers CSV, etc.
	 */
	private final String code;

	// ################################################
	// ############### Constructeur ###################
	// ################################################

	/**
	 * Construit une race de chien.
	 * 
	 * @param label
	 * @param code
	 */
	RaceDeChien(final String label, final String code) {
		this.label = label;
		this.code = code;
	}

	// ################################################
	// ############## Methodes diverses ###############
	// ################################################

	/**
	 * Recherche une race a partir de son code.
	 * 
	 * @param code
	 * @return La race.
	 * @throws IllegalArgumentException
	 *             si le code est "vide" ou ne permet pas de trouver la race correspondante.
	 * 
	 */
	public static RaceDeChien valueOfByCode(final String code) {

		// On verifie que le code n'est ni null ni vide.
		if (code == null || code.isEmpty()) {
			throw new IllegalArgumentException("Le code ne peut pas etre vide.");
		}

		// Note : La methode "values()" renvoie la liste de toutes les
		// "instances" ce cette enum (ie. BASSET_ALPES, CANICHE, HARRIER, etc.)

		for (RaceDeChien race : values()) {
			if (race.code.equalsIgnoreCase(code)) {
				return race;
			}
		}

		// Si on n'a pas trouve alors on lance une exception.
		throw new IllegalArgumentException("La race de chien demandee n'existe pas.");
	}

	// ################################################
	// ################ Getters #######################
	// ################################################

	public String getLabel() {
		return label;
	}

	public String getCode() {
		return code;
	}

}
