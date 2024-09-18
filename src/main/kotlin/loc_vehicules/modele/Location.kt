package main.kotlin.loc_vehicules.modele

import java.time.LocalDate

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
        println("$vehicule")
        println("Date de début : $dateDebut")
        println("Date de fin : $dateFin")
        println("Kilométrage : $kilometrage km")
        println("Payée : ${if (payee) "Oui" else "Non"}")
        println("Terminée : ${if (terminee) "Oui" else "Non"}")
    }

    // Ajoute des kilomètres à la location
    fun ajouterKilometrage(kilometres: Int) {
        if (!terminee) {
            kilometrage += kilometres
        } else {
            println("Impossible d'ajouter des kilomètres, la location est terminée.")
        }
    }
}