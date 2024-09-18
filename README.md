# Gestion de Location de Véhicules

Ce projet est une application Kotlin de gestion de location de véhicules, permettant à une agence de gérer la disponibilité, les locations, et les retours de véhicules tout en maintenant un suivi du kilométrage et des paiements.

## Fonctionnalités

- **Gestion des véhicules** : L'application permet de visualiser les véhicules disponibles pour la location, incluant des modèles tels que des voitures de sport, citadines et utilitaires.

- **Création de locations** : Les utilisateurs peuvent créer de nouvelles locations en spécifiant des dates de début et de fin. L'application vérifie automatiquement la disponibilité des véhicules pour les périodes sélectionnées.

- **Suivi des kilométrages** : Pendant la durée d'une location, il est possible d'ajouter du kilométrage au véhicule, sauf si la location est terminée.

- **Paiement et retour** : Une location doit être payée avant que le véhicule ne soit retourné. Une fois payée, la location est marquée comme terminée et le véhicule est de nouveau disponible.

- **Annulation de location** : Les locations peuvent être annulées à tout moment, et l'annulation renvoie immédiatement l'utilisateur au menu principal sans possibilité de modifier la location annulée.

## Structure du projet

Le projet est organisé comme suit :

- **Main.kt** permet de lancer l'application.

- **modele** : Contient les classes représentant les véhicules (`Vehicule`, `VoitureSport`, `Citadine`, `Utilitaire`) et les locations (`Location`).

- **service** : Contient la classe `Agence` qui gère la logique de création, modification et affichage des véhicules et des locations.

## Exécution
Pour exécuter le projet, suivez ces étapes :
1. **Ouvrir le Projet** : Ouvrez le projet dans un IDE compatible avec Kotlin, tel qu'IntelliJ IDEA.
2. **Exécuter l'application** : Exécutez le fichier `Main.kt`. L'application se lancera dans la console.