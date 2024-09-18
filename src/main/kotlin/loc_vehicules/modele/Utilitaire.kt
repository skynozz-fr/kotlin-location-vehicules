package main.kotlin.loc_vehicules.modele

class Utilitaire(
    marque: String,
    modele: String,
    couleur: String,
    carburant: String,
    private val volume: Double
) : Vehicule(marque, modele, couleur, carburant) {

    // Surcharge de la méthode afficherDetails pour inclure le volume
    override fun afficherDetails() {
        super.afficherDetails()
        println("Volume: $volume m³")
    }

    // Fournit une représentation textuelle de l'utilitaire
    override fun toString(): String {
        return "${super.toString()}, Volume : $volume m³"
    }
}