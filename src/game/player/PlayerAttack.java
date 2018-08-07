package game.player;

import base.FrameCounter;
import base.GameObjectManager;

public class PlayerAttack implements PlayerShoot {

    private FrameCounter frameCounter = new FrameCounter(40);

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy()).multiply(1.5f);
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}
