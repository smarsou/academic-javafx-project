Notre projet de Coding Week

## Installation

Ce projet est auto-suffisant dans le sans où il propose d'utiliser l'outil Gradle (https://gradle.org/) pour construire l'application fournie.
Un simple `./gradlew run` dans un terminal devrait vous télécharger l'outil gradle, télécharger les dépendances nécessaires (JavaFX en autre), lancer la compilation et exécuter le programme. 

Il se peut que vous rencontriez des problèmes. Voici quelques solutions :
- il faut que le script `./gradlew` soit exécutable (un simple `chmod a+x ./gradlew` devrait faire l'affaire)
- Gradle ne supportant pas encore Java 19, il faut utiliser une version 17 ou 18 du Java Development Kit (JDK) (utiliser la commande `java --version` ou un `./gradlew --version` pour vérifier votre version actuelle du JDK.)

Cette configuration peut également être importer dans IntelliJ pour créer un projet fonctionnelle à partir de celle-ci. Pour cela, lors de la création de votre projet IntelliJ, il faut sélectionner le fichier `build.gradle` et non pas uniquement le répertoire du projet.

# Conception DAY 1

Aujourd'hui, nous avons fait une conception global de l'application. Nous avons dessiner les croquis de toutes les vues que l'on aimerais avoir, ainsi qu'un diagramme de classe.

## Diagramme de classe

Voir gp/classDiag.puml

### Resultat DAY 1

Le résultat est une projet Gradle fonctionnelle. Il affiche le menu principale et n'est pour l'instant pas intéractif. Nous avons sous-estimé le travail à faire.
