package main.kotlin.loc_vehicules.modele

class Citadine(
    marque: String,
    modele: String,
    couleur: String,
    carburant: String,
    private val taille: String
) : Vehicule(marque, modele, couleur, carburant) {

    // Affiche les détails spécifiques de la citadine
    override fun afficherDetails() {
        super.afficherDetails()
        println("Taille : $taille")
    }

    // Fournit une représentation textuelle de la citadine
    override fun toString(): String {
        return "${super.toString()}, Taille : $taille"
    }
}