package main.kotlin.loc_vehicules.service

import java.time.LocalDate
import main.kotlin.loc_vehicules.modele.*

// Classe pour gérer l'agence de location
class Agence {

    private val vehicules = mutableListOf<Vehicule>()
    private val locations = mutableListOf<Location>()

    init {
        // Ajouter quelques véhicules pour démarrer
        vehicules.run {
            add(VoitureSport("Ferrari", "488", "Rouge", "Essence", 670))
            add(Citadine("Renault", "Clio", "Bleu", "Diesel", "Petite"))
            add(Utilitaire("Mercedes", "Sprinter", "Blanc", "Diesel", 15.0))
        }
    }

    // Affiche tous les véhicules disponibles
    fun afficherVehicules() {
        if (vehicules.isEmpty()) {
            println("Aucun véhicule disponible.")
            return
        }
        vehicules.forEachIndexed { index, vehicule ->
            println("[$index] ")
            vehicule.afficherDetails()
            println()
        }
    }

    // Affiche toutes les locations en cours
    fun afficherLocations() {
        if (locations.isEmpty()) {
            println("Aucune location en cours.")
            return
        }
        locations.forEachIndexed { index, location ->
            println("[$index] ")
            location.afficherDetails()
            println()
        }
    }

    // Permet à un utilisateur de louer un véhicule
    fun nouvelleLocation() {
        afficherVehicules()
        println("Entrez le numéro du véhicule à louer :")
        val vehiculeIndex = readlnOrNull()?.toIntOrNull() ?: return
        if (vehiculeIndex !in vehicules.indices) {
            println("Numéro de véhicule invalide.")
            return
        }

        println("Entrez la date de début (YYYY-MM-DD) :")
        val dateDebut = lireDate(minDate = LocalDate.now()) ?: return
        println("Entrez la date de fin (YYYY-MM-DD) :")
        val dateFin = lireDate(minDate = dateDebut) ?: return

        val vehicule = vehicules[vehiculeIndex]

        // Vérifier la disponibilité du véhicule pour la période choisie
        if (!estDisponible(vehicule, dateDebut, dateFin)) {
            println("Le véhicule n'est pas disponible pour les dates fournies.")
            return
        }

        // Créer et ajouter la nouvelle location
        val location = Location(vehicule, dateDebut, dateFin)
        locations.add(location)
        println("Location ajoutée avec succès.")
    }

    // Permet de modifier une location
    fun modifierLocation() {
        afficherLocations()
        println("Entrez le numéro de la location à modifier :")
        val locationIndex = readlnOrNull()?.toIntOrNull() ?: return
        if (locationIndex !in locations.indices) {
            println("Numéro de location invalide.")
            return
        }

        val location = locations[locationIndex]
        while (true) {
            println("1 - Ajouter des kilomètres")
            println("2 - Annuler la location")
            println("3 - Payer la location")
            println("4 - Retourner le véhicule")
            println("5 - Afficher les détails de la location")
            println("6 - Quitter le menu")
            println("Choisissez une option :")

            when (readlnOrNull()?.toIntOrNull()) {
                1 -> {
                    if (location.terminee) {
                        println("La location est terminée. Vous ne pouvez plus ajouter de kilomètres.")
                        attendreInput()
                        continue
                    }
                    println("Entrez le nombre de kilomètres à ajouter :")
                    val kilometres = readlnOrNull()?.toIntOrNull() ?: return
                    location.ajouterKilometrage(kilometres)
                    println("Kilométrage mis à jour avec succès.")
                    attendreInput()
                }
                2 -> {
                    if (location.terminee) {
                        println("La location est déjà terminée.")
                        attendreInput()
                        continue
                    }
                    locations.removeAt(locationIndex)
                    println("Location annulée avec succès.")
                    attendreInput()
                    return
                }
                3 -> {
                    if (location.terminee) {
                        println("La location est déjà terminée.")
                        attendreInput()
                        continue
                    }
                    location.payee = true
                    location.terminee = true
                    println("Location marquée comme payée et retournée avec succès.")
                    locations.removeAt(locationIndex)
                    attendreInput()
                    return
                }
                4 -> {
                    if (!location.payee) {
                        println("La location doit être payée avant de pouvoir être retournée.")
                        attendreInput()
                        continue
                    }
                    location.terminee = true
                    println("Véhicule retourné avec succès.")
                    locations.removeAt(locationIndex)
                    attendreInput()
                }
                5 -> {
                    location.afficherDetails()
                    attendreInput()
                }
                6 -> return
                else -> println("Option invalide.")
            }
        }
    }

    // Vérifie la disponibilité d'un véhicule pour une période donnée
    private fun estDisponible(vehicule: Vehicule, dateDebut: LocalDate, dateFin: LocalDate): Boolean {
        return locations.none { location ->
            location.vehicule == vehicule &&
                    (dateDebut.isBefore(location.dateFin) && dateFin.isAfter(location.dateDebut))
        }
    }

    // Fonction pour lire une date au format YYYY-MM-DD avec gestion des erreurs
    private fun lireDate(minDate: LocalDate? = null): LocalDate? {
        return try {
            val dateInput = readlnOrNull() ?: return null
            val date = LocalDate.parse(dateInput)
            if (minDate != null && date.isBefore(minDate)) {
                println("La date doit être après ou égale à $minDate")
                null
            } else {
                date
            }
        } catch (e: Exception) {
            println("Erreur : ${e.message}. Utilisation de la date actuelle par défaut.")
            minDate ?: LocalDate.now()
        }
    }

    // Fonction pour attendre l'entrée de l'utilisateur avant de continuer
    private fun attendreInput() {
        println("Appuyez sur Entrée pour continuer...")
        readlnOrNull() // Attend que l'utilisateur appuie sur Entrée
    }
}