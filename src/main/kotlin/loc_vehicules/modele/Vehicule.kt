package main.kotlin.loc_vehicules.modele

// Classe de base pour tous les types de véhicules
open class Vehicule(
    private val marque: String,
    private val modele: String,
    private val couleur: String,
    private val carburant: String
) {
    // Fonction pour afficher les caractéristiques du véhicule
    open fun afficherDetails() {
        println("Marque: $marque")
        println("Modèle: $modele")
        println("Couleur: $couleur")
        println("Carburant: $carburant")
    }
}