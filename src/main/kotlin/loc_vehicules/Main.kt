package main.kotlin.loc_vehicules

import main.kotlin.loc_vehicules.service.Agence

fun main() {
    val agence = Agence() // Création d'une instance de l'agence

    while (true) {
        println("Menu principal :")
        println("1 - Afficher tous les véhicules")
        println("2 - Afficher les locations")
        println("3 - Nouvelle location")
        println("4 - Modifier une location")
        println("5 - Quitter")
        println("Choisissez une option :")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> agence.afficherVehicules() // Affiche la liste des véhicules
            2 -> agence.afficherLocations() // Affiche la liste des locations
            3 -> agence.nouvelleLocation()  // Permet de louer un véhicule
            4 -> agence.modifierLocation()  // Permet de modifier une location
            5 -> {
                println("Merci d'utiliser notre service. À bientôt !")
                return
            }
            else -> println("Option invalide. Veuillez réessayer.")
        }
    }

}