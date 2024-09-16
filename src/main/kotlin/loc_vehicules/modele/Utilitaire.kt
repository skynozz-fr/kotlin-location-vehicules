package main.kotlin.loc_vehicules.modele

// Classe pour les utilitaires, héritant de Vehicule
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
}