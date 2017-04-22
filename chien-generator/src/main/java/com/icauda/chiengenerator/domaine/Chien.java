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

import java.io.Serializable;
import java.util.List;

/**
 * Cette interface represente un chien.
 * 
 * @author Thierry Leriche-Dessirier
 * 
 */
public interface Chien extends Serializable {

	/*
	 * Note : Les methodes d'une interfaces sont automatiquement "public".
	 */

	/**
	 * Renvoie le nom du chien.
	 * 
	 * Ex. Milou
	 * 
	 * @return
	 */
	String getNom();

	/**
	 * Renvoie le nom complet du chien.
	 * 
	 * Ex. Milou de Belgique des gardes
	 * 
	 * @return
	 */
	String getNomComplet();

	/**
	 * Renvoie le sexe du chien (ie. Male / Female).
	 * 
	 * @return
	 */
	Sexe getSexe();

	/**
	 * Renvoie la race du chien.
	 * 
	 * @return
	 */
	RaceDeChien getRace();

	/**
	 * Renvoie les couleurs du chien sous forme de liste.
	 * 
	 * Ex. {"noir", "blanc", "gris"}
	 * 
	 * @return
	 */
	List<String> getCouleurs();

	/**
	 * Renvoie le poids du chien.
	 * 
	 * @return
	 */
	Double getPoids();

}
