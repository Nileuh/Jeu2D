import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Character extends GameObject {
	
	Handler handler;
	Game game;
	
	private BufferedImage[] character_image = new BufferedImage [3];
	
	Animation anim;

	public Character(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.game = game;
		
		character_image [0] = ss.grabImage(1, 2, 32, 38);
		character_image [1] = ss.grabImage(2, 2, 32, 38);
		character_image [2] = ss.grabImage(3, 2, 32, 38);
		
		anim = new Animation(3, character_image[0], character_image[1], character_image[2]);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		//mouvement et vitesse
		
		if (handler.isUp()) velY = -2;
		else if (!handler.isDown()) velY = 0;
		
		if (handler.isDown()) velY = 2;
		else if (!handler.isUp()) velY = 0;
		
		if (handler.isRight()) velX = 2;
		else if (!handler.isLeft()) velX = 0;
		
		if (handler.isLeft()) velX = -2;
		else if (!handler.isRight()) velX = 0;
		
		anim.runAnimation();
	}
	
	private void collision() {
		for (int i = 0 ; i < handler.object.size() ; i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Block) {
				if (getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			if (tempObject.getId() == ID.Crate) {
				if (getBounds().intersects(tempObject.getBounds())) {
					game.ammo += 10;
					handler.removeObject(tempObject);
				}
			}		
			
			if (tempObject.getId() == ID.Enemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					game.hp --;
				}
			}
		}
	}

	public void render(Graphics g) {
		if (velX == 0 && velY == 0) {
			g.drawImage(character_image[0], x, y, null);
		}else anim.drawAnimation(g, x, y, 0);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 38);
	}

}
