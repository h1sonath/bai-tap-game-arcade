package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.EnemyAttack;
import game.enemy.EnemyShoot;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        if (this.position.x < 0 || this.position.x>1024 || this.position.y<0 || this.position.y>600)
        {
            this.isAlive = false;
        }
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);

        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.update(player.position);
        }
    }

    private void update(Vector2D position) {
        this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(1.5f);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}