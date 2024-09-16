package main.kotlin.loc_vehicules.modele

// Classe pour les voitures de sport, héritant de Vehicule
class VoitureSport(
    marque: String,
    modele: String,
    couleur: String,
    carburant: String,
    private val puissance: Int
) : Vehicule(marque, modele, couleur, carburant) {

    // Surcharge de la méthode afficherDetails pour inclure la puissance
    override fun afficherDetails() {
        super.afficherDetails()
        println("Puissance: $puissance CV")
    }
}