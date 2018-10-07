# Jeu2D

MISE EN PLACE

- Créer un projet java avec votre IDE

- Créer un dossier au niveau de votre projet

- Faites glisser les deux images PNG dans ce dossier

- Clique droit sur votre projet / properties
  Onglet librairies / add class folder -> séléctionner le dossier contenant les deux images
  
- ZQSD pour se déplacer sinon modifier touches clavier dans KeyInput.java

			if (tempObject.getId() == ID.Player) {
				if (key == KeyEvent.VK_Z) handler.setUp(true);
				if (key == KeyEvent.VK_S) handler.setDown(true);
				if (key == KeyEvent.VK_Q) handler.setLeft(true);
				if (key == KeyEvent.VK_D) handler.setRight(true);
        
        Remplacer VK_Z par VK_W
        ...
