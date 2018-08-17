
package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public EnemyShoot enemyShoot;

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
        if (this.position.x < 0 || this.position.x > 1024 || this.position.y < 0 || this.position.y > 600) {
            this.isAlive = false;
        }
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        this.enemyShoot.run(this);
    }

    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}


