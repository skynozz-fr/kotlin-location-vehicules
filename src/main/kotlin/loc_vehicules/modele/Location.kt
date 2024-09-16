package main.kotlin.loc_vehicules.modele

import java.time.LocalDate

// Classe pour représenter une location
class Location(
    val vehicule: Vehicule,
    val dateDebut: LocalDate,
    val dateFin: LocalDate
) {
    var kilometrage: Int = 0
    var payee: Boolean = false
    var terminee: Boolean = false

    // Fonction pour afficher les détails de la location
    fun afficherDetails() {
        println("Véhicule : $vehicule")
        println("Date de début : $dateDebut")
        println("Date de fin : $dateFin")
        println("Kilométrage : $kilometrage km")
        println("Payée : $payee")
        println("Terminée : $terminee")
    }
}