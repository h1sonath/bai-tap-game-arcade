package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject {

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
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        Player player = GameObjectManager.instance.findPlayer();
        if(player!=null){
            this.update(player.position);
        }
        if(GameObjectManager.instance.checkCollision5(this)){
            player.isAlive = false;
        }
    }

    private void update(Vector2D position) {
        this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(1.5f);

    }
}
