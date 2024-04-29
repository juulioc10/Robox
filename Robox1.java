package Robox;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

import java.awt.Color;

public class ProfessionalBot extends AdvancedRobot {
    
    private static final double MAX_SPEED = 5; // Velocidade máxima do robô
    private static final double FIRE_POWER = 3; // Potência padrão de tiro
    private static final double TURN_ANGLE = 10; // Ângulo de virada padrão
    private static final double MIN_DISTANCE = 150; // Distância mínima para manter do inimigo
    private static final double WALL_MARGIN = 50; // Margem de segurança para evitar a parede

    public void run() {
       


        while (true) {
            move();
            execute();
        }
    }

    private void move() {
        setTurnRight(TURN_ANGLE);
        setMaxVelocity(MAX_SPEED);
        ahead(Double.POSITIVE_INFINITY);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        // Se o inimigo estiver muito perto, recuar para manter uma distância segura
        if (e.getDistance() < MIN_DISTANCE) {
            setBack(Double.POSITIVE_INFINITY);
        } else {
            // Calcular o ângulo para mirar no inimigo
            double angleToEnemy = getHeadingRadians() + e.getBearingRadians();
            // Ajustar o ângulo para mirar no inimigo, considerando a previsão de movimento
            double adjustedAngle = Utils.normalRelativeAngle(angleToEnemy - getGunHeadingRadians());
            // Mirar na direção do inimigo
            turnGunRightRadians(adjustedAngle);
            // Atirar no inimigo
            fire(FIRE_POWER);
        }
    }

    public void onHitRobot(HitRobotEvent e) {
        // Se a colisão foi causada pelo próprio robô, ajustar a posição para evitar colisões contínuas
        if (e.isMyFault()) {
            back(50);
            turnRight(90);
        }
    }
}