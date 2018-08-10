package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject {

    public Vector2D velocity;

    public EnemyShoot enemyShoot;
    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10,this.position.y - 10);
        if(GameObjectManager.instance.checkCollision4(this)){
            Player player = GameObjectManager.instance.findPlayer();
            player.isAlive = false;
        }
        }
    }

