Android Flight Booking App (Tablet UI)
Ce projet est une application de démonstration Android conçue pour les tablettes. Elle présente une interface de réservation de vols en utilisant une disposition Maître-Détail (Master-Detail).

L'application affiche une liste de vols disponibles sur le côté gauche de l'écran. Lorsqu'un utilisateur sélectionne un vol dans la liste, les détails complets de ce vol s'affichent sur le côté droit de l'écran.

## ✨ Fonctionnalités

**Interface Maître-Détail :** L'écran principal est divisé en deux panneaux...
![Interface Maître-Détail de l'application]

<img alt="interface acceil" src="screenshots/Acceil.png" width="300" heigth="300">

**Liste des vols :** Un `RecyclerView` affiche une liste verticale des vols...

![Liste des vols dans l'application]

<img alt="Interface Maître-Détail" src="screenshots/list_vols.png" width="300" heigth="300">

**Panneau de détails dynamique :** Le panneau de droite est un `Fragment`...

![Panneau de détails du fragment]

<img alt="Interface Maître-Détail" src="screenshots/Panneau_fragement.png" width="300" heigth="300">

🛠️ Technologies et Concepts Démontrés
Langage : Kotlin

<img alt="Interface Maître-Détail" src="https://upload.wikimedia.org/wikipedia/commons/3/3a/Kotlin_icon_%282021-present%29.svg" width="180" heigth="180">

Enverenment : Android Studio

<img alt="Interface Maître-Détail" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Android_Studio_icon_%282023%29.svg/128px-Android_Studio_icon_%282023%29.svg.png?20230919062400" width="180" heigth="180">


📂 Structure du Projet
Voici les fichiers clés de ce projet et leur rôle :

MainActivity.kt: L'activité principale qui gère le RecyclerView (la liste "Maître") et héberge le conteneur du Fragment ("Détail").

FlightsAdapter.kt: L'adaptateur pour le RecyclerView qui gère l'affichage de la liste des vols.

FlightDetailFragment.kt: Le Fragment qui affiche les informations détaillées d'un vol sélectionné.

Flight.kt: La data class qui définit le modèle de données pour un Flight.

activity_main.xml: La disposition principale de l'application (le conteneur Maître-Détail).

item_fight.xml: La disposition XML pour une seule ligne dans le RecyclerView.

details_card.xml: La disposition XML pour la vue détaillée du ticket affichée dans le Fragment.
