package game.player;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;

public class PlayerShoot implements Attribute<Player> {

    private FrameCounter frameCounter = new FrameCounter(10);

    @Override
    public void run(Player gameObject) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy()).multiply(1.5f);

            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}
