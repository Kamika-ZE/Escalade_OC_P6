# ECALADE_OC_P6

# Projet réalisé dans le cadre de la formation Développeur d'application JAVA OpenClassrooms.

	Création d'un site communautaire autour de l'escalade pour l'association "Les amis de l'escalade".

# Contexte :

	Avec l’objectif de fédérer les licenciés, l’association “Les amis de l’escalade” souhaite développer
	sa présence en ligne. À ce titre, plusieurs axes d’amélioration	ont été identifiés dont la création 
	d’un site communautaire.
	Ce site aura pour but la mise en relation et le partage d’informations. Il permettra de donner 
	de la visibilité l’association afin d’encourager des grimpeurs	indépendants à y adhérer.


## Les fonctions :

	- F1 : Un utilisateur doit pouvoir consulter les informations des sites	d’escalades
	(secteurs, voies, longueurs, etc.).

	- F2 : Un utilisateur doit pouvoir faire une recherche à l’aide de plusieurs critères 
	pour trouver un site de grimpe et consulter le résultat de cette recherche. 
	Les critères peuvent être le lieu, la cotation, le nombre de secteurs, etc.

	- F3 : Un utilisateur doit pouvoir s’inscrire gratuitement sur le site.

	- F4 : Un utilisateur connecté doit pouvoir partager des informations sur un site d’escalade
	(secteurs, voies, longueurs, etc.).

	- F5 : Un utilisateur connecté doit pouvoir laisser des commentaires sur les pages des sites d’escalade.

	- F6 : Un membre de l'association doit pouvoir taguer un site d’escalade enregistré 
	sur la plateforme comme « Officiel Les amis de l’escalade ».

	- F7 : Un membre de l'association doit pouvoir modifier et supprimer un commentaire.

	- F8 : Un utilisateur connecté doit pouvoir enregistrer dans son espace	personnel 
	les topos qu’ils possèdent et préciser si ces derniers sont disponibles pour être prêtés ou non.
	Un topo est défini par un nom, une description, un lieu et une date de parution.

	- F9 : Un utilisateur connecté doit pouvoir consulter la liste des topos disponibles par d’autres 
	utilisateurs et faire une demande de réservation. La réservation n’inclut pas les notions de date 
	de début et date de fin.

	- F10 : Un utilisateur connecté doit pouvoir accepter une demande de réservation.
	Si une réservation est acceptée, automatiquement le topo devient indisponible. 
	L’utilisateur connecté pourra ensuite de nouveau changer le statut du topo en « disponible ».
	La plateforme se contente de mettre en contact les deux parties pour le	prêt d’un topo 
	(par échange de coordonnées).

	
## Les contraintes fonctionnelles

	- Vocabulaire de l'escalade utilisé.
	- Le site est responsive.
	- le site est sécurisé. (aucun mot de passe est stocké en clair dans la BDD)
	
## Développement et déploiement
	
	## Développement

	Cette application a été développé avec :
	- Intellij IDEA 2019.3
	- Java 8 (version 1.8u231)
	- Tomcat 9
	- PostgreSql 11 (version 11.5.2)
	- le framework Spring (version 5.2.1)
	
	## Déploiement
	
	Pour la base de données :
	Vous trouverez ce qu'il vous faut dans le dossier "lesamisdelescalade-files/DB_lesamisdelescalade/":
		* D'abord lancer le script create_role.sql pour créer le propriétaire de la bdd.
		* Ensuite lancer le script create_db.sql pour créer la bdd.
		* Enfin lancer le restore avec data.backup pour insérer les données.

	Si vous passez par pgAdmin, il faut :
		* créer un nouveau rôle, le nommer "admin_lesamisdelescalade", mettre en password "lesamisdelescalade", 
		et lui donner tous les privilèges.
		* créer une nouvelle database, la nommer "db_OC_lesamisdelescalade" et mettre "admin_lesamisdelescalade" 
		en tant que propriétaire.
		* faire un restore avec le fichier db_oc_lesamisdelescalade.backup.



	Dans le dossier "lesamisdelescalade-files/", vous trouverez aussi le fichier "lesamisdelescalade-webapp.war".
	Il faut copier/coller ce fichier dans le dossier "webapp" du server Tomcat.

    ## Lancement de l'application
    
    Lancer le serveur tomcat en ouvrant le fichier "startup.bat" situé dans le dossier "bin".
    Dans le navigateur, entrer l'adresse suivante :
    http://localhost:8080/lesamisdelescalade-webapp/

## Auteur

M.COZ 
