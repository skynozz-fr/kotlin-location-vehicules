package main.kotlin.loc_vehicules.modele

class VoitureSport(
    marque: String,
    modele: String,
    couleur: String,
    carburant: String,
    private val puissance: Int,
) : Vehicule(marque, modele, couleur, carburant) {

    // Affiche les détails spécifiques de la voiture de sport
    override fun afficherDetails() {
        super.afficherDetails()
        println("Puissance : $puissance ch")
    }

    // Fournit une représentation textuelle de la voiture de sport
    override fun toString(): String {
        return "${super.toString()}, Puissance : $puissance ch"
    }
}