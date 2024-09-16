package main.kotlin.loc_vehicules.modele

// Classe pour les citadines, héritant de Vehicule
class Citadine(
    marque: String,
    modele: String,
    couleur: String,
    carburant: String,
    private val taille: String
) : Vehicule(marque, modele, couleur, carburant) {

    // Surcharge de la méthode afficherDetails pour inclure la taille
    override fun afficherDetails() {
        super.afficherDetails()
        println("Taille: $taille")
    }
}