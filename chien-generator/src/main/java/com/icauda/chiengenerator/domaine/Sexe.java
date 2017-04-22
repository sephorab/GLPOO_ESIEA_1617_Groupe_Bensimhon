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
 * Cette enum represente un sexe.
 * 
 * @author Thierry Leriche-Dessirier
 * 
 */
public enum Sexe {

	/*
	 * Note : Les commentaire entoures de dieses (#) servent a vous montrer la structure de l'enum. Dans un "vrai" programme, on ne les aurait probablement pas mis.
	 */

	// ################################################
	// ############## Valeurs de l'enum ###############
	// ################################################

	/**
	 * Female
	 */
	FEMALE(2, "f"),

	/**
	 * Male
	 */
	MALE(1, "m");

	// ################################################
	// ################# Attributs ####################
	// ################################################

	private final int code;
	private final String lettre;

	// ################################################
	// ############### Constructeur ###################
	// ################################################

	/**
	 * Construit un sexe.
	 * 
	 * @param code
	 * @param lettre
	 */
	Sexe(final int code, final String lettre) {
		this.code = code;
		this.lettre = lettre;
	}

	// ################################################
	// ############## Methodes diverses ###############
	// ################################################

	/**
	 * Renvoie un sexe a partir de son code.
	 * 
	 * @param code
	 * @return Le sexe
	 * @throws IllegalArgumentException
	 *             si le code ne permet pas de trouver la sexe correspondante.
	 */
	public static Sexe valueOfByCode(final int code) {
		switch (code) {
			case 1:
				return MALE;

			case 2:
				return FEMALE;

			default:
				throw new IllegalArgumentException("Le sexe demande n'existe pas.");
		}
	}

	public static Sexe valueOfByLettre(final String lettre) {

		for (Sexe sexe : values()) {
			if (sexe.lettre.equals(lettre)) {
				return sexe;
			}
		}

		throw new IllegalArgumentException("Le sexe demande n'existe pas.");
	}

	public boolean isMale() {
		return this == MALE;
	}

	// ################################################
	// ################ Getters #######################
	// ################################################

	public int getCode() {
		return code;
	}
}
