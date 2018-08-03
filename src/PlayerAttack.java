import java.util.ArrayList;
import java.util.List;

public class PlayerAttack implements PlayerShoot {

    public List<BulletPlayer> bulletPlayers = new ArrayList<>();
    private int timeInterval = 0;

    @Override
    public void run(Player player) {
        if (this.timeInterval == 40) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy()).multiply(1.5f);
            this.bulletPlayers.add(bulletPlayer);
            this.timeInterval = 0;
        } else {
            this.timeInterval += 1;
        }

        this.bulletPlayers
                .forEach(bulletPlayer -> bulletPlayer.run());
    }
}