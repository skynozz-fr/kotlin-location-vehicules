package main.kotlin.loc_vehicules.modele

open class Vehicule(
    private val marque: String,
    private val modele: String,
    private val couleur: String,
    private val carburant: String,
) {
    // Fonction pour afficher les caractéristiques du véhicule
    open fun afficherDetails() {
        println("Marque : $marque")
        println("Modèle : $modele")
        println("Couleur : $couleur")
        println("Carburant : $carburant")
    }

    override fun toString(): String {
        return "Marque : $marque, Modèle : $modele, Couleur : $couleur, Carburant : $carburant"
    }
}